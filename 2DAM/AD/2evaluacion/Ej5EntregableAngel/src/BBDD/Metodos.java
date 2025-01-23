package BBDD;

import Modelo.Cliente;
import Modelo.Dato_fiscal;
import Modelo.Poblacion;
import Vista.Ej5EntregableAngel;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Angel
 */
public class Metodos {
    
    public static boolean crearBaseDatos(Connection gestor,String bd){
        boolean temp=false;
        if (!ExisteBD(gestor, "audiogil")) {
            String linea="";
            String consulta="";
            File f=new File(bd);
            try {
                BufferedReader br=new BufferedReader(new FileReader(f));
                Statement sta=gestor.createStatement();
                while((linea=br.readLine())!=null){
                    if (!linea.isEmpty() && !linea.startsWith("--")) {
                        consulta+=linea;
                        if (consulta.endsWith(";")) {
                            sta.execute(consulta);
                            consulta="";
                            temp=true;
                        }
                    }

                }
                br.close();
                sta.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Ej5EntregableAngel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Ej5EntregableAngel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }//cierre if
        
        
        return temp;
    }
    
    private static boolean ExisteBD(Connection gestor,String nombre){
        boolean existe=false;
        try {
            Statement sta=gestor.createStatement();

            String consulta = "SELECT COUNT(*) AS total FROM information_schema.schemata WHERE schema_name = '" + nombre + "'";
            ResultSet rs=sta.executeQuery(consulta);
            if (rs.next()) {
                //si hay mas de 0 bd con ese nombre ya existe
                if(rs.getInt("total")>0){
                    existe=true;

                }
            }
            rs.close();
            sta.close();
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }

        return existe;
    }
    
    public static void use(Connection gestor,String nombrebd){
        try {
            Statement stmt=gestor.createStatement();
            String use="USE "+nombrebd+";";
            stmt.execute(use);
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
    
    public static int traspasoPoblaciones(Connection bdPostgres,Connection bdMySql){
        int insertado=0;
        try {
            
            String consulta="select codigo,nombre from poblaciones";
            Statement staPostgres=bdPostgres.createStatement();
            Statement staMySql=bdMySql.createStatement();
            
            List<Poblacion> poblacionesList = new ArrayList<>();
            ResultSet rs=staPostgres.executeQuery(consulta);
            while(rs.next()){
                int codigo=rs.getInt("codigo");
                String nombre=rs.getString("nombre");
                
                Poblacion poblacion=new Poblacion(codigo,nombre);
                poblacionesList.add(poblacion);
            }
            
            for(Poblacion p:poblacionesList){
                String consultaInsert = "INSERT IGNORE INTO poblaciones (codigo, nombre) VALUES (" + p.getCodigo() + ", '" + p.getNombre() + "')";
                staMySql.executeUpdate(consultaInsert);
                insertado++;
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return insertado;
    }
    
    public static int traspasoAnotaciones(Connection bdPostgres,Connection bdMySql){
        int traspaso=0;
        try {

            Statement staPostgres=bdPostgres.createStatement();
            Statement staMySql=bdMySql.createStatement();
            //primero saco el codigo de cuenta_clietne que tiene que estar rellenada primero
            String select="select codigo,debe,haber,fecha from cuentas";
            
            String selectcc="select codigo from cuenta_cliente";
            
            ResultSet result=staMySql.executeQuery(selectcc);
            while(result.next()){
                long codigo=result.getLong("codigo");
                String insert="insert into anotaciones(cc) values"+"("+codigo+")";
            }
            //cc rellenado de la tabla cuenta_cliente que ya existe y esta en mysql
            
            
            ResultSet rs=staPostgres.executeQuery(select);
            while(rs.next()){
                long codigo=rs.getLong("codigo");
                double debe=rs.getDouble("debe");
                double haber=rs.getDouble("haber");
                Date fecha=rs.getDate("fecha");
                String insert = "INSERT INTO anotaciones (debe, haber, fecha) VALUES ("+ debe + ", " + haber + ", '" + fecha + "');";
                staMySql.execute(insert);
            }
            //ahora la tabla anotaciones ya esta rellenada del todo con los datos de postgres vieja
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return traspaso;
    }
    
    
    
    public static int traspasoCuenta_cliente(Connection bdPostgres,Connection bdMySql){
        int traspaso=0;
        //anotaciones tiene que estar antes creada
        try {
            Statement staPostgres=bdPostgres.createStatement();
            Statement staMySql=bdMySql.createStatement();
            String consultaPostgres = "SELECT codigo,tipo FROM cuentas";
            Statement stmt = bdPostgres.prepareStatement(consultaPostgres);
            ResultSet result=staPostgres.executeQuery(consultaPostgres);
            while(result.next()){
                long codigo=result.getLong("codigo");
                String tipo=result.getString("tipo");
                double saldo=0.0;
                String codigoStr = String.valueOf(codigo);
                String consultaAnotaciones = "SELECT SUM(debe) AS total_debe, SUM(haber) AS total_haber " + "FROM anotaciones WHERE cc = " + codigoStr;
                ResultSet rsAnotaciones = staMySql.executeQuery(consultaAnotaciones);
                if (rsAnotaciones.next()) {
                    double totalDebe = rsAnotaciones.getDouble("total_debe");
                    double totalHaber = rsAnotaciones.getDouble("total_haber");
                    //  saldo = (Haber - Debe)
                    saldo = totalHaber - totalDebe;
                }
                String repite="select codigo from cuenta_cliente";
                ResultSet temp=staMySql.executeQuery(repite);
                boolean aux=false;
                while (temp.next()) {
                    if (temp.getString("codigo").equals(codigoStr)) {
                        aux=true;
                    }
                }
                String consultaInsert="insert into cuenta_cliente (codigo,tipo,saldo) VALUES ("+codigoStr+",'"+tipo+"',"+saldo+")";
                if (!aux) {
                    staMySql.execute(consultaInsert);
                    traspaso++;
                }
                
            }
            
            
           
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return traspaso;
    }
    
    
    
    
    
    public static int traspasoClientes(Connection bdPostgres,Connection bdMySql){
        int insertado=0;
        try {
            String consulta="select count(id) from clientes";
            
            //ahora estoy conectandome a la vieja para ver cuantos clientes hay 
            String consultaInsert = "INSERT INTO clientes (Telf_contacto) VALUES (NULL)";
            Statement staPostgres=bdPostgres.createStatement();
            Statement staMySql=bdMySql.createStatement();
            List<Cliente> clientesList = new ArrayList<>();
            ResultSet rs=staPostgres.executeQuery(consulta);
            int numeroClientes=0;
            if(rs.next()){
                numeroClientes=rs.getInt(1);
            }
            //ahora ya se cuanto clientes hay en la anterior bd
            for (int i = 0; i < numeroClientes; i++) {
                staMySql.execute(consultaInsert);
            }
            //ahora estan todos puestos todos los telefonos a null
            
            //ahora voy a rellenar el id de Dato_Fiscal
            for (int i = 0; i < numeroClientes; i++) {
                String consultaInsertDatoFiscal="Insert into clientes(Dato_fiscal) VALUES("+i+")";
                staMySql.executeUpdate(consultaInsertDatoFiscal);
                insertado++;
            }
            
            staPostgres.close();
            staMySql.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return insertado;
    }
    
    
    public static boolean traspasoADatosFiscales(Connection bdPostgres,Connection bdMySql){
        boolean traspaso=false;
        //la postgres es la del 127 y la mysql lo de siempre
        
        //a la bd vieja de postgres
        String consulta1="select nif,nombre,apellidos,cp,cc from clientes";
        try {
            Statement staPostgres=bdPostgres.createStatement();
            Statement staMySql=bdMySql.createStatement();
            
            //lista para guardar datos fiscales nuevos
            List<Dato_fiscal> datosFiscalesList = new ArrayList<>();
            //uso la de postgres(vieja)
            
            
            ResultSet rs=staPostgres.executeQuery(consulta1);
            while (rs.next()) {
                String nif = rs.getString("nif");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                int cp = rs.getInt("cp");
                long cc = rs.getLong("cc");
                Dato_fiscal datoFiscal = new Dato_fiscal(nif, nombre, apellidos, cp, cc); 
                datosFiscalesList.add(datoFiscal);
            }
            //uso la mysql nueva
            
            for (Dato_fiscal df : datosFiscalesList) {
                String consultaInsertarDatosfiscales = "INSERT INTO datos_fiscales (nif, nombre, apellidos, cp, cc) VALUES ('" + df.getNif() + "', '" + df.getNombre() + "', '" + df.getApellidos() + "', '" + df.getCp() + "', " + df.getCc() + ")";
                staMySql.executeUpdate(consultaInsertarDatosfiscales);
                traspaso=true;
            }
            staPostgres.close();
            staMySql.close();
            rs.close();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return traspaso;
    }
    
    
}

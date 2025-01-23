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
import java.sql.PreparedStatement;
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
            staPostgres.close();
            staMySql.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return insertado;
    }
    
    public static int traspasoAnotaciones(Connection bdPostgres,Connection bdMySql){
        int traspaso=0;
        try {

            Statement staPostgres=bdPostgres.createStatement();
            //primero saco el codigo de cuenta_clietne que tiene que estar rellenada primero
            String select="select codigo,fecha,debe,haber from cuentas order by codigo";
            ResultSet result=staPostgres.executeQuery(select);
            
            while(result.next()){
                String insert = "INSERT INTO anotaciones (cc, debe, haber, fecha) VALUES (?,?,?,?)";
                String cc = String.valueOf(result.getLong("codigo"));
                Date fecha = result.getDate("fecha");
                double debe = result.getDouble("debe");
                double haber = result.getDouble("haber");
                PreparedStatement staMySql=bdMySql.prepareStatement(insert);
                staMySql.setString(1, cc);
                staMySql.setDouble(2, debe);  
                staMySql.setDouble(3, haber);  
                staMySql.setDate(4, fecha);
                staMySql.executeUpdate();
                traspaso++;
            }
            //cc rellenado de la tabla cuenta_cliente que ya existe y esta en mysql
            //ahora la tabla anotaciones ya esta rellenada del todo con los datos de postgres vieja
            staPostgres.close();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return traspaso;
    }
    
    
    
    public static int traspasoCuenta_cliente(Connection bdPostgres,Connection bdMySql){
        int traspaso=0;
        double saldo=0.0;
        //anotaciones tiene que estar antes creada
        try {
            Statement staPostgres=bdPostgres.createStatement();
            Statement staMySql=bdMySql.createStatement();
            String consultaPostgres = "SELECT * FROM cuentas";
            Statement stmt = bdPostgres.createStatement();
            ResultSet result=stmt.executeQuery(consultaPostgres);
            while(result.next()){
                long codigo=result.getLong("codigo");
                String tipo=result.getString("tipo");
                
                String codigoStr = String.valueOf(codigo);

                String consultaAnotaciones = "SELECT SUM(debe) AS total_debe, SUM(haber) AS total_haber " + "FROM cuentas WHERE codigo = " + codigoStr;
                ResultSet rsAnotaciones = staPostgres.executeQuery(consultaAnotaciones);
                if (rsAnotaciones.next()) {
                    double totalDebe = rsAnotaciones.getDouble("total_debe");
                    double totalHaber = rsAnotaciones.getDouble("total_haber");

                    saldo = totalHaber - totalDebe;
//                    System.out.println("debe: "+totalDebe);
//                    System.out.println("haber: "+totalHaber);
//                    System.out.println("saldo: "+saldo+"\n");
                }
                rsAnotaciones.close();
                
                if (!repiteCuenta_Cliente(staMySql.getConnection(),codigoStr)) {
                    String consultaInsert="insert into cuenta_cliente (codigo,tipo,saldo) VALUES ('"+codigoStr+"','"+tipo+"',"+saldo+")";

                    staMySql.execute(consultaInsert);
                    traspaso++;
                    saldo = 0;
                }
            }
            stmt.close();
            result.close();
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return traspaso;
    }
    private static boolean repiteCuenta_Cliente(Connection bdMySql,String codigoStr){
        boolean repita=false;
        try {
            
            Statement staMySql=bdMySql.createStatement();
            String consultarepita="select codigo from cuenta_cliente where codigo="+codigoStr;
            ResultSet rsRepita =staMySql.executeQuery(consultarepita);
            if (rsRepita.next()) {
                repita=true;
            }
            rsRepita.close();
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return repita;
    }
    
    
    public static int traspasoADatosFiscales(Connection bdPostgres,Connection bdMySql){
        int traspaso=0;
        try {
            //la postgres es la del 127 y la mysql lo de siempre
            //a la bd vieja de postgres
            String consulta1="select * from clientes";
            Statement stPostgres=bdPostgres.createStatement();
            ResultSet rs=stPostgres.executeQuery(consulta1);
            while (rs.next()) {                
                String nif=rs.getString("nif");
                String nombre=rs.getString("nombre");
                String apellidos=rs.getString("apellidos");
                int cp = rs.getInt("cp");
                long cc = rs.getLong("cc");
                
                String consultaInsert="insert into datos_fiscales (nif,nombre,apellidos,cp,cc) values (?,?,?,?,?)";
                PreparedStatement pstMySql=bdMySql.prepareStatement(consultaInsert,Statement.RETURN_GENERATED_KEYS);
                pstMySql.setString(1,nif);
                pstMySql.setString(2,nombre);
                pstMySql.setString(3,apellidos);
                pstMySql.setInt(4,cp);
                pstMySql.setLong(5,cc);
                pstMySql.executeUpdate();
                
                ResultSet codigoCliente = pstMySql.getGeneratedKeys();
                if (codigoCliente.next()) {
                    int codigo = codigoCliente.getInt(1);
                    String consultaInsertarClientes = "INSERT INTO clientes (dato_fiscal) VALUES (" + codigo + ")";
                    Statement stMySql = bdMySql.createStatement();
                    stMySql.executeUpdate(consultaInsertarClientes);
                    
                    stMySql.close();
                }
                codigoCliente.close();
                traspaso++;
            }
            rs.close();
            stPostgres.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return traspaso;
    }
    
    
}

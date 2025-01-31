
package BBDD;

import Modelo.Cliente;
import Modelo.Pedido;
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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Angel
 */
public class Metodos {

    public static boolean crearBD(Connection bdMysql,String bd){
        boolean creada=false;
        File f=new File(bd);

        try {       
            FileReader fr=new FileReader(f);
            BufferedReader br=new BufferedReader(fr);
            Statement sta=bdMysql.createStatement();
            String linea="";
            String consulta="";
            while((linea=br.readLine())!=null){
                if (!linea.startsWith("--") && !linea.isEmpty()) {
                    consulta+=linea;
                    if (linea.endsWith(";")) {
                        sta.executeUpdate(consulta);
                        consulta="";
                        creada=true;
                    }
                }
            }
            sta.close();
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return creada;
    }
    
    public static void use(Connection c){
        String use="use examen";
        try {
            Statement sta=c.createStatement();
            sta.execute(use);
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void borrarPedidos(Connection conexion,int id){
        try {
            Statement sta=conexion.createStatement();
            sta.executeUpdate("DELETE FROM pedidos WHERE cliente = "+id);
            sta.close();
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void cancelarPedido(Connection conexion,int id){
        try {
            Statement sta=conexion.createStatement();
            sta.executeUpdate("DELETE FROM pedidos WHERE codigo = "+id);
            sta.close();
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public static boolean altaCliente(Connection gestor,Cliente c){
        boolean temp=false;
        use(gestor);
        try {
            Statement sta=gestor.createStatement();
            String query="select dni from clientes where dni='"+c.getDni()+"'";
            String insert="insert into clientes (nombre,apellidos,dni) values ('"+c.getNombre()+"','"+c.getApellidos()+"','"+c.getDni()+"');";
            ResultSet rs=sta.executeQuery(query);
            if (!rs.next()) {
                sta.executeUpdate(insert);
                temp=true;
            }
            
            rs.close();
            sta.close();
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }

        return temp;
    }
    
    public static boolean modificarCliente(Connection gestor,Cliente nuevoCliente,int idViejo){
        boolean temp=false;
        String insert="insert into clientes (nombre,apellidos,dni) values (?,?,?)";
        
        try {

            PreparedStatement psta=gestor.prepareStatement(insert,Statement.RETURN_GENERATED_KEYS);
            psta.setString(1,nuevoCliente.getNombre());
            psta.setString(2, nuevoCliente.getApellidos());
            psta.setString(3, nuevoCliente.getDni());
            psta.executeUpdate();
            int idNuevoCliente=0;
            ResultSet idrs=psta.getGeneratedKeys();
            if (idrs.next()) {
                idNuevoCliente=idrs.getInt(1);
            }
            
            psta.close();
            idrs.close();
            
           
            //ya está creado el nuevo cliente ,ahora guardarme sus pedidos con el idViejo
            String consultaSelect ="select * from pedidos where cliente=?";
            PreparedStatement pstmt=gestor.prepareStatement(consultaSelect);
            pstmt.setInt(1, idViejo);
            ResultSet rs=pstmt.executeQuery();
            while(rs.next()){
                int codigoPedido=rs.getInt("codigo");
                Date fecha=rs.getDate("fecha");
                int cantidad=rs.getInt("cantidad");
                String insertarPedidos="insert into pedidos (codigo,cliente,fecha,cantidad) values (?,?,?,?)";
                PreparedStatement ps=gestor.prepareStatement(insertarPedidos);
                ps.setInt(1,codigoPedido);
                ps.setInt(2,idNuevoCliente);
                ps.setDate(3, fecha);
                ps.setInt(4, cantidad);
                ps.executeUpdate();  
                temp=true;
            }
            rs.close();
            pstmt.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return temp;
    }
    
    public static boolean hacerPedido(Connection gestor,Pedido p){
        boolean temp=false;
        boolean existe=true;
        use(gestor);
        String insertar="insert into pedidos (cliente,fecha,cantidad) values ("+p.getCliente()+",CURRENT_DATE,"+p.getCantidad()+");";
        
        String select="select count(id) from clientes where id="+p.getCliente();
        try {
            Statement stmt=gestor.createStatement();
            ResultSet rs = stmt.executeQuery(select);
            int numero=0;
            if (rs.next()) {
                numero=rs.getInt(1);     
            }
            if (numero==0) {
                //no existe cliente 
                existe=false;
            }
            
            stmt.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (existe) {
           try {
                Statement sta=gestor.createStatement();
                sta.executeUpdate(insertar);
                temp=true;

                sta.close();
            } catch (SQLException ex) {
                Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
          
        return temp;
    }
    
}

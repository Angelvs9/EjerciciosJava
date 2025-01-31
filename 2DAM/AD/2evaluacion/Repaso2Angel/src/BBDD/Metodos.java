
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
    
    public static boolean modificarCliente(Connection gestor,Cliente nuevocliente,int idCliente){
        boolean temp=false;
        String updateCliente = "UPDATE Clientes SET dni=?,nombre=?,apellidos=? WHERE id=?";
        String updatePedidos= "Update pedidos set cliente=? where cliente=?";
        try {
            PreparedStatement psta=gestor.prepareStatement(updateCliente);
            psta.setString(1, nuevocliente.getDni());
            psta.setString(2, nuevocliente.getNombre());
            psta.setString(3, nuevocliente.getApellidos());
            psta.setInt(4, idCliente);
            psta.executeUpdate();
            psta.close();
            temp=true;
            
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

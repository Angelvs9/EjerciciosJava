
package BBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Angel
 */
public class gestorConexion {
    Connection conn;

    public gestorConexion(String u,String user,String password) {
        try {
            conn=DriverManager.getConnection(u,user,password);
            if (conn!=null) {
                //bien
                System.out.println("conectado a "+u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(gestorConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public Connection getConn(){
        return conn;
    }
    
    
    public void cerrar_Conexion (){
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println("ERROR:al cerrar la conexión");
            ex.printStackTrace();
        }
    }//cierra conexion
    
    
}

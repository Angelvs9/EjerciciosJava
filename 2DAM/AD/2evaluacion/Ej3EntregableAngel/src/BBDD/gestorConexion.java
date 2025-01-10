package BBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Angel
 */
public class gestorConexion {
    
    Connection conexion=null;
    
    public gestorConexion() {
        try {
            String url="jdbc:mysql://localhost:3306/";
            String user="root";
            String passwd="";
            conexion=DriverManager.getConnection(url,user,passwd);
            if (conexion!=null) {
                System.out.println("url conectada: "+url);
            }
        } catch (SQLException ex) {
            Logger.getLogger(gestorConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
    }

    public Connection getConexion() {
        return conexion;
    }
    
    
    public void cerrar_Conexion (){
        try {
            conexion.close();
        } catch (SQLException ex) {
            System.out.println("ERROR:al cerrar la conexión");
            ex.printStackTrace();
        }
    }//cierra conexion
    
}


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
public class Conexion {
    private Connection conexion;

    public Conexion(){
        String url="jdbc:mysql://localhost:3306/";
        String user="root";
        String password="";
        try {
            conexion=DriverManager.getConnection(url, user, password);
            if (conexion!=null) {
                System.out.println("conectado a agilges");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Connection getConexion(){
        return conexion;
    }
    
    public void cerrarConexion(){
        try {
            conexion.close();
            System.out.println("cerrada la conexion");
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}

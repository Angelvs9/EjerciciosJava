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
public class GestorConexion {
    private Connection conexion;

    public GestorConexion() {
        String url="jdbc:mysql://localhost:3306/";
        String user="root";
        String pass="";
        try {
            conexion=DriverManager.getConnection(url, user, pass);
            if (conexion!=null) {
                System.out.println("todo bien");
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestorConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public Connection getConexion() {
        return conexion;
    }
    
    public void cerrar_Conexion(){
        try {
            conexion.close();
            System.out.println("cerrado");
        } catch (SQLException ex) {
            Logger.getLogger(GestorConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

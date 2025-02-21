
package BBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class gestorConexion {
    private Connection conexion;

    public gestorConexion() {
        String url="jdbc:mysql://localhost:3306";
        String user="root";
        String password="";
        try {
            conexion=DriverManager.getConnection(url, user, password);
            if (conexion!=null) {
                System.out.println("conectado");
            }
        } catch (SQLException ex) {
            Logger.getLogger(gestorConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    public Connection getConexion(){
        return conexion;
    }
    
    public static void use(Connection conexion){
        String use="use vending";
        try {
            Statement sta=conexion.createStatement();
            sta.execute(use);
            sta.close();
        } catch (SQLException ex) {
            Logger.getLogger(gestorConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void cerrar(){
        try {
            conexion.close();
            System.out.println("cerrado");
        } catch (SQLException ex) {
            Logger.getLogger(gestorConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
}

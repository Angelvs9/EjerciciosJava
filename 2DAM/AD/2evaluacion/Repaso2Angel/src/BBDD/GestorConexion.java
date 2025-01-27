
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
    
    Connection connection;
    
    public GestorConexion(){
        String url="jdbc:mysql://localhost:3306/";
        String user="root";
        String password="";
        try {
            connection=DriverManager.getConnection(url,user,password);
            if (connection!=null) {
                System.out.println("conectado a mysql");
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestorConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Connection getConexion(){
        return connection;
    }
    
    public void cerrarConexion(){
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(GestorConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

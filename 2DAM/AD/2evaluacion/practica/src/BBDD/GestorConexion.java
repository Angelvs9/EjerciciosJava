
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
public class GestorConexion {
    
    private Connection conexion;

    public GestorConexion() {
        String url="jdbc:mysql://localhost:3306/";
        String user="root";
        String password="";
        try {
            conexion=DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            Logger.getLogger(GestorConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public Connection getConexion() {
        return conexion;
    }
  
    
    public void use(String bd){
        try {
            Statement sta=conexion.createStatement();
            sta.execute("use "+bd);
            sta.close();
        } catch (SQLException ex) {
            Logger.getLogger(GestorConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
  
    }
    
    public void cerrar(){
        try {
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(GestorConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}

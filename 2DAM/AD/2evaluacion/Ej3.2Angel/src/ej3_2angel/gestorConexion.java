
package ej3_2angel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class gestorConexion {

    Connection conexion=null;
    
    public gestorConexion(String bd,String url,String user,String passwd) {
        try {
//            String bd="addamagil0";
//            String url = "jdbc:mysql://db4free.net:3306/"+bd; 
//            String user = "tgilito"; 
//            String passwd = "qwerty22";
            conexion=DriverManager.getConnection(url+bd,user,passwd);
            if (conexion!=null) {
                Statement stmt = conexion.createStatement();
                String use = "USE "+bd;
                try {
                    // Ejecutar el comando USE para seleccionar la base de datos cuando ya está disponible
                    stmt.executeUpdate(use);  
                    System.out.println("gestor conectado");
                    
                } catch (SQLException e) {
                    System.out.println("no se encuentra "+bd);
                    e.printStackTrace();  
                }
            }
        } catch (SQLException ex) {
            System.out.println("no se puede conectar con sql osea el problema es de la conexion no de la bd");
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


package Vista;

import BBDD.Metodos;
import BBDD.gestorConexion;
import static BBDD.Metodos.crearBD;
import static BBDD.Metodos.subirFoto;
import static BBDD.Metodos.descargarFoto;
import static BBDD.Metodos.use;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Angel
 */
public class main {


    public static void main(String[] args) {
    gestorConexion gestor=new gestorConexion();
    boolean creada=false;
        try {
            Statement comprobacion = gestor.getConn().createStatement();
            String query = "SELECT COUNT(*) > 0 AS database_exists FROM information_schema.schemata WHERE schema_name = 'minferreteria';";
            ResultSet comprobacionRs = comprobacion.executeQuery(query);
            int numero=0;
            if (comprobacionRs.next()) {
                numero = comprobacionRs.getInt("database_exists");
            }
            comprobacionRs.close();
            comprobacion.close();
            
            
            comprobacion.close();
            if (numero==0) {
                crearBD(gestor.getConn(),"BBDD.sql");
                
                
            }
            System.out.println("bd creada");
            
            Statement stmt = gestor.getConn().createStatement();
            
            
            
            
            use(gestor.getConn());
            ResultSet rs = stmt.executeQuery("SELECT MAX(ncodigo) FROM clientes");
            int n=0;
            if (rs.next()) {
                n=rs.getInt(1);
            }
            rs.close();
            stmt.close();
            
            Scanner sc=new Scanner(System.in);
            System.out.println("pon un numero del 1 al "+n+" (a excepcion del 2)");
            int temp=sc.nextInt();
            sc.nextLine();
            System.out.println("pon el nombre de la foto que quieres subir: ");
            String foto=sc.nextLine();
            System.out.println("subiendo la foto proporcionada a la persona con este codigo: (con extensión)"+temp);
            System.out.println("subida foto al cliente con codigo: "+temp+" ---> "+ subirFoto(gestor.getConn(), temp, foto));
            System.out.println("descargando foto...");
            descargarFoto(gestor.getConn(), temp);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        gestor.cerrar_Conexion();
    }
    
}

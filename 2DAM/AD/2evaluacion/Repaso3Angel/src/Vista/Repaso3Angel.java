
package Vista;

import BBDD.Conexion;
import BBDD.Metodos;
import static BBDD.Metodos.*;

/**
 * @author Angel
 */
public class Repaso3Angel {


    public static void main(String[] args) {
        Conexion c=new Conexion();
        
        crearBD(c.getConexion(), "BBDD.sql");
    }
    
}

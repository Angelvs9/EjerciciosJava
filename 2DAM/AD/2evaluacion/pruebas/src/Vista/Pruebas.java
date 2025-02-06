
package Vista;

import BBDD.GestorConexion;
import BBDD.Metodos;
import static BBDD.Metodos.insertarCoche;
import static BBDD.Metodos.leerCoches;
import static BBDD.Metodos.use;
import static BBDD.Metodos.insertarImagen;
import Modelo.Coche;

/**
 *
 * @author Angel
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GestorConexion conexion=new GestorConexion();
        use(conexion.getConexion());
        Coche coche=new Coche("roja","415784554ad");
        Coche coche2=new Coche("verde","25555FD");
        insertarCoche(conexion.getConexion(),coche);
        insertarCoche(conexion.getConexion(),coche2);
        leerCoches(conexion.getConexion());
        
        
        
        
    }
    
}

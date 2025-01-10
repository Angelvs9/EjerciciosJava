
package Vista;

import BBDD.Metodos;
import static BBDD.Metodos.crearBD;
import BBDD.gestorConexion;

/**
 *
 * @author Angel
 */
public class Ej3EntregableAngel {

    public static void main(String[] args) {
        
        
        String bd="ferreteriaDDL.sql";
        gestorConexion g=new gestorConexion();
        //crear
        crearBD(g.getConexion(), bd);
        //aqui lo de insertar los datos
        
    }
    
}

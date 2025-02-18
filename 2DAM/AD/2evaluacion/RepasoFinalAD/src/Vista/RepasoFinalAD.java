package Vista;

import static BBDD.Metodos.*;
import BBDD.gestorConexion;
/**
 * @author Usuario
 */
public class RepasoFinalAD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        gestorConexion conexion= new gestorConexion();
        String bd="juntisima";
        //así solo lo uso una vez y no tengo que llamarlo dentro de cada metodo
        crearBD(conexion.getConexion(), "BBDD.sql");
        conexion.use(bd);
        
        
        
        
        conexion.cerrar();
    }
    
}

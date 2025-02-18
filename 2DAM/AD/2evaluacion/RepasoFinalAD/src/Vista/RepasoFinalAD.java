package Vista;

import static BBDD.Metodos.*;
import BBDD.gestorConexion;
import Modelo.Parroquia;
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
        //crearBD(conexion.getConexion(), "BBDD.sql");
        
        conexion.use(bd);
        Parroquia parroquia1 = new Parroquia(1, "Parroquia San José", "Calle Falsa 123", "Padre Juan");
        Parroquia parroquia2 = new Parroquia(2, "Parroquia Nuestra Señora de la Paz", "Avenida Libertad 456", "Padre Luis");
        Parroquia parroquia3 = new Parroquia(3, "Parroquia Santa María", "Calle Real 789", "Padre Pedro");
        Parroquia parroquia4 = new Parroquia(4, "Parroquia San Pedro", "Calle 22 de Octubre 101", "Padre Francisco");
        Parroquia parroquia5 = new Parroquia(5, "Parroquia San Andrés", "Avenida del Sol 202", "Padre Carlos");

        crearParroquias(conexion.getConexion(), parroquia1);
        crearParroquias(conexion.getConexion(), parroquia2);
        crearParroquias(conexion.getConexion(), parroquia3);
        crearParroquias(conexion.getConexion(), parroquia4);
        System.out.println(crearParroquias(conexion.getConexion(), parroquia5));
        
        System.out.println("CREADAS PARROQUIAS");
        
        
        
        conexion.cerrar();
    }
    
}

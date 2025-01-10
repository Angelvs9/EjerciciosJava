
package Vista;


import static BBDD.Metodos.crearBD;
import static BBDD.Metodos.insertarDatosBD;
import BBDD.gestorConexion;

/**
 *
 * @author Angel
 */
public class Ej3EntregableAngel {

    public static void main(String[] args) {
        
        
        String bd="ferreteriaDDL.sql";
        String datosbd="ferreteria_datosDML.sql";
        gestorConexion g=new gestorConexion();
        
        /*CREAR BD*/
        if (crearBD(g.getConexion(), bd)) {
            System.out.println("bd ferreteria creada correctamente");
        }
        else{
            System.out.println("no se puedo crear la bd");
        }
        
        /*INSERTO DATOS*/

        if (insertarDatosBD(g.getConexion(), datosbd)) {
            System.out.println("datos insertados correctamente");
        }
        else{
            System.out.println("no se insertaron los datos");
        }

        
        g.cerrar_Conexion();
    }
    
}

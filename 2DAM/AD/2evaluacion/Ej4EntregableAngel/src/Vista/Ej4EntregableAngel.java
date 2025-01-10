
package Vista;

import BBDD.Metodos;
import static BBDD.Metodos.crearBD;
import static BBDD.Metodos.insertarObjeto;
import static BBDD.Metodos.listarCoches;
import BBDD.gestorConexion;
import Modelo.Coche;
import Modelo.Vehiculo;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Angel
 */
public class Ej4EntregableAngel {


    public static void main(String[] args) {
        String bd="vehiculos.sql";
        gestorConexion g=new gestorConexion();
        
         
        //CREAR BD
        if (crearBD(g.getConn(), bd)) {
            System.out.println("bd vehiculos creada correctamente");
        }
        else{
            System.out.println("no se puedo crear la bd");
        }
        
        Vehiculo c1 = new Coche("Toyota", "Corolla", "ABC-123", "Rojo", 4, "B12345", 1200.5f);
        Vehiculo c2 = new Coche("Ford", "Mustang", "DEF-456", "Azul", 2, "C67890", 1100.3f);
        Vehiculo c3 = new Coche("Honda", "Civic", "GHI-789", "Blanco", 4, "D11223", 1350.0f);
        Vehiculo c4 = new Coche("BMW", "X5", "JKL-012", "Negro", 4, "E44556", 1500.2f);

        //inserto coches 
        if (insertarObjeto(g.getConn(), c1)) {
            System.out.println("El coche con bastidor " + c1.getBastidor() + " se ha insertado correctamente.");
        } else {
            System.out.println("No se pudo insertar el coche con bastidor " + c1.getBastidor());
        }

        if (insertarObjeto(g.getConn(), c2)) {
            System.out.println("El coche con bastidor " + c2.getBastidor() + " se ha insertado correctamente.");
        } else {
            System.out.println("No se pudo insertar el coche con bastidor " + c2.getBastidor());
        }

        if (insertarObjeto(g.getConn(), c3)) {
            System.out.println("El coche con bastidor " + c3.getBastidor() + " se ha insertado correctamente.");
        } else {
            System.out.println("No se pudo insertar el coche con bastidor " + c3.getBastidor());
        }

        if (insertarObjeto(g.getConn(), c4)) {
            System.out.println("El coche con bastidor " + c4.getBastidor() + " se ha insertado correctamente.");
        } else {
            System.out.println("No se pudo insertar el coche con bastidor " + c4.getBastidor());
        }
        System.out.println("______________________");
        System.out.println("Coches");
        List<Object> lista=listarCoches(g.getConn());
        for (Object coche : lista) {
           System.out.println(coche.toString()); 
        }

        g.cerrar_Conexion();
    }
    
}

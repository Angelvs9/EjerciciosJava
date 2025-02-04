
package Vista;

import BBDD.Conexion;
import BBDD.Metodos;
import static BBDD.Metodos.*;
import Modelo.Cliente;

/**
 * @author Angel
 */
public class Repaso3Angel {


    public static void main(String[] args) {
        Conexion conexion=new Conexion();
        
        //crearBD(c.getConexion(), "BBDD.sql");
        Cliente c=new Cliente("paco","molina","1245764K");
        
        if (crearCliente(conexion.getConexion(),c)) {
            System.out.println("insertado");
        }
        
        conexion.cerrarConexion();
        
    }
    
}

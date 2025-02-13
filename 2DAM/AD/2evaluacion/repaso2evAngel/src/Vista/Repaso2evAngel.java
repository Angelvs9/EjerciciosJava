package Vista;

import BBDD.GestorConexion;
import static BBDD.Metodos.*;
import Modelo.Canal;
/**
 * @author Usuario
 */
public class Repaso2evAngel {

    public static void main(String[] args) {
        GestorConexion conexion=new GestorConexion();
        //crearBD(conexion.getConexion(), "BBDD.sql");
        
        Canal c1=new Canal("hbo",4,6);
        int numeroCanal1=crearCanal(conexion.getConexion(), c1);
        System.out.println(numeroCanal1);
        
        conexion.cerrar();
    }
    
}

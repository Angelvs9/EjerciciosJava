package Vista;

import BBDD.GestorConexion;
import static BBDD.Metodos.*;
import Modelo.Canal;
import Modelo.Serie;
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
        //bfoto es la foto 
         
        //creo que la serie con todo menos la foto y ya dentro del metodo de insertar la serie le meto la foto con el setter
        Serie startrek= new Serie(1, "startrek", "accion", 1999, numeroCanal1, "startrek.jpg");
        
        
        conexion.cerrar();
    }
    
}

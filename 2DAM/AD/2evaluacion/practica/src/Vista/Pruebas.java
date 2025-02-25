
package Vista;

import BBDD.GestorConexion;
import static BBDD.Metodos.*;
import Modelo.Cosa;
import Modelo.OtraCosa;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */


public class Pruebas {
    
    public static byte [] FicheroAbytes(Connection conexion,String ruta){
        File f=new File(ruta);
        byte [] temp=new byte[(int)f.length()];
        try {
            FileInputStream fis=new FileInputStream(f);
            fis.read(temp);
            fis.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Pruebas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Pruebas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return temp;
    }
    
    

    public static void main(String[] args) {
        GestorConexion conexion=new GestorConexion();
        conexion.use("pruebas");
        
        byte [] fichero=FicheroAbytes(conexion.getConexion(), "fichero.pdf");

        OtraCosa oc1=new OtraCosa("Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...");
        OtraCosa oc2=new OtraCosa("Nam maximus porta eleifend. Vestibulum sit amet dui sollicitudin, tincidunt sem a, hendrerit justo. Aliquam pretium ante nibh, vel venenatis massa bibendum non.");
        Cosa c1=new Cosa(oc1,fichero);
        Cosa c2=new Cosa(oc2,fichero);
        
        int codigo1=insertarBD(conexion.getConexion(),c1);
        int codigo2=insertarBD(conexion.getConexion(),c2);
        bajarFicheroBD(conexion.getConexion(), 1);
        
        System.out.println(leerObjeto(conexion.getConexion(), codigo1));
        System.out.println(leerObjeto(conexion.getConexion(), codigo2));
        
        System.out.println("-----------------------------------------------------");
        System.out.println(leerArchivotxt(conexion.getConexion(), "resultado.txt"));
        
        
    }
    
}

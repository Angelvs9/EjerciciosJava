package Vista;

import static BBDD.Metodos.*;
import BBDD.gestorConexion;
import Modelo.Cofrades;
import Modelo.Cofradia;
import Modelo.Parroquia;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * @author Usuario
 */
public class RepasoFinalAD {
    
    public static byte[] fotoAByte(Connection conexion,String nombreFoto){
        byte[] b = new byte[(int)new File(nombreFoto).length()];
        try {
            FileInputStream fis=new FileInputStream(new File(nombreFoto));
            fis.read(b);
            fis.close();
            return b;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RepasoFinalAD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RepasoFinalAD.class.getName()).log(Level.SEVERE, null, ex);
        }
       return b;
    }
    
    
    
    public static void main(String[] args) {
        gestorConexion conexion= new gestorConexion();
        String bd="juntisima";
        //así solo lo uso una vez y no tengo que llamarlo dentro de cada metodo
        
        crearBD(conexion.getConexion(), "BBDD.sql");
        
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
        
        byte [] foto;
        foto=fotoAByte(conexion.getConexion(), "1.JPG");
        Cofradia cofra1=new Cofradia("nombre","direccion","1.JPG",foto,parroquia1.getNcodigo());
        int codigoCofradia1=crearCofradias(conexion.getConexion(), cofra1, parroquia1.getNcodigo());
        
        foto=fotoAByte(conexion.getConexion(), "2.JPG");
        Cofradia cofra2=new Cofradia("nombre2","direccion2","2.JPG",foto,parroquia2.getNcodigo());
        int codigoCofradia2=crearCofradias(conexion.getConexion(), cofra2, parroquia1.getNcodigo());
        
        
        System.out.println("CREADAS COFRADIAS");
   
        Cofrades cofrade1 = new Cofrades(codigoCofradia1, "Juan", "Perez", "123456789", 30);
        Cofrades cofrade2 = new Cofrades(codigoCofradia2, "Ana", "Lopez", "987654321", 28);
        
        //estos sin ponerle el codigo de la cofradia
        Cofrades cofrade3 = new Cofrades("Juancho", "garcia", "647156789", 30);
        Cofrades cofrade4 = new Cofrades("esperanza", "muñoz", "987254451", 28);
        
        int crearCofrades1 =crearCofrades(conexion.getConexion(),cofrade1);
        int crearCofrades2 =crearCofrades(conexion.getConexion(),cofrade2);
        int crearCofrades3 =crearCofrades(conexion.getConexion(),cofrade3);
        int crearCofrades4 =crearCofrades(conexion.getConexion(),cofrade4);
        
        System.out.println("CREADAS COFRADES");
        hacerPDF(conexion.getConexion());
        System.out.println("PDF HECHO");
        hacerCSV(conexion.getConexion());
        System.out.println("CSV HECHO");
        
        
        //mostrar por pantalla
        System.out.println(mostrar(conexion.getConexion()));
        
        
        
        
        
        
        
        conexion.cerrar();
    }
    
}

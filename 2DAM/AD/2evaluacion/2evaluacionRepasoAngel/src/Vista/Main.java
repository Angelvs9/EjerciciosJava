
package Vista;

import BBDD.Metodos;
import static BBDD.Metodos.*;
import BBDD.gestorConexion;
import Modelo.Canal;
import Modelo.Protagonista;
import Modelo.Serie;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Angel
 */
public class Main {


    public static byte[] convertirArchivoBytes(Connection conexion ,String archivo){
        byte[] foto;
        File f=new File(archivo);
        int longitud=(int)f.length();
        foto=new byte[longitud];
        try {
            FileInputStream fis=new FileInputStream(f);
            fis.read(foto);
            fis.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return foto;
    }
    
    
    public static void main(String[] args) {
        gestorConexion gestor=new gestorConexion();
        Connection conexion=gestor.getConexion();
        crearBD(conexion, "BBDD.sql");
        use(conexion);
        
        Canal canal1=new Canal("hbo",20,15);
        Canal canal2=new Canal("amazonprime",28,75);
        
        int codigoCanal1=crearCanal(conexion, canal1);
        int codigoCanal2=crearCanal(conexion, canal2);
        
        //me guardo las imagenes y as las voy usando 
        byte [] imagen1=convertirArchivoBytes(conexion,"drwho.jpg");
        byte [] imagen2=convertirArchivoBytes(conexion,"startrek.jpg");
        
        Serie drwho=new Serie(1,"drwho","misterio",1996,imagen1,codigoCanal1,"drwho.jpg");
        Serie star=new Serie(2,"star","guerra",2001,imagen2,codigoCanal2,"startrek.jpg");
        
        crearSerie(conexion, star);
        crearSerie(conexion, drwho);
        
        byte [] pdfdavid=convertirArchivoBytes(conexion,"david.pdf");
        byte [] pdfmat=convertirArchivoBytes(conexion,"mat.pdf");
        byte [] pdfwill=convertirArchivoBytes(conexion,"will.pdf");
        
        
        Protagonista david=new Protagonista(1, "david", 25, pdfdavid, drwho.getNcodigo(), "david.pdf");
        Protagonista mat = new Protagonista(2, "mat", 30, pdfmat, drwho.getNcodigo(), "mat.pdf");
        Protagonista will = new Protagonista(3, "will", 28, pdfwill, drwho.getNcodigo(), "will.pdf");
        
        crearProtagonista(conexion,david);
        crearProtagonista(conexion,mat);
        crearProtagonista(conexion,will);
        
    }
    
}

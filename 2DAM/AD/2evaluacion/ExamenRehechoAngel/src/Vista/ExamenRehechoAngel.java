package Vista;

import static BBDD.Metodos.*;
import BBDD.gestorConexion;
import static BBDD.gestorConexion.*;
import Modelo.Local;
import Modelo.Maquina;
import Modelo.Maquina_producto;
import Modelo.Nutriente;
import Modelo.Producto;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ExamenRehechoAngel {

    public static byte [] fotoBytes(Connection conexion, String archivo){
        byte [] foto;
        File f=new File(archivo);
        foto=new byte[(int)f.length()];
        try {
            FileInputStream fis=new FileInputStream(f);
            fis.read(foto);
            fis.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExamenRehechoAngel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ExamenRehechoAngel.class.getName()).log(Level.SEVERE, null, ex);
        }

        return foto;
    }
    
    public static void serializar(Connection conexion,Nutriente o){
        
    }
    
    
    
    public static void main(String[] args) {
        gestorConexion gestor=new gestorConexion();
        Connection conexion=gestor.getConexion();
        crearBD(conexion,"vending.sql");
        use(conexion);
        
        
        Local local1=new Local("burriana","C/Blasco");
        int codigoLocal1=crearLocal(conexion, local1);
        
        Local local2=new Local("Oropesa","plaza españa");
        int codigoLocal2=crearLocal(conexion, local2);
        //tengo codigo locales
        
        Maquina maquina1=new Maquina("modelitoderevista",15.3,2,codigoLocal1);
        Maquina maquina12=new Maquina("modvista",20.3,2.5,codigoLocal2);
        
        int codigomaquina1=crearMaquina(conexion, maquina1);
        int codigomaquina2=crearMaquina(conexion,maquina12);
        
        System.out.println("maquina:  "+codigomaquina1);
        
        Nutriente n1=new Nutriente(1, 2, 2, 2);
        Nutriente n2=new Nutriente(9, 12, 6, 5);
        
        //fotos
        byte [] capuchino=fotoBytes(conexion, "capuchino.jpg");
        byte [] cafe=fotoBytes(conexion, "cafe.jpg");
        byte [] agua=fotoBytes(conexion, "agua.jpg");
        byte [] cocacola=fotoBytes(conexion, "cocacola.jpg");
        
        Producto p1=new Producto("agua", 3, agua, n2);
        Producto p2=new Producto("cocacola", 4, cocacola, n1);
        Producto p3=new Producto("cafe", 2, cafe, n2);
        Producto p4=new Producto("capuchino", 2.5, capuchino, n2);
        
        int codigoAgua=crearProducto(conexion,p1);
        int codigoCocacola=crearProducto(conexion,p2);
        int codigocafe=crearProducto(conexion,p3);
        int codigocapuchino=crearProducto(conexion,p4);
        
        Maquina_producto mp1=new Maquina_producto(codigomaquina1,codigoAgua,20);
        Maquina_producto mp2=new Maquina_producto(codigomaquina2,codigoCocacola,50);
        
        insertarMaquinaProducto(conexion, mp1);
        insertarMaquinaProducto(conexion, mp2);
        
        System.out.println("todo insertado");
        gestor.cerrar();
        
    }
    
}

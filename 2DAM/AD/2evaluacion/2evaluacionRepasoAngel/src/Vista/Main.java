
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
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    
    public static String imprimir(Connection conexion){
        String temp="";
        String Select="select canales.ncodigo as codigoCanal,"
                + "canales.cnombre as nombreCanal, "
                + "canales.nprecio as precioCanal,"
                + "canales.nseries as numeroSeries,"
                + "series.ncodigo as codigoSerie,"
                + "series.ctitulo as tituloSerie,"
                + "series.cgenero as generoSerie,"
                + "series.nanyo as añoSerie,"
                + "series.ncanal as numeroCanal,"
                + "series.cfoto as nombreFoto,"
                + "protagonistas.ncodigo as codigoProta,"
                + "protagonistas.cnombre as nombreProta,"
                + "protagonistas.nedad as edadProta,"
                + "protagonistas.nserie as serieProta,"
                + "protagonistas.ccurriculum as cvProta"
                + " from series "
                + "left join canales on canales.ncodigo=series.ncanal "
                + "left join protagonistas on protagonistas.nserie=series.ncodigo";
        
        try {
            PreparedStatement psta=conexion.prepareStatement(Select);
            ResultSet rs=psta.executeQuery();
            while(rs.next()){
                temp += "Canal: Código Canal: " + rs.getInt("codigoCanal") + " | ";
                temp += "Nombre Canal: " + rs.getString("nombreCanal") + " | ";
                temp+="Precio Canal: " + rs.getDouble("precioCanal") + " | ";
                temp+="Número de Series: " + rs.getInt("numeroSeries") + " | \n";

                temp+="\t";
                temp += "Serie " + rs.getInt("codigoSerie") + ": Código Serie: " + rs.getInt("codigoSerie") + " | ";
                temp+="Título: " + rs.getString("tituloSerie") + " | ";
                temp += "Género: " + rs.getString("generoSerie") + " | ";
                temp += "Año: " + rs.getInt("añoSerie") + " | \n";

                temp+="\t\t";
                temp+= "Protagonistas: Código: " + rs.getInt("codigoProta") + " | ";
                temp +="Nombre: " + rs.getString("nombreProta") + " | ";
                temp+="Edad: " + rs.getInt("edadProta") + " | ";
                temp+= "Curriculum: " + rs.getString("cvProta") + " | ";

                temp += "\n\n";
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return temp;
    }
    
    public static void crearFichero(Connection conexion ,int idSerie){
        File f=new File("resultado.jpg");
        
        try {
            FileOutputStream fos=new FileOutputStream(f);
            String select="select bfoto from series where ncodigo=?";
            PreparedStatement psta=conexion.prepareStatement(select);
            psta.setInt(1, idSerie);
            ResultSet rs=psta.executeQuery();
            while (rs.next()) {                
                Blob b=rs.getBlob(1);
                byte[] byteArray=b.getBytes(1, (int)b.length());
                fos.write(byteArray);
            }
            rs.close();
            fos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public static void main(String[] args) {
        gestorConexion gestor=new gestorConexion();
        Connection conexion=gestor.getConexion();
        //crearBD(conexion, "BBDD.sql");
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
        
        
        System.out.println(imprimir(conexion));
        
        
        crearFichero(conexion,drwho.getNcodigo());
        
    }
    
}


package BBDD;

import Modelo.Cosa;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Metodos {
    
    
    public static int insertarBD(Connection conexion,Cosa c){
        int codigo=-1;
        try {
            PreparedStatement psta=conexion.prepareStatement("insert into tabla (objeto,fichero) values (?,?);",Statement.RETURN_GENERATED_KEYS);
            psta.setObject(1, c.getOtro());
            psta.setBytes(2, c.getFichero());
            psta.executeUpdate();
            ResultSet rs=psta.getGeneratedKeys();
            if (rs.next()) {
                codigo=rs.getInt(1);
            }
            psta.close();
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return codigo;
    }
    
    
    public static void bajarFicheroBD(Connection conexion,int id){
        try {
            //el id es el ncodigo de la tabla donde quiero bajarla
            FileOutputStream fos=new FileOutputStream(new File("resultado.pdf"));
            PreparedStatement psta=conexion.prepareStatement("select fichero from tabla");
            ResultSet rs=psta.executeQuery();
            if (rs.next()) {
                Blob b=rs.getBlob(1);
                byte [] data=b.getBytes(1, (int)b.length());
                fos.write(data);
            }
            fos.close();
            rs.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public static String leerObjeto(Connection conn,int id){
        Object data = null;
        String result="";
        try {
            PreparedStatement ps = conn.prepareStatement("select objeto from tabla where ncodigo=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Blob b = rs.getBlob(1);
                ObjectInputStream ois = new ObjectInputStream(b.getBinaryStream());
                data = ois.readObject();
                result=data.toString();
                escribirResultado(conn,result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
                
    private static void escribirResultado(Connection conexion,String contenido){
        File f=new File("resultado.txt");
        try {
            FileWriter fw=new FileWriter(f,true);
            fw.write(contenido);
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static String leerArchivotxt(Connection conexion,String ruta){
        String contenido="";
        File f=new File(ruta);
        try {
            String linea="";
            
            BufferedReader br=new BufferedReader(new FileReader(f));
            while((linea=br.readLine())!=null){
                contenido+=linea;
            }
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return contenido;
    }
    
    
}

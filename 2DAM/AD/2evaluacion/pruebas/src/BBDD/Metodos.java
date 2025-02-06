
package BBDD;

import Modelo.Coche;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
 * @author Angel
 */
public class Metodos {
    
    public static void insertarCoche(Connection conn,Coche c){
        ByteArrayOutputStream byteArray=new ByteArrayOutputStream();
        int codigo=-1;
        try {
            ObjectOutputStream oos=new ObjectOutputStream(byteArray);
            oos.writeObject(c);
            PreparedStatement psta=conn.prepareStatement("insert into tabla (coches) values (?)",Statement.RETURN_GENERATED_KEYS);
            psta.setBytes(1, byteArray.toByteArray());
            
            
            psta.execute();
            
            ResultSet rs=psta.getGeneratedKeys();
            if (rs.next()) {
                codigo=rs.getInt(1);
            }
            if (codigo!=-1) {
                insertarImagen(conn, "imagen.png",codigo);
            }
            psta.close();
            oos.close();
        } catch (IOException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void use(Connection c){
        try {
            Statement sta=c.createStatement();
            sta.executeUpdate("use pruebas");
            sta.close();
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static String leerCoches(Connection conn){
        String consulta="select coches from tabla";
        String coches="";
        try {
            use(conn);
            PreparedStatement psta=conn.prepareStatement(consulta);
            ResultSet rs=psta.executeQuery();
            while(rs.next()){
                Blob blob=rs.getBlob("coches");
                ObjectInputStream ois=new ObjectInputStream(blob.getBinaryStream());
                Coche temp=(Coche)ois.readObject();
                coches=temp.toString()+"\n";
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return coches;
    }
    
    public static void insertarImagen(Connection conn,String rutaImg,int codigo){
        File f=new File(rutaImg);
        try {
            FileInputStream fis=new FileInputStream(f);
            PreparedStatement psta=conn.prepareStatement("update tabla set imagen=? where ncodigo=?");
            psta.setBinaryStream(1, fis);
            psta.setInt(2, codigo);
            psta.executeUpdate();
            psta.close();
            fis.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}

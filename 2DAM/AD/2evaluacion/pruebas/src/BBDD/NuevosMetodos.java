/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BBDD;

import Modelo.Coche;
import com.itextpdf.text.pdf.qrcode.ByteArray;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
public class NuevosMetodos {
    
    public static void insertarImagenes(Connection c,String ruta){
        File f=new File(ruta);
        try {
            FileInputStream fis=new FileInputStream(f);
            PreparedStatement psta=c.prepareStatement("insert into tabla (imagenes) values (?)");
            psta.setBinaryStream(1, fis);
            psta.executeUpdate();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(NuevosMetodos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(NuevosMetodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public static void verImagenes(Connection c){
        File f=new File("resultado.png");
        try {
            FileOutputStream fos=new FileOutputStream(f);
            PreparedStatement psta=c.prepareStatement("select imagen from tabla");
            ResultSet rs=psta.executeQuery();
            while(rs.next()){
                Blob b=rs.getBlob("imagen");
                byte [] data=b.getBytes(1, (int) b.length());
                fos.write(data);
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(NuevosMetodos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(NuevosMetodos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(NuevosMetodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public static void insertarObjetos(Connection c,Coche peugeot){
        ByteArrayOutputStream byteArray=new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos=new ObjectOutputStream(byteArray);
            oos.writeObject(peugeot);
            PreparedStatement psta=c.prepareStatement("insert into tabla (coches) values (?)");
            psta.setBytes(1, byteArray.toByteArray());
            psta.executeUpdate();
                    
        } catch (IOException ex) {
            Logger.getLogger(NuevosMetodos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(NuevosMetodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public static void leerObjetos(Connection c){
        File f=new File("objetoReferencia");
        try {
            PreparedStatement psta=c.prepareStatement("select coches from tabla");
            ResultSet rs=psta.executeQuery();
            while(rs.next()){
                Blob b=rs.getBlob(1);
                ObjectInputStream ois=new ObjectInputStream(b.getBinaryStream());
                Coche o=(Coche)ois.readObject();
                System.out.println(o.toString());
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(NuevosMetodos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(NuevosMetodos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(NuevosMetodos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NuevosMetodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}

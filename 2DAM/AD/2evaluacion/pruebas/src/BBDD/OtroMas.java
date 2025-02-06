/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BBDD;

import Modelo.Coche;
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
public class OtroMas {
    
    public static void insertarObjeto(Connection c,Coche co){
        ByteArrayOutputStream byteArray=new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos=new ObjectOutputStream(byteArray);
            oos.writeObject(co);
            PreparedStatement psta=c.prepareStatement("insert into tabla (coches) values (?)");
            psta.setBytes(1, byteArray.toByteArray());
            psta.execute();
            psta.close();
                    
        } catch (IOException ex) {
            Logger.getLogger(OtroMas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(OtroMas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public static void leerObjecto(Connection c){
        try {
            PreparedStatement psta=c.prepareStatement("select coches from tabla");
            ResultSet rs=psta.executeQuery();
            while(rs.next()){
                Blob b=rs.getBlob("coches");
                ObjectInputStream ois=new ObjectInputStream(b.getBinaryStream());
                Object o=ois.readObject();
                System.out.println(o.toString());
            }
        } catch (SQLException ex) {
            Logger.getLogger(OtroMas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(OtroMas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OtroMas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void insertFichero(Connection c,String ruta){
        File f=new File(ruta);
        try {
            FileInputStream fis=new FileInputStream(f);
            PreparedStatement psta=c.prepareStatement("insert into tabla (imagen) values (?)");
            psta.setBinaryStream(1, fis);
            psta.execute();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OtroMas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(OtroMas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
    }
    
    public static void leerFichero(Connection c){
        File f=new File("resultado.txt");
        try {        
            PreparedStatement psta=c.prepareStatement("select imagen from tabla");
            ResultSet rs=psta.executeQuery();
            while(rs.next()){
                Blob b=rs.getBlob(1);
                byte[] data=b.getBytes(1, (int) b.length());
                FileOutputStream fos=new FileOutputStream(f);
                fos.write(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OtroMas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OtroMas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(OtroMas.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }
}


package BBDD;

import Modelo.Persona;
import Modelo.Tren;
import Modelo.Viaje;
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
    
    public static int crearViaje(Connection conexion,Viaje v){
        int codigo=-1;
        String insert="insert into viajes (origen,destino,tren) values (?,?,?);";
        try {
            PreparedStatement psta=conexion.prepareStatement(insert,Statement.RETURN_GENERATED_KEYS);
            psta.setString(1, v.getOrigen());
            psta.setString(2, v.getDestino());
            psta.setObject(3, v.getTren());
            psta.executeUpdate();
            ResultSet rs=psta.getGeneratedKeys();
            if (rs.next()) {
                codigo=rs.getInt(1);
            }
            
            rs.close();
            psta.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return codigo;
    }

    public static int crearPersona(Connection conexion,Persona v){
        int codigo=-1;
        String insert="insert into personas (nif,nombre,apellidos,viaje,foto) values (?,?,?,?,?);";
        try {
            PreparedStatement psta=conexion.prepareStatement(insert,Statement.RETURN_GENERATED_KEYS);
            psta.setString(1, v.getNif());
            psta.setString(2, v.getNombre());
            psta.setString(3, v.getApellidos());
            psta.setInt(4, v.getViaje());
            psta.setBytes(5, v.getFoto());
            psta.executeUpdate();
            ResultSet rs=psta.getGeneratedKeys();
            if (rs.next()) {
                codigo=rs.getInt(1);
            }
            
            rs.close();
            psta.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return codigo;
    }
    
    public static String desSerializar(Connection conexion,int codigoViaje){
        String select="select tren from viajes where id=?";
        String temp="";
        try {
            Object dato=null;
            PreparedStatement psta=conexion.prepareStatement(select);
            psta.setInt(1, codigoViaje);
            ResultSet rs=psta.executeQuery();
            while(rs.next()){
                Blob b=rs.getBlob(1);
                ObjectInputStream ois=new ObjectInputStream(b.getBinaryStream());
                
                dato=ois.readObject();
                temp=dato.toString();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return temp;
    }
    
}

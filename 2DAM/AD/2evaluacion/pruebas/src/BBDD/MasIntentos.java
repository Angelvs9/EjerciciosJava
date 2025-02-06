
package BBDD;

import Modelo.Coche;
import com.mysql.cj.protocol.Resultset;
import java.io.ByteArrayOutputStream;
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
public class MasIntentos {
    
    
    public static void insertObjeto(Connection c,Coche co){
        ByteArrayOutputStream byteArray=new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos=new ObjectOutputStream(byteArray);
            oos.writeObject(co);
            PreparedStatement psta=c.prepareStatement("insert into tabla (coches) values(?)");
            psta.setBytes(1, byteArray.toByteArray());
            psta.execute();
            
        } catch (IOException ex) {
            Logger.getLogger(MasIntentos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MasIntentos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public static void leerObjeto(Connection c){
        try {
            PreparedStatement psta=c.prepareStatement("select Imagen from tabla");
            ResultSet rs=psta.executeQuery();
            while(rs.next()){
                Blob b=rs.getBlob(1);
                ObjectInputStream ois=new ObjectInputStream(b.getBinaryStream());
                Object o=ois.readObject();
                System.out.println(o.toString());
            }
        } catch (SQLException ex) {
            Logger.getLogger(MasIntentos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MasIntentos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MasIntentos.class.getName()).log(Level.SEVERE, null, ex);
        }
                    
    }
    
    
}

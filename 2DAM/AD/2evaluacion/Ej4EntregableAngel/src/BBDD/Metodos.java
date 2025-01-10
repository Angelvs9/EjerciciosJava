
package BBDD;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Angel
 */
public class Metodos {
    
   public static boolean crearBD(Connection gestor,String bd){
        boolean temp=true;//para ejecutar el use una vez solo cuando ya se ha creado la bd
        boolean todoCorrecto=false;
        try {
            Statement stmt=gestor.createStatement();
            
            File f=new File(bd);
            BufferedReader br=new BufferedReader(new FileReader(f));
            String linea="";
            String consulta="";
            while((linea=br.readLine())!=null){
                
                if (linea!=" " && !linea.startsWith("--")) {
                    consulta+=linea;
                }

                if (consulta.endsWith(";")) {
                    stmt.execute(consulta);
                    if (temp) {
                        //se ejecuta solo una vez el use 
                        use(gestor);
                        temp=false;
                    }
                    consulta="";
                    //se supone que si ya has ejecutado 1 consulta el resto es igual
                    todoCorrecto=true;
                }
            }
                
        
            br.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return todoCorrecto;
    }
    
    public static void use(Connection gestor){
        try {
            Statement stmt=gestor.createStatement();
            String use="USE vehiculos";
            stmt.execute(use);
            stmt.close();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static boolean insertarObjeto(Connection gestor,Object o){
       boolean insertado=false;
       use(gestor);
        try {
           ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
           ObjectOutputStream oos=new ObjectOutputStream(byteArray);
           oos.writeObject(o);
           PreparedStatement ps = gestor.prepareStatement("insert into coche (coche) values(?)");
           ps.setBytes(1, byteArray.toByteArray());
           ps.execute();
           
           byteArray.close();
           oos.close();
           ps.close();
           insertado=true;
       } catch (IOException ex) {
           Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
       } catch (SQLException ex) {
           Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
       }
       return insertado;
    }
    
    
    public static List<Object> listarCoches(Connection gestor){
        use(gestor);
        List <Object> temp=new ArrayList<>();
        try {
           Object dato=null;
           PreparedStatement psta = gestor.prepareStatement("select coche from coche");
           ResultSet rs = psta.executeQuery();
           while (rs.next()) {
               Blob blob = rs.getBlob("coche");
               // Se reconstruye el objeto con un ObjectInputStream
               ObjectInputStream ois = new ObjectInputStream(blob.getBinaryStream());
               dato =  ois.readObject();
               temp.add(dato);
           }
           psta.close();
           rs.close();

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

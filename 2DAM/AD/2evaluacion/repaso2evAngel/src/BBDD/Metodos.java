
package BBDD;

import Modelo.Canal;
import Modelo.Serie;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Metodos {
    
    public static void crearBD(Connection conexion , String bd){
        File file=new File(bd);
        try {
            Statement sta=conexion.createStatement();
            String linea="";
            String consulta="";
            BufferedReader br=new BufferedReader(new FileReader(file));
            while((linea=br.readLine())!=null){
                if (!linea.isEmpty() && !linea.startsWith("-")) {
                    consulta+=linea;
                    if (consulta.endsWith(";")) {
                        sta.executeUpdate(consulta);
                        consulta="";
                    }
                }
            }
            sta.close();
            br.close();
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void use(Connection c){
        try {
            Statement sta=c.createStatement();
            sta.executeUpdate("use seriestv");
            sta.close();
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static int crearCanal(Connection conexion,Canal c){
        String insert="Insert into canales (cnombre,nprecio,nseries) values (?,?,?)";
        use(conexion);
        try {
            int ncodigo=0;
            PreparedStatement psta=conexion.prepareStatement(insert,Statement.RETURN_GENERATED_KEYS);
            psta.setString(1, c.getCnombre());
            psta.setInt(2, c.getNprecio());
            psta.setInt(3, c.getNseries());
            psta.executeUpdate();
            ResultSet rs=psta.getGeneratedKeys();
            if (rs.next()) {
                ncodigo=rs.getInt(1);
            }
            rs.close();
            psta.close();

            return ncodigo;
            
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    public static boolean crearSerie(Connection conexion,Serie s){
        File file=new File(s.getCfoto());
        try {
            FileInputStream fis=new FileInputStream(file);
            String insert="insert into series (ncodigo,ctitulo,cgenero,nanyo,bfoto,ncanal,cfoto) values (?,?,?,?,?,?,?)";
            
            PreparedStatement psta=conexion.prepareStatement(insert);
            psta.setInt(1, s.getNcodigo());
            psta.setString(2, s.getCtitulo());
            psta.setString(3, s.getCgenero());
            psta.setInt(4, s.getNanyo());
            //el 5 es la foto
            psta.setBinaryStream(5, fis);
            psta.setInt(6,s.getNcanal());
            psta.setString(7, s.getCfoto());
            psta.executeUpdate();
            psta.close();
            fis.close();
            return true;
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return false;
    }
    
}

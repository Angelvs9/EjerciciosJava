
package BBDD;

import Modelo.Cofradia;
import Modelo.Parroquia;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Usuario
 */
public class Metodos {
    
    public static void crearBD(Connection c,String archivo){
        File f=new File(archivo);
        try {
            Statement sta=c.createStatement();
            BufferedReader br=new BufferedReader(new FileReader(f));
            String linea="",consulta="";
            while((linea=br.readLine())!=null){
                if (!linea.isEmpty() && !linea.startsWith("-")) {
                    consulta+=linea;
                    if (consulta.endsWith(";")) {
                        sta.execute(consulta);
                        consulta="";
                    }
                }
            }
            br.close();
            sta.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static boolean crearParroquias(Connection conexion,Parroquia p){
        try {
            String temp="insert into parroquias (ncodigo,cnombre,cdireccion,csacerdote) values (?,?,?,?)";
            PreparedStatement psta=conexion.prepareStatement(temp);
            psta.setInt(1, p.getNcodigo());
            psta.setString(2, p.getCnombre());
            psta.setString(3,p.getCdireccion());
            psta.setString(4, p.getCsacerdote());
            psta.execute();
            psta.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    
    public static int crearCofradias(Connection conexion,Cofradia cofra,int codigoParroquia){
        int codigo=-1;
        String insert="insert into cofradias (cnombre,cdireccion,bfoto,cfichero,nparroquia) values (?,?,?,?,?);";
        try {
            PreparedStatement psta=conexion.prepareStatement(insert,Statement.RETURN_GENERATED_KEYS);
            psta.setString(1, cofra.getCnombre());
            psta.setBytes(3, cofra.getBfoto());
            psta.setString(2, cofra.getCdireccion());
            psta.setString(4, cofra.getCfichero());
            psta.setInt(5,codigoParroquia);
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
    
    
}

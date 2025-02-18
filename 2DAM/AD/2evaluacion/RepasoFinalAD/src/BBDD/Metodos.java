
package BBDD;

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
    
    
    
    
    
    
    
    
    
    
    
}

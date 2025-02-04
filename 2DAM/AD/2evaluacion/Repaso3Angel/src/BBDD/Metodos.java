package BBDD;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Angel
 */
public class Metodos {
    
    public static void crearBD(Connection conexion,String agilgesBD){
        try {
            File f=new File(agilgesBD);
            BufferedReader br=new BufferedReader(new FileReader(f));
            Statement sta=conexion.createStatement();
            String linea="";
            String consulta="";
            while((linea=br.readLine())!=null){
                if (!linea.startsWith("-") && !linea.startsWith(" ")) {
                    consulta+=linea;
                    if (consulta.endsWith(";")) {
                        System.out.println(consulta);
                        sta.executeUpdate(consulta);
                        consulta="";
                    }
                }
            }
            sta.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    public static void use(Connection c){
        try {
            String use="use agilges";
            Statement sta=c.createStatement();
            sta.executeUpdate(use);
            sta.close();
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
    
    
}

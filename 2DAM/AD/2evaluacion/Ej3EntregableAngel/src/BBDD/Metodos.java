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
    
    public static void crearBD(Connection gestor,String bd){
        
        try {
            Statement stmt=gestor.createStatement();
            String use="USE ferreteria";
            boolean useUsado=false;
            
            File f=new File(bd);
            BufferedReader br=new BufferedReader(new FileReader(f));
            String linea="";
            String consulta="";
            while((linea=br.readLine())!=null){
                
                if (linea!=" " && !linea.startsWith("--")) {
                    consulta+=linea;
                }

                if (consulta.endsWith(";")) {
                    
                    if (!useUsado) {
                       stmt.execute(use);
                       useUsado=true;
                        System.out.println("se crea chilling");
                    }
                    System.out.println("se ejecuta esto: "+consulta+"\n");
                    stmt.execute(consulta);
                    consulta="";
                    
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
    
    }
    
    
}

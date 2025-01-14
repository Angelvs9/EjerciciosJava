package BBDD;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Angel
 */
public class Metodos {
    

    //si vinieran en archivos separados los datos a insertar de las consultas que crean la bd 
    
    public static boolean crearBD(Connection gestor,String bd,String datosbd){
        boolean temp=true;//para ejecutar el use una vez solo cuando ya se ha creado la bd
        boolean todoCorrecto=false;
        try {
            Statement stmt=gestor.createStatement();
            
            File f=new File(bd);
            File filedata=new File(datosbd);
            BufferedReader br=new BufferedReader(new FileReader(f));
            BufferedReader bufferedReader=new BufferedReader(new FileReader(filedata));
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
                }
            }
            br.close();
            
            
            consulta="";
            linea="";
            while((linea=bufferedReader.readLine())!=null){
                if (linea!=" " && !linea.startsWith("--")) {
                    consulta+=linea;
                }
                if (consulta.endsWith(";")) {
                    stmt.execute(consulta);
                    consulta="";
                    //se supone que si ya has ejecutado 1 consulta el resto es igual
                    todoCorrecto=true;
                }
            }
            bufferedReader.close();
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
            String use="USE minferreteria";
            stmt.execute(use);
            stmt.close();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    //esto si vienen junto todo en el mismo archivo 

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
    
    public static boolean subirFoto(Connection gestor,int id,String foto){
        boolean correcto=false;
        String insert = "INSERT INTO bfoto (ncodigo, foto) VALUES (?, ?)";
        use(gestor);
        try {

            ByteArrayOutputStream byteArray=new ByteArrayOutputStream();
            ObjectOutputStream oos=new ObjectOutputStream(byteArray);
            oos.writeObject(foto);
            PreparedStatement ps=gestor.prepareStatement(insert);
            ps.setInt(1, id); 
            ps.setBytes(2, fotoBytes); 
            ps.executeUpdate();
            
            
        } catch (IOException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return correcto;
    }
    
    
    
}

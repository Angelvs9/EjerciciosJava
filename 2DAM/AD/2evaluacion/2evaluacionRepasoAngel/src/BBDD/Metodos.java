
package BBDD;

import Modelo.Canal;
import Modelo.Protagonista;
import Modelo.Serie;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
    
    public static void use(Connection c){
        try {
            Statement sta=c.createStatement();
            sta.executeUpdate("use seriestv");
            sta.close();
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static int crearCanal(Connection conexion,Canal canal){
        int codigo=-1;
        String sql="insert into canales (cnombre,nprecio,nseries) values (?,?,?)";
        try {
            PreparedStatement psta=conexion.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            psta.setString(1, canal.getCnombre());
            psta.setInt(2, canal.getNprecio());
            psta.setInt(3, canal.getNseries());
            psta.executeUpdate();
            ResultSet rs=psta.getGeneratedKeys();
            if (rs.next()) {
                codigo=rs.getInt(1);
            }
            psta.close();
            rs.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return codigo;
    }
    
    public static boolean crearSerie(Connection conexion,Serie serie){
        String sql="insert into series (ncodigo,ctitulo,cgenero,nanyo,bfoto,ncanal,cfoto) values (?,?,?,?,?,?,?)";
        try {
            PreparedStatement psta=conexion.prepareStatement(sql);
            psta.setInt(1, serie.getNcodigo());
            psta.setString(2, serie.getCtitulo());
            psta.setString(3,serie.getCgenero());
            psta.setInt(4, serie.getNanyo());
            //foto
            psta.setBytes(5, serie.getBfoto());
            psta.setInt(6, serie.getNcanal());
            psta.setString(7, serie.getCfoto());
            psta.executeUpdate();
            psta.close();
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public static boolean crearProtagonista(Connection conexion,Protagonista prota){
        String sql="insert into protagonistas (ncodigo,cnombre,nedad,bcurriculum,nserie,ccurriculum) values (?,?,?,?,?,?)";
        try {
            PreparedStatement psta=conexion.prepareStatement(sql);
            psta.setInt(1, prota.getNcodigo());
            psta.setString(2, prota.getCnombre());
            psta.setInt(3,prota.getNedad());
            //CV
            psta.setBytes(4, prota.getBcurriculum());
            psta.setInt(5, prota.getNseries());
            psta.setString(6, prota.getCcurriculum());
            psta.executeUpdate();
            psta.close();
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    
    }
    
}

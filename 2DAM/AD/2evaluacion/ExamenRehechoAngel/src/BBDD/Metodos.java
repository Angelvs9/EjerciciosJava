/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BBDD;

import Modelo.Local;
import Modelo.Maquina;
import Modelo.Maquina_producto;
import Modelo.Producto;
import com.mysql.cj.PreparedQuery;
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
                        sta.execute(consulta);
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
    
    public static int crearLocal(Connection conexion,Local lo){
        int codigo=-1;
        String insert="insert into locales (cpoblacion,cdireccion) values (?,?)";
        try {
            PreparedStatement psta=conexion.prepareStatement(insert,Statement.RETURN_GENERATED_KEYS);
            psta.setString(1, lo.getCpoblacion());
            psta.setString(2, lo.getCdireccion());
            psta.executeUpdate();
            ResultSet rs=psta.getGeneratedKeys();
            if(rs.next()){
                codigo=rs.getInt(1);
            }
            //aqui tengo el codigo 
            rs.close();
            psta.close();
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }

        return codigo;
    
    }
    public static int crearMaquina(Connection conexion,Maquina maquina){
        int codigo=-1;
        String insert="insert into maquina (cmodelo,npeso,naltura,nlocal) values (?,?,?,?);";
        try {
            PreparedStatement psta=conexion.prepareStatement(insert,Statement.RETURN_GENERATED_KEYS);
            psta.setString(1, maquina.getCmodelo());
            psta.setDouble(2, maquina.getNpeso());
            psta.setDouble(3, maquina.getNaltura());
            psta.setInt(4, maquina.getNlocal());
            psta.executeUpdate();
            ResultSet rs=psta.getGeneratedKeys();
            if(rs.next()){
                codigo=rs.getInt(1);
            }
            rs.close();
            psta.close();
                    
            
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return codigo;
    
    }
    
    public static int crearProducto(Connection conexion, Producto p){
        int codigo=-1;
        String insert="insert into productos (cnombre,nprecio,bfoto,bnutrientes) values (?,?,?,?);";
        try {
            PreparedStatement psta=conexion.prepareStatement(insert,Statement.RETURN_GENERATED_KEYS);
            psta.setString(1, p.getCnombre());
            psta.setDouble(2, p.getNprecio());
            //foto
            psta.setBytes(3, p.getBfoto());
            //objeto
            psta.setObject(4, p.getBnutrientes());
               
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
    
    public static void insertarMaquinaProducto(Connection conexion,Maquina_producto mp){
        try {
            String insert="insert into maquina_producto (nmaquina,nproducto,ncantidad) values (?,?,?);";
            PreparedStatement psta=conexion.prepareStatement(insert);
            psta.setInt(1, mp.getNmaquina());
            psta.setInt(2, mp.getNproducto());
            psta.setInt(3, mp.getNcantidad());
            psta.executeUpdate();
            psta.close();
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static void vaciarMaquina(Connection conexion,int cod){
        String vaciar="DELETE FROM maquina_producto WHERE nmaquina=?;";
        try {
            //String vaciar="UPDATE maquina_producto ncantidad=0 WHERE nmaquina=?;";
            PreparedStatement psta=conexion.prepareStatement(vaciar);
            psta.setInt(1, cod);
            psta.executeUpdate();
            psta.close();
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public static void cambiarFoto(Connection conexion,byte [] foto,int producto){
        try {
            String update="UPDATE productos SET bfoto=? WHERE ncodigo=?;";
            PreparedStatement psta=conexion.prepareStatement(update);
            psta.setBytes(1, foto);
            psta.setInt(2, producto);
            psta.executeUpdate();
            psta.close();
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}

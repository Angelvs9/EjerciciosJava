package BBDD;

import Modelo.Cliente;
import static Modelo.CrearPDF.crear;
import Modelo.Metadatos;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
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
                if (!linea.startsWith("-") && !linea.isEmpty()) {
                    consulta+=linea;
                    if (consulta.endsWith(";")) {
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
    
    public static boolean crearCliente(Connection conexion,Cliente c){
        boolean temp=false;
        boolean existe=false;
        String query="select * from clientes where cnif='"+c.getCnif()+"';";
        String insert="insert into clientes (cnombre,capellidos,cnif) values (?,?,?)";
        try {
            use(conexion);
            Statement sta=conexion.createStatement();
            ResultSet rs=sta.executeQuery(query);
            int ncodigo=0;
            if (rs.next()) {
                existe=true;
                ncodigo=rs.getInt("ncodigo");
            }
            sta.close();
            rs.close();
            
            if (!existe) {
                //insert into clientes
                PreparedStatement psta=conexion.prepareStatement(insert);
                psta.setString(1, c.getCnombre());
                psta.setString(2, c.getCapellidos());
                psta.setString(3, c.getCnif());
                psta.executeUpdate();
                psta.close();
                
                
                insertarDocumentoCliente(conexion,c);
                temp=true;                
            }
            else{
                
            
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return temp;
    }
    
    public static boolean insertarDocumentoCliente(Connection c,Cliente cli,Metadatos m){
        boolean temp=false;
        //creo el pdf
        String nombrefichero=cli.getCnombre();
        crear(nombrefichero, cli.getCapellidos(), cli.getCnif());
        
        File f=new File(nombrefichero+".pdf");
        try {
            FileInputStream fis=new FileInputStream(f);
            
            String consulta="insert into documentos (ncliente,ctipo,bdoc,bmeta,cfichero) values (?,?,?,?,?)";
            PreparedStatement psta=c.prepareStatement(consulta);
            psta.setInt(1,getCodigo(c, cli.getCnif()));
            psta.setString(2, m.getCtipo());
            psta.setBinaryStream(3, fis);
            
            ByteArrayOutputStream byteArray=new ByteArrayOutputStream();
            ObjectOutputStream oos=new ObjectOutputStream(byteArray);
            oos.writeObject(m);
            psta.setBytes(4,byteArray.toByteArray());
            psta.setString(5,nombrefichero);
            psta.execute();
            
            psta.close();
            fis.close();
            oos.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return temp;
    
    }
    
    private static int getCodigo(Connection c,String nif){
        int codigo=-1;
        try {
            Statement sta=c.createStatement();
            ResultSet rs= sta.executeQuery("select ncodigo from clientes where cnif="+nif+";");
            if (rs.next()) {
                codigo=rs.getInt("nif");
            }
            rs.close();
            sta.close();
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return codigo;
        
    }
    
    public static String datosCliente(Connection conexion,String nif){
        String contenido="no existe usuario con ese nif";
        String select="select * from cliente where nif='"+nif+"';";
        try {
            Statement sta =conexion.createStatement();
            ResultSet rs=sta.executeQuery(select);
            if (rs.next()) {
                contenido="codigo: "+rs.getInt("ncodigo")+" nombre: "+rs.getString("cnombre")+" apellidos: "+rs.getString("capellidos"); 
            }
            rs.close();
            sta.close();
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return contenido;
    }
    
    
    private static boolean existeCliente(Connection conexion,int ncodigo){
        boolean existe=false;
        try {
            Statement sta=conexion.createStatement();
            ResultSet rs=sta.executeQuery("select * from clientes where ncodigo="+ncodigo+";");
            if (rs.next()) {
                existe=true;
            }
            sta.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return existe;
    }
    
    
}

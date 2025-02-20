
package BBDD;

import Modelo.Cofrades;
import Modelo.Cofradia;
import Modelo.Parroquia;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.jfr.events.FileWriteEvent;

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
            cofra.setNcodigo(codigo);
            rs.close();
            psta.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }

        return codigo;
    }
    
    public static int crearCofrades(Connection conexion,Cofrades cofrade){
        int codigo=-1;
        String insert="insert into cofrades (ncofradia,cnombre,capellidos,ctelefono,nedad) values (?,?,?,?,?);";
        try {
            if (cofrade.getNcofradia()<=0) {
                //no existe
                String select="select * from cofradias order by ncodigo desc limit 1;";
                //pillo la ultima cofradia
                int codigocofradia=-1;
                Statement sta=conexion.createStatement();
                ResultSet rs=sta.executeQuery(select);
                if (rs.next()) {
                    codigocofradia=rs.getInt("ncodigo");
                    //pillo el codigo de la ultima cofradia
                }
                //aqui le pongo el nuevo numero de la cofradia que se lo asigno al ultimo por defecto si no existe 
                // porque hay dos constructores uno si le pone y otro si no rellenas el ncofradia
                cofrade.setNcofradia(codigocofradia);
                rs.close();
                sta.close();
            }
            //si ha entrado arriba tiene el ultimo ncofradia si no es el que tenga el objeto por defecto
            PreparedStatement psta=conexion.prepareStatement(insert,Statement.RETURN_GENERATED_KEYS);
            psta.setInt(1, cofrade.getNcofradia());
            psta.setString(2, cofrade.getCnombre());
            psta.setString(3, cofrade.getCapellidos());
            psta.setString(4, cofrade.getCtelefono());
            psta.setInt(5, cofrade.getNedad());
            psta.executeUpdate();
            ResultSet rs=psta.getGeneratedKeys();
            if (rs.next()) {
                codigo=rs.getInt(1);
            }
            cofrade.setNcodigo(codigo);
            rs.close();
            psta.close();
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return codigo;
    }
    
    public static void hacerPDF(Connection conexion){
        String select="select parroquias.*,cofradias.*,cofrades.* from cofradias "
                + "left join parroquias on parroquias.ncodigo=cofradias.nparroquia "
                + "left join cofrades on cofrades.ncofradia=cofradias.ncodigo";
        
        try {
            PreparedStatement psta=conexion.prepareStatement(select);
            Document documento =new Document();
            FileOutputStream ficheroPDF=new FileOutputStream("iglesia.PDF");
            
            PdfWriter.getInstance(documento,ficheroPDF);
            
            documento.open();
            Paragraph titulo=new Paragraph("IGLESIAS\n\n");
            titulo.setAlignment(Element.ALIGN_CENTER);
            documento.add(titulo);
            ResultSet rs= psta.executeQuery();
            while(rs.next()){
                //pongo numeros y así no tengo que poner as
                Paragraph temp=new Paragraph("Parroquias{codigo de la parroquia:"+rs.getInt(1)+"\nnombre parroquia:"+rs.getString(2)+"\ndireccion: "+rs.getString(3)+"\npadre a cargo: "+rs.getString(4)+"}\n\n");
                documento.add(temp);
                byte[] imagenBytes = rs.getBytes(8); 
                Image imagen = Image.getInstance(imagenBytes);
                imagen.scaleToFit(200, 200);
                Paragraph temp2=new Paragraph("\tCofradias{codigo de la cofradia:"+rs.getInt(5)+"\nnombre cofradia:"+rs.getString(6)+"\ndireccion: "+rs.getString(7)+"\ncodigo de la parroquia "+rs.getInt(10));
                documento.add(temp2);
                documento.add(imagen);
                Paragraph temp3=new Paragraph("}\n\nCofrades{codigo de la cofrades: "+rs.getInt(11)+"\nncofradia: "+rs.getInt(12)+"\nnombre cofrades:"+rs.getString(13)+"\napellidos: "+rs.getString(14)+"\ntelefono: "+rs.getString(15)+"\nnedad "+rs.getString(16)+"}\n");
                documento.add(temp3);
                documento.add(new Paragraph("\n_________________________________________________\n"));
            }
            documento.close();
            rs.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        } 
        

    }
    
    public static void hacerCSV(Connection conexion){
        String consulta = "select parroquias.ncodigo as codigoParroquia, " +
                  "parroquias.cnombre as nombreParroquias, " +
                  "parroquias.cdireccion as direccionParroquia, " +
                  "parroquias.csacerdote as sacerdoteEncargado, " +
                  "cofradias.ncodigo as codigoCofradias, " +
                  "cofradias.cnombre as nombreCofradia, " +
                  "cofradias.cdireccion as direccion, " +
                  "cofradias.cfichero as nombreFicheroFoto, " +
                  "cofradias.nparroquia as numeroParroquia, " +
                  "cofrades.* " +
                  "from cofradias " +
                  "left join parroquias on parroquias.ncodigo = cofradias.nparroquia " +
                  "left join cofrades on cofrades.ncofradia = cofradias.ncodigo;";

        String cabezera = "codigoParroquia;nombreParroquias;direccionParroquia;sacerdoteEncargado;codigoCofradias;nombreCofradia;direccion;nombreFicheroFoto;numeroParroquia;codigoCofrades;numeroCofradia;nombreCofrades;apellidosCofrades;telefonoCofrades;edadCofrades";
        try {
            Statement sta=conexion.createStatement();
            ResultSet rs=sta.executeQuery(consulta);
            FileWriter fw=new FileWriter(new File("IGLESIA.csv"));
            fw.write(cabezera+"\n");
            while(rs.next()){
                fw.write(rs.getInt("codigoParroquia") + ";");
                fw.write(rs.getString("nombreParroquias") + ";");
                fw.write(rs.getString("direccionParroquia") + ";");
                fw.write(rs.getString("sacerdoteEncargado") + ";");
                fw.write(rs.getInt("codigoCofradias") + ";");
                fw.write(rs.getString("nombreCofradia") + ";");
                fw.write(rs.getString("direccion") + ";");
                fw.write(rs.getString("nombreFicheroFoto") + ";");
                fw.write(rs.getInt("numeroParroquia") + ";");
                //aqui son numeros porque a cofrados no les he peusto nombre con as y es mas rapido así
                fw.write(rs.getInt(10) + ";");
                fw.write(rs.getString(11) + ";");
                fw.write(rs.getString(12) + ";");
                fw.write(rs.getString(13) + ";");
                fw.write(rs.getString(14) + ";");
                fw.write(rs.getString(15) + ";");
                fw.write("\n");
            }
            fw.close();
            rs.close();
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        
    
    }
    
    
    
    
}

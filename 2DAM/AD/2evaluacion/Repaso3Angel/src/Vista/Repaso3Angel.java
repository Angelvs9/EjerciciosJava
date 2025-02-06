
package Vista;

import BBDD.Conexion;
import BBDD.Metodos;
import static BBDD.Metodos.*;
import Modelo.Cliente;
import static Modelo.CrearPDF.crear;
import Modelo.Metadatos;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Angel
 */
public class Repaso3Angel {


    public static void main(String[] args) {
        Conexion conexion=new Conexion();
        
        //CREACION DE LA BD
        crearBD(conexion.getConexion(), "BBDD.sql");
        
        Cliente c1=new Cliente("paco","molina","1245764K");
        Cliente c2=new Cliente("pep","moliner","25418756L");
        Cliente c3 = new Cliente("juan", "perez", "75839201M");
        Cliente c4 = new Cliente("maria", "lopez", "65928374N");

        if (crearCliente(conexion.getConexion(),c1)) {
            System.out.println("insertado");
        }
        if (crearCliente(conexion.getConexion(),c2)) {
            System.out.println("insertado");
        }
        
        if (crearCliente(conexion.getConexion(), c3)) {
            System.out.println("insertado");
        }
        if (crearCliente(conexion.getConexion(), c4)) {
            System.out.println("insertado");
        }
        
        use(conexion.getConexion());
        String select="select * from clientes";
        try {
            Statement sta =conexion.getConexion().createStatement();
            System.out.println("ncodigo\tcnombre\tcapellidos\tcnif");
            ResultSet rs=sta.executeQuery(select);
            while(rs.next()){
                System.out.println(rs.getInt("ncodigo")+"\t"+rs.getString("cnombre")+"\t"+rs.getString("capellidos")+"\t\t"+rs.getString("cnif"));
            }
            rs.close();
            sta.close();
        } catch (SQLException ex) {
            Logger.getLogger(Repaso3Angel.class.getName()).log(Level.SEVERE, null, ex);
        }
        crear(c1.getCnombre(), c1.getCapellidos(), c1.getCnif());
        crear(c2.getCnombre(), c2.getCapellidos(), c2.getCnif());
        crear(c3.getCnombre(), c3.getCapellidos(), c3.getCnif());
        crear(c4.getCnombre(), c4.getCapellidos(), c4.getCnif());
        
        Metadatos m1 = new Metadatos(c1.getCnombre(), LocalDate.now().toString(), c1, c1.getCnombre() + ".pdf");
        Metadatos m2 = new Metadatos(c2.getCnombre(), LocalDate.now().toString(), c2, c2.getCnombre() + ".pdf");
        Metadatos m3 = new Metadatos(c3.getCnombre(), LocalDate.now().toString(), c3, c3.getCnombre() + ".pdf");
        Metadatos m4 = new Metadatos(c4.getCnombre(), LocalDate.now().toString(), c4, c4.getCnombre() + ".pdf");
        if (insertarDocumentoCliente(conexion.getConexion(), c1, m1)) {
            System.out.println("Documento insertado para: " + c1.getCnombre());
        }
        if (insertarDocumentoCliente(conexion.getConexion(), c2, m2)) {
            System.out.println("Documento insertado para: " + c2.getCnombre());
        }
        if (insertarDocumentoCliente(conexion.getConexion(), c3, m3)) {
            System.out.println("Documento insertado para: " + c3.getCnombre());
        }
        if (insertarDocumentoCliente(conexion.getConexion(), c4, m4)) {
            System.out.println("Documento insertado para: " + c4.getCnombre());
        }
        String imprimir="";
        try {
            String consulta="select * from documentos where ncliente=?;";
            PreparedStatement pstmt=conexion.getConexion().prepareStatement(consulta);
            pstmt.setInt(1, getCodigo(conexion.getConexion(), c1.getCnif()));
            ResultSet rs=pstmt.executeQuery();
            while (rs.next()) {
                Blob b2=rs.getBlob("bmeta");
                ObjectInputStream ois=new ObjectInputStream(b2.getBinaryStream());
                Metadatos md=(Metadatos) ois.readObject();
                imprimir+=md+"\n";
            }
            rs.close();
            pstmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(Repaso3Angel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Repaso3Angel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Repaso3Angel.class.getName()).log(Level.SEVERE, null, ex);
        }
        //imprimir datos de documentos
        System.out.println(imprimir);
        
        
        try {
            String consulta="select * from documentos where ncliente=?;";
            PreparedStatement pstmt=conexion.getConexion().prepareStatement(consulta);
            pstmt.setInt(1, getCodigo(conexion.getConexion(), c1.getCnif()));
            ResultSet rs=pstmt.executeQuery();
            while (rs.next()) {
                File f = new File("DESCARGADO " + rs.getString("cfichero") + "." + rs.getString("ctipo"));
                FileOutputStream fos = new FileOutputStream(f);
                Blob blob = rs.getBlob("bdoc");
                byte[] data = blob.getBytes(1, (int)blob.length());
         
                fos.write(data);
                fos.close();
            }
            rs.close();
            pstmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(Repaso3Angel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Repaso3Angel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        conexion.cerrarConexion();
        
    }
    
}

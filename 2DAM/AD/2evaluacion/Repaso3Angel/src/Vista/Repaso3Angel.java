
package Vista;

import BBDD.Conexion;
import BBDD.Metodos;
import static BBDD.Metodos.*;
import Modelo.Cliente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Angel
 */
public class Repaso3Angel {


    public static void main(String[] args) {
        Conexion conexion=new Conexion();
        
        //CREACION DE LA BD
        //crearBD(c.getConexion(), "BBDD.sql");
        
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
        
        
        conexion.cerrarConexion();
        
    }
    
}


package BBDD;

import Modelo.Cliente;
import Modelo.Pedido;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
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

    public static boolean crearBD(Connection bdMysql,String bd){
        boolean creada=false;
        File f=new File(bd);

        try {       
            FileReader fr=new FileReader(f);
            BufferedReader br=new BufferedReader(fr);
            Statement sta=bdMysql.createStatement();
            String linea="";
            String consulta="";
            while((linea=br.readLine())!=null){
                if (!linea.startsWith("--") && !linea.isEmpty()) {
                    consulta+=linea;
                    if (linea.endsWith(";")) {
                        sta.executeUpdate(consulta);
                        consulta="";
                        creada=true;
                    }
                }
            }
            sta.close();
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return creada;
    }
    
    public static boolean altaCliente(Connection gestor,Cliente c){
        boolean temp=false;
        try {
            Statement sta=gestor.createStatement();
            String query="select dni from clientes where dni='"+c.getDni()+"'";
            String insert="insert into clientes (nombre,apellidos,dni) values ("+c.getNombre()+","+c.getApellidos()+","+c.getDni()+");";
            ResultSet rs=sta.executeQuery(query);
            if (!rs.next()) {
                sta.executeUpdate(insert);
            }
            
            rs.close();
            sta.close();
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }

        return temp;
    }
    
    public static boolean hacerPedido(Connection gestor,Pedido p){
        boolean temp=false;
        String insertar="insert into pedidos (cliente,fecha,cantidad) values ("+p.getCliente()+","+Date.valueOf(p.getFecha())+","+p.getCantidad()+");";
        try {
            Statement sta=gestor.createStatement();
            sta.executeUpdate(insertar);
            temp=true;
            
            sta.close();
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return temp;
    }
    
}

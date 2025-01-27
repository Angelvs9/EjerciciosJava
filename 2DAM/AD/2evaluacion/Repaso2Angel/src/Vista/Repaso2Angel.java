
package Vista;

import BBDD.GestorConexion;
import BBDD.Metodos;
import static BBDD.Metodos.hacerPedido;
import Modelo.Cliente;
import Modelo.Pedido;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Angel
 */
public class Repaso2Angel {

    public static void main(String[] args) {
        GestorConexion gestor=new GestorConexion();
        String query="select count(*) FROM INFORMATION_SCHEMA.SCHEMATA WHERE SCHEMA_NAME = 'examen'";
        try {
            Statement sta = gestor.getConexion().createStatement();
            ResultSet rs=sta.executeQuery(query);
            int n=0;
            if (rs.next()) {
                n=rs.getInt(1);      
            }
            if (n==0) {
                Metodos.crearBD(gestor.getConexion(), "folios.sql.sql");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Repaso2Angel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        Scanner sc=new Scanner(System.in);
        int opcion=0;
        
        while(opcion<=10){
            System.out.println("1-alta cliente");
            System.out.println("2-baja cliente");
            System.out.println("3-modificar cliente");
            System.out.println("4-hacer pedido");
            System.out.println("*-salir");
            opcion=sc.nextInt();
            sc.nextLine();
            switch (opcion) {
            case 1:
                System.out.println("introduce nombre: ");
                String nombre=sc.nextLine();
                System.out.println("apellidos: ");
                String apellidos=sc.nextLine();
                System.out.println("DNI: ");
                String dni=sc.nextLine();
                Cliente c=new Cliente(nombre, apellidos, dni);
                if (Metodos.altaCliente(gestor.getConexion(),c)) {
                    System.out.println("creado correctamente cliente "+c.getNombre()+" "+c.getApellidos()+"\n"+c.getDni());
                }else{
                    System.out.println("no se puedo crear cliente");
                }

                break;
            case 2:
                try {
                    String queryClientes="select id,nombre,apellidos from clientes";
                    String delete = "DELETE FROM clientes WHERE id = ?";
                    Statement stm=gestor.getConexion().createStatement();
                    System.out.println("selecciona el id del cliente a eliminar:\n");
                    ResultSet res=stm.executeQuery(queryClientes);
                    while (res.next()) {
                        int id=res.getInt("id");
                        String nombreCliente=res.getString("nombre");
                        String apellidosCliente=res.getString("apellidos");
                        System.out.println("id: "+id+"nombre: "+nombreCliente+"apellidos: "+apellidosCliente);
                    }
                    int idCliente=sc.nextInt();
                    String consultaeliminarCliente = "DELETE FROM clientes WHERE id = " + idCliente;
                    
                    
                    
                    PreparedStatement psta=gestor.getConexion().prepareStatement(delete);
                    psta.setInt(1, idCliente);
                    int filasAfectadas = psta.executeUpdate();
                    if (filasAfectadas > 0) {
                        System.out.println("Cliente con ID " + idCliente + " eliminado correctamente.");
                    }
                    

                    
                } catch (SQLException ex) {
                    Logger.getLogger(Repaso2Angel.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                break;
            case 3:
                System.out.println("modificar cliente");
                
                break;
            case 4:
                try {     
                    String consultaClientes="select id,nombre,apellidos from clientes";
                    Statement sta=gestor.getConexion().createStatement();
                    System.out.println("selecciona un id:\n");
                    ResultSet rs=sta.executeQuery(consultaClientes);
                    while (rs.next()) {
                        int id=rs.getInt("id");
                        String nombreCliente=rs.getString("nombre");
                        String apellidosCliente=rs.getString("apellidos");
                        System.out.println("id: "+id+"nombre: "+nombreCliente+"apellidos: "+apellidosCliente);
                    }
                    int idCliente=sc.nextInt();
                    sc.nextLine(); 
                    System.out.println("cantidad de folios");
                    int folios=sc.nextInt();
                    System.out.println("introduce la fecha YYYY-MM-DD");
                    String fecha = sc.nextLine();
                    
                    Pedido p=new Pedido(idCliente,fecha,folios);
                    
                    hacerPedido(gestor.getConexion(),p);
                    
                } catch (SQLException ex) {
                    Logger.getLogger(Repaso2Angel.class.getName()).log(Level.SEVERE, null, ex);
                }
   
                break;
            
            case 10:
                System.out.println("Saliendo...");
                break;
            }
        }
        sc.close();
        gestor.cerrarConexion();
    }
    
}

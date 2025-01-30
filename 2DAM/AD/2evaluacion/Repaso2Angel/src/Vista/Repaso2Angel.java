
package Vista;

import BBDD.GestorConexion;
import BBDD.Metodos;
import static BBDD.Metodos.hacerPedido;
import static BBDD.Metodos.use;
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
                System.out.print("introduce nombre: ");
                String nombre=sc.nextLine();
                System.out.print("apellidos: ");
                String apellidos=sc.nextLine();
                System.out.print("DNI: ");
                String dni=sc.nextLine();
                Cliente c=new Cliente(nombre, apellidos, dni);
                if (Metodos.altaCliente(gestor.getConexion(),c)) {
                    System.out.println("\n----------\ncreado correctamente cliente "+c.getNombre()+" "+c.getApellidos()+"\n"+c.getDni()+"\n----------\n");
                }else{
                    System.out.println("\n----------\nno se puedo crear cliente\n----------\n");
                }

                break;
            case 2:
                try {
                    String queryClientes="select id,nombre,apellidos from clientes";
                    boolean hayclientes=false;
                    String delete = "DELETE FROM clientes WHERE id = ?";
                    Statement stm=gestor.getConexion().createStatement();
                    use(gestor.getConexion());
                    ResultSet res=stm.executeQuery(queryClientes);
                    while (res.next()) {
                        hayclientes=true;
                        int id=res.getInt("id");
                        String nombreCliente=res.getString("nombre");
                        String apellidosCliente=res.getString("apellidos");
                        System.out.println("id: "+id+" nombre: "+nombreCliente+" apellidos: "+apellidosCliente);
                    }

                    if (hayclientes) {
                        System.out.println("selecciona el id del cliente a eliminar:\n");
                        int idCliente=sc.nextInt();
                        PreparedStatement psta=gestor.getConexion().prepareStatement(delete);
                        psta.setInt(1, idCliente);
                        int filasAfectadas = psta.executeUpdate();
                        
                        if (filasAfectadas > 0) {
                            System.out.println("Cliente con ID " + idCliente + " eliminado correctamente.");
                        }
                        else{
                            System.out.println("\n----------\nno existe ese cliente\n----------\n");
                        }
                    
                    }else{
                        System.out.println("\n----------\nno hay clientes a eliminar\n----------\n");
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
                    use(gestor.getConexion());
                    boolean hayclientes=false;
                    String consultaClientes="select id,nombre,apellidos from clientes";
                    Statement sta=gestor.getConexion().createStatement();
                    ResultSet rs=sta.executeQuery(consultaClientes);
                    while (rs.next()) {
                        hayclientes=true;
                        int id=rs.getInt("id");
                        String nombreCliente=rs.getString("nombre");
                        String apellidosCliente=rs.getString("apellidos");
                        System.out.println("id: "+id+" nombre: "+nombreCliente+" apellidos: "+apellidosCliente);
                    }
                    
                    if (hayclientes) {
                        System.out.println("selecciona la id del cliente que quierre hacer el pedido:\n");
                        int idCliente=sc.nextInt();
                        sc.nextLine(); 
                        System.out.println("cantidad de folios");
                        int folios=sc.nextInt();
                        Pedido p=new Pedido(idCliente,folios);

                        if (hacerPedido(gestor.getConexion(),p)) {
                            System.out.println("\n----------\nPedido de: "+folios+" folios realizado correctamente\n----------\n");
                        }
                        else{
                            System.out.println("\n----------\nno se puedo realizar el pedido porque el cliente no existe\n----------\n");
                        }
                    }else{
                        System.out.println("\n----------\nno hay clientes\n----------\n");
                    }
                    
                    
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

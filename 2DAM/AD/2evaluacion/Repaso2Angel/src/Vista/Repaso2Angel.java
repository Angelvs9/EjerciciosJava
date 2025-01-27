
package Vista;

import BBDD.GestorConexion;
import BBDD.Metodos;
import Modelo.Cliente;
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
        
        while(opcion<=5){
            System.out.println("1-alta cliente");
            System.out.println("2-baja cliente");
            System.out.println("3-modificar cliente");
            System.out.println("4-hacer pedido");
            System.out.println("5-salir");
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
                System.out.println("baja");
                
                break;
            case 3:
                System.out.println("modificar cliente");
                
                break;
            case 4:
                System.out.println("hacer pedido ");
                break;
            
            case 5:
                System.out.println("Saliendo..");
                break;
            }
        }
        
        
    }
    
}

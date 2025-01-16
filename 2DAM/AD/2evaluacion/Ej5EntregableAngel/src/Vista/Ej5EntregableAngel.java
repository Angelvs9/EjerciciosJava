package Vista;

import BBDD.gestorConexion;

/**
 *
 * @author Angel
 */
public class Ej5EntregableAngel {

    
    public static void main(String[] args) {
        gestorConexion gestorPostgres=new gestorConexion("jdbc:postgresql://127.0.0.1:5435/erp");
        gestorConexion gestor=new gestorConexion("jdbc:mysql://localhost:3306/");
        
        
        
        
        
        
        gestorPostgres.cerrar_Conexion();
        gestor.cerrar_Conexion();
    }
    
}

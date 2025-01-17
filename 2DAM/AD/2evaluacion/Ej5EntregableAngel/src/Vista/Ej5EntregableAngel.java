package Vista;

import BBDD.Metodos;
import BBDD.gestorConexion;

/**
 *
 * @author Angel
 */
public class Ej5EntregableAngel {

    
    public static void main(String[] args) {
        //el de erp es el viejo osea el de postgres
        gestorConexion gestorPostgres=new gestorConexion("jdbc:postgresql://127.0.0.1:5435/erp","postgres","");
        //aqui es donde tengo que poner los nuevos datos
        gestorConexion gestor=new gestorConexion("jdbc:mysql://localhost:3306/","root","");
        
        Metodos.crearBaseDatos(gestor.getConn(), "audiogil.sql");
        
        
        
        
        gestorPostgres.cerrar_Conexion();
        gestor.cerrar_Conexion();
    }
    
}

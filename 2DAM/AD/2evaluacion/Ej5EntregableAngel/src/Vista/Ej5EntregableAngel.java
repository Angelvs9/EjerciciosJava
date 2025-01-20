package Vista;

import BBDD.Metodos;
import static BBDD.Metodos.crearBaseDatos;
import static BBDD.Metodos.traspasoADatosFiscales;
import static BBDD.Metodos.traspasoClientes;
import static BBDD.Metodos.traspasoPoblaciones;
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
        gestorConexion gestor=new gestorConexion("jdbc:mysql://localhost:3306/audiogil","root","");
        
        crearBaseDatos(gestor.getConn(), "audiogil.sql");
        
        if (traspasoPoblaciones(gestorPostgres.getConn(), gestor.getConn())) {
            System.out.println("tabla poblaciones rellenada");
        }
        if (traspasoClientes(gestorPostgres.getConn(), gestor.getConn())) {
            System.out.println("tabla cleintes rellenada");
        }
        
        
        if (traspasoADatosFiscales(gestorPostgres.getConn(), gestor.getConn())) {
            System.out.println("tabla datos_fiscales rellenada correctamente");
        }
        
        
        
        gestorPostgres.cerrar_Conexion();
        gestor.cerrar_Conexion();
    }
    
}

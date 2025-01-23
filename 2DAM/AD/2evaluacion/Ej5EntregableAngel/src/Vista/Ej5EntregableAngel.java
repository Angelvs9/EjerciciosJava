package Vista;

import BBDD.Metodos;
import static BBDD.Metodos.crearBaseDatos;
import static BBDD.Metodos.traspasoADatosFiscales;
import static BBDD.Metodos.traspasoAnotaciones;
import static BBDD.Metodos.traspasoClientes;
import static BBDD.Metodos.traspasoCuenta_cliente;
import static BBDD.Metodos.traspasoPoblaciones;
import static BBDD.Metodos.use;
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
         
        if(crearBaseDatos(gestor.getConn(), "audiogil.sql")){
            System.out.println("BD creada");
        }
        use(gestor.getConn(),"audiogil");
        
        System.out.println(traspasoPoblaciones(gestorPostgres.getConn(), gestor.getConn())+" poblaciones insertadas");
            
        System.out.println(traspasoCuenta_cliente(gestorPostgres.getConn(), gestor.getConn())+" Cuenta_clientes insertados");


        System.out.println(traspasoAnotaciones(gestorPostgres.getConn(), gestor.getConn())+" tabla anotaciones llenada");
        
        System.out.println(traspasoClientes(gestorPostgres.getConn(), gestor.getConn())+" filas en tabla clientes");

        if (traspasoADatosFiscales(gestorPostgres.getConn(), gestor.getConn())) {
            System.out.println("tabla datos_fiscales rellenada correctamente");
        }

        
        gestorPostgres.cerrar_Conexion();
        gestor.cerrar_Conexion();
    }
    
}

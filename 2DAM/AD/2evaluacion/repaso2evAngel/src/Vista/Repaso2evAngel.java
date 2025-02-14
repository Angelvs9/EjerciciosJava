package Vista;

import BBDD.GestorConexion;
import static BBDD.Metodos.*;
import Modelo.Canal;
import Modelo.Protagonista;
import Modelo.Serie;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * @author Usuario
 */
public class Repaso2evAngel {

    private static String mostrarDatos(Connection conexion){
        String resultado="";
        String select="select canales.ncodigo as codigoCanales, canales.cnombre as cnombreCanales , canales.nprecio as nprecioCanales, canales.nseries as nseriesCanales, series.ncodigo as ncodigoSeries, series.ctitulo as ctituloSeries, series.cgenero as cgeneroSeries, series.nanyo as nanyoSeries, protagonistas.ncodigo as ncodigoProtagonistas, protagonistas.cnombre as cnombreProtagonistas, protagonistas.nedad as nedadProtagonistas from series inner join canales on canales.ncodigo=series.ncanal inner join protagonistas on series.ncodigo=protagonistas.nserie;";
        try {
            Statement sta=conexion.createStatement();
            ResultSet rs=sta.executeQuery(select);
            while(rs.next()){
                Canal canal=new Canal(rs.getString("cnombreCanales"),rs.getInt("nprecioCanales"),rs.getInt("nseriesCanales") );
                System.out.println(canal.toString());
            }
        } catch (SQLException ex) {
            Logger.getLogger(Repaso2evAngel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return resultado;
    }
    
    
    
    public static void main(String[] args) {
        GestorConexion conexion=new GestorConexion();
        //crearBD(conexion.getConexion(), "BBDD.sql");
        
        Canal c1=new Canal("hbo",4,6);
        int numeroCanal1=crearCanal(conexion.getConexion(), c1);
        
        //bfoto es la foto 
        /*
        //primero creo que la serie con todo menos la foto y ya dentro del metodo de insertar la serie le meto la foto con el setter
        Serie startrek= new Serie(1, "startrek", "accion", 1999, numeroCanal1, "startrek.jpg");
        int codigoStartrek=crearSerie(conexion.getConexion(),startrek);
        
        Serie drwho= new Serie(2, "doctor who", "ciencia", 2000, numeroCanal1, "drwho.jpg");
        int codigodrwho=crearSerie(conexion.getConexion(),drwho);
        
        Protagonista p1=new Protagonista(1,"will",29,codigodrwho,"will.pdf");
        System.out.println(crearProtagonista(conexion.getConexion(),p1));
        System.out.println("-------------\n a partir de aquí se muestra todo\n-------------");
        */
        System.out.println(mostrarDatos(conexion.getConexion()));
        
        conexion.cerrar();
    }
    
}

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
            int codigoCanalantiguo=0;
            Statement sta=conexion.createStatement();
            ResultSet rs=sta.executeQuery(select);
            while(rs.next()){
                System.out.println("-------------------------------------------------------------------");
                Canal canal=new Canal(rs.getString("cnombreCanales"),rs.getInt("nprecioCanales"),rs.getInt("nseriesCanales") );
                codigoCanalantiguo=rs.getInt("codigoCanales");
                System.out.println(canal.toString());
                Serie serie = new Serie(rs.getInt("ncodigoSeries"), rs.getString("ctituloSeries"), rs.getString("cgeneroSeries"), rs.getInt("nanyoSeries"), 0, null);//null porque no quiero mostrar la foto pero para crear el obejto le tengo que poner algo
                System.out.println("\t"+serie.toString());
                Protagonista protagonista = new Protagonista(rs.getInt("ncodigoProtagonistas"), rs.getString("cnombreProtagonistas"), rs.getInt("nedadProtagonistas"), rs.getInt("ncodigoSeries"));
                System.out.println("\t\t"+protagonista.toString());
                System.out.println("-------------------------------------------------------------------");
                
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
        Canal c2=new Canal("netflix",2,4);
        int numeroCanal2=crearCanal(conexion.getConexion(), c2);
        
        //bfoto es la foto 
        //primero creo que la serie con todo menos la foto y ya dentro del metodo de insertar la serie le meto la foto con el setter
        Serie startrek= new Serie(1, "startrek", "accion", 1999, numeroCanal1, "startrek.jpg");
        int codigoStartrek=crearSerie(conexion.getConexion(),startrek);
        
        Serie drwho= new Serie(2, "drwho", "accion", 2001, numeroCanal2, "drwho.jpg");
        int codigodrwho=crearSerie(conexion.getConexion(),drwho);
        
        Protagonista p1=new Protagonista(1,"will",29,codigodrwho,"will.pdf");
        System.out.println(crearProtagonista(conexion.getConexion(),p1));
        
        Protagonista p2=new Protagonista(2,"mat",19,codigoStartrek,"mat.pdf");
        System.out.println(crearProtagonista(conexion.getConexion(),p2));
        
        Protagonista p3=new Protagonista(3,"david",59,codigoStartrek,"david.pdf");
        System.out.println(crearProtagonista(conexion.getConexion(),p3));
        
        System.out.println("-------------\n a partir de aquí se muestra todo\n-------------");

        System.out.println(mostrarDatos(conexion.getConexion()));
        
        conexion.cerrar();
    }
    
}

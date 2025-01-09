
package aerolillas;
import utilidades.bbdd.Bd;
import utilidades.bbdd.Gestor_conexion_POSTGRE;


public class Billete {
    private int idBillete;
    private int nAsiento;
    private int contador=1;
    

    public Billete(int idBillete, int nAsiento) {
        this.idBillete = idBillete;
        this.nAsiento = nAsiento;
    }

    // Método para crear un billete
    public void addBillete (Billete b) {
        Gestor_conexion_POSTGRE gest = new Gestor_conexion_POSTGRE("juego",true);
        String consulta1 = "INSERT INTO billete (idBillete, nAsiento) VALUES (" + b.getIdBillete() + ", '" + b.getNAsiento() + "')";
        contador++;
        Bd.consultaModificacion(gest, consulta1);
        gest.cerrar_Conexion(true);
    }

    // Método para borrar un billete
    public void borrarBillete(Billete b) {
        Gestor_conexion_POSTGRE gest = new Gestor_conexion_POSTGRE("juego",true);
        String consultaEliminar = "DELETE FROM billete WHERE idbillete = '" + b.getIdBillete() + "' AND nasiento = '" + b.getNAsiento() + "'";
        Bd.consultaModificacion(gest, consultaEliminar);
        gest.cerrar_Conexion(true);
    }
    
    
    
    public static String[][] mostrarBilletes(){
        Gestor_conexion_POSTGRE gest = new Gestor_conexion_POSTGRE("juego",true);
        String vec[][];
        String consulta2="select * from azafata;";
        vec=Bd.consultaSelect(gest, consulta2);
        gest.cerrar_Conexion(true);
        return vec;
    }
    
    public int getIdBillete() {
        return idBillete;
    }
    
    public void setIdBillete(int idBillete) {
        this.idBillete = idBillete;
    }
    
    
    public int getNAsiento() {
        return nAsiento;
    }
    
    public void setNAsiento(int nAsiento) {
        this.nAsiento = nAsiento;
    }
}


package aerolillas;
import org.apache.commons.codec.digest.DigestUtils;//contraseña hash
import utilidades.bbdd.Bd;
import utilidades.bbdd.Gestor_conexion_POSTGRE;


public class Azafata {
    private int idAzafata;
    private boolean experienciaPreviaAzafata;
    private String nombreAzafata;
    private String primerApellidoAzafata;
    private int telefonoAzafata;
    private String correoAzafata;
    private String dniAzafata;
    private String passwdCorreoAzafata;

    public Azafata(int idAzafata, boolean experienciaPreviaAzafata, String nombreAzafata, String primerApellidoAzafata, int telefonoAzafata, String correoAzafata, String dniAzafata, String passwdCorreoAzafata) {
        this.idAzafata = idAzafata;
        this.experienciaPreviaAzafata = experienciaPreviaAzafata;
        this.nombreAzafata = nombreAzafata;
        this.primerApellidoAzafata = primerApellidoAzafata;
        this.telefonoAzafata = telefonoAzafata;
        this.correoAzafata = correoAzafata;
        this.dniAzafata = dniAzafata;
        this.passwdCorreoAzafata = passwdCorreoAzafata;
    }
    
    
    public void addAzafata(Azafata a){
        String passwdCorreoAzafata=DigestUtils.sha256Hex(this.passwdCorreoAzafata);
        Gestor_conexion_POSTGRE gest = new Gestor_conexion_POSTGRE("juego",true);
        String consulta1 = "INSERT INTO azafata (idazafata, dniazafata, nombre, primerapellido, telefono, correo, passwdcorreo, experienciaPrevia) VALUES (" + a.getIdAzafata() + ", '" + a.getDniAzafata() + "', '" + a.getNombreAzafata() + "', '" + a.getPrimerApellidoAzafata() + "', " + a.getTelefonoAzafata() + ", '" + a.getCorreoAzafata() + "', '" + passwdCorreoAzafata + "', '" + a.getExperienciaPreviaAzafata() + "')";
        Bd.consultaModificacion(gest, consulta1);
        gest.cerrar_Conexion(true);
    }
    
    public void borrarAzafata(Azafata a){
        Gestor_conexion_POSTGRE gest = new Gestor_conexion_POSTGRE("juego",true);
        String consultaEliminar = "DELETE FROM azafata WHERE dniAzafata = '" + a.getDniAzafata() + "' AND nombre = '" + a.getNombreAzafata() + "' AND primerapellido = '" + a.getPrimerApellidoAzafata() + "' AND telefono = " + a.getTelefonoAzafata() + " AND correo = '" + a.getCorreoAzafata() + "'"+ " AND experienciaprevia = '" + a.getExperienciaPreviaAzafata() + "'";
        Bd.consultaModificacion(gest, consultaEliminar);
        gest.cerrar_Conexion(true);
    }
    public static void asignarVuelo(Azafata a){
        Gestor_conexion_POSTGRE gest = new Gestor_conexion_POSTGRE("juego",true);
        String vec[][];
        String consulta="select * from vuelo where idazafata is null order by km desc limit 1";
        vec=Bd.consultaSelect(gest,consulta);
        String consulta2 = "update vuelo set idazafata='" + a.getIdAzafata() + "' where idvuelo="+vec[0][0];
        Bd.consultaModificacion(gest, consulta2);
        gest.cerrar_Conexion(true);
    }
    public static void cancelarVuelos(Azafata a){
        Gestor_conexion_POSTGRE gest = new Gestor_conexion_POSTGRE("juego",true);
        String vec[][];
        String consulta="select * from vuelo where idazafata is null order by km desc limit 1";
        vec=Bd.consultaSelect(gest,consulta);
        String consulta2 = "update vuelo set idazafata=null" + " where idazafata="+a.getIdAzafata();
        Bd.consultaModificacion(gest, consulta2);
        gest.cerrar_Conexion(true);
    }
    
    
    
    public static String[][] mostrarAzafatas(){
        Gestor_conexion_POSTGRE gest = new Gestor_conexion_POSTGRE("juego",true);
        String vec[][];
        String consulta2="select * from azafata;";
        vec=Bd.consultaSelect(gest, consulta2);
        gest.cerrar_Conexion(true);
        return vec;
    }

    public boolean getExperienciaPreviaAzafata() {
        return experienciaPreviaAzafata;
    }

    public void setExperienciaPreviaAzafata(boolean experienciaPreviaAzafata) {
        this.experienciaPreviaAzafata = experienciaPreviaAzafata;
    }
 
    public int getIdAzafata() {
        return idAzafata;
    }

    public void setIdAzafata(int idAzafata) {
        this.idAzafata = idAzafata;
    }
    
    
    public String getDniAzafata() {
        return dniAzafata;
    }

    public void setDniAzafata(String dniAzafata) {
        this.dniAzafata = dniAzafata;
    }

    public String getNombreAzafata() {
        return nombreAzafata;
    }

    public void setNombreAzafata(String nombreAzafata) {
        this.nombreAzafata = nombreAzafata;
    }

    public String getPrimerApellidoAzafata() {
        return primerApellidoAzafata;
    }

    public void setPrimerApellidoAzafata(String primerApellidoAzafata) {
        this.primerApellidoAzafata = primerApellidoAzafata;
    }

    public int getTelefonoAzafata() {
        return telefonoAzafata;
    }

    public void setTelefonoAzafata(int telefonoAzafata) {
        this.telefonoAzafata = telefonoAzafata;
    }

    public String getCorreoAzafata() {
        return correoAzafata;
    }

    public void setCorreoAzafata(String correoAzafata) {
        this.correoAzafata = correoAzafata;
    }

    public String getPasswdCorreoAzafata() {
        return passwdCorreoAzafata;
    }

    public void setPasswdCorreoAzafata(String passwdCorreoAzafata) {
        this.passwdCorreoAzafata = passwdCorreoAzafata;
    }   
}
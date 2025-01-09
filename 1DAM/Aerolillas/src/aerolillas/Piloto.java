
package aerolillas;
import org.apache.commons.codec.digest.DigestUtils;
import utilidades.bbdd.Bd;
import utilidades.bbdd.Gestor_conexion_POSTGRE;


public class Piloto {
    private int idPiloto;
    private String nivelPiloto;
    private String dniPiloto;
    private String nombrePiloto;
    private String primerApellidoPiloto;
    private int telefonoPiloto;
    private String correoPiloto;
    private String passwdCorreoPiloto;

    public Piloto(int idPiloto, String nivelPiloto, String dniPiloto, String nombrePiloto, String primerApellidoPiloto, int telefonoPiloto, String correoPiloto, String passwdCorreoPiloto) {
        this.idPiloto=idPiloto;
        this.nivelPiloto=nivelPiloto;
        this.dniPiloto = dniPiloto;
        this.nombrePiloto = nombrePiloto;
        this.primerApellidoPiloto = primerApellidoPiloto;
        this.telefonoPiloto = telefonoPiloto;
        this.correoPiloto = correoPiloto;
        this.passwdCorreoPiloto = passwdCorreoPiloto;
    }

    public void addPiloto(Piloto p){
        /*a parte de añadir a la base de datos el piloto cifrara la contraseña antes
        la passwdCorreoPiloto esta sin cifrar y la passwordCorreoPiloto esta cifrada*/
        String passwordCorreoPiloto=DigestUtils.sha256Hex(this.passwdCorreoPiloto);
        Gestor_conexion_POSTGRE gest = new Gestor_conexion_POSTGRE("juego",true);
        //String consulta1 = "INSERT INTO piloto (idpiloto,dniPiloto, nombrePiloto, primerApellidoPiloto, telefonoPiloto, correoPiloto, passwdcorreoPiloto,nivelpiloto) VALUES ("+ p.getIdPiloto() + ",'" + p.getDniPiloto() + "', '" + p.getNombrePiloto() + "', '" + p.getPrimerApellidoPiloto() + "', " + p.getTelefonoPiloto() + ", '" + p.getCorreoPiloto() + "', '" + passwordCorreoPiloto + "', '"+ p.getNivelPiloto()+"')";
        String consulta1 = "INSERT INTO piloto (idpiloto, dniPiloto, nombrePiloto, primerApellidoPiloto, telefonoPiloto, correoPiloto, passwdcorreoPiloto, nivelpiloto) VALUES (" + p.getIdPiloto() + ", '" + p.getDniPiloto() + "', '" + p.getNombrePiloto() + "', '" + p.getPrimerApellidoPiloto() + "', " + p.getTelefonoPiloto() + ", '" + p.getCorreoPiloto() + "', '" + passwordCorreoPiloto + "', '" + p.getNivelPiloto() + "')";
        Bd.consultaModificacion(gest, consulta1);
        gest.cerrar_Conexion(true);
    }
    public void borrarPiloto(Piloto p){
        Gestor_conexion_POSTGRE gest = new Gestor_conexion_POSTGRE("juego",true);
        String consultaEliminar = "DELETE FROM piloto WHERE dnipiloto = '" + p.getDniPiloto() + "' AND nombrepiloto = '" + p.getNombrePiloto() + "' AND primerapellidopiloto = '" + p.getPrimerApellidoPiloto() + "' AND telefonopiloto = " + p.getTelefonoPiloto() + " AND correopiloto = '" + p.getCorreoPiloto() + "'"+ " AND nivelpiloto = '" + p.getNivelPiloto() + "'";
        Bd.consultaModificacion(gest, consultaEliminar);
        gest.cerrar_Conexion(true);
    }
    
    public static boolean asignarVuelo(Piloto p){
        Gestor_conexion_POSTGRE gest = new Gestor_conexion_POSTGRE("juego",true);
        String vec[][];
        boolean booleano=false;
        String consulta="select * from vuelo where idpiloto is null order by km desc limit 1";
        vec=Bd.consultaSelect(gest,consulta);
        String consulta2 = "update vuelo set idpiloto='" + p.getIdPiloto() + "' where idvuelo="+vec[0][0];
        Bd.consultaModificacion(gest, consulta2);
        if (Bd.consultaModificacion(gest, consulta2)==true) {
            booleano=true;
        }
        
        gest.cerrar_Conexion(true);   
        return booleano;
    }
    
    public static boolean cancelarVuelos(Piloto p){
        Gestor_conexion_POSTGRE gest = new Gestor_conexion_POSTGRE("juego",true);
        String vec[][];
        boolean booleano=false;
        String consulta="select * from vuelo where idpiloto is null order by km desc limit 1";
        vec=Bd.consultaSelect(gest,consulta);
        String consulta2 = "update vuelo set idpiloto=null" + " where idpiloto="+p.getIdPiloto();
        Bd.consultaModificacion(gest, consulta2);
        if (Bd.consultaModificacion(gest, consulta2)==true) {
            booleano=true;
        }
        gest.cerrar_Conexion(true);
        return booleano;
    }
    
    public static void cancelarVuelo(Piloto p,String origen,String destino){
        Gestor_conexion_POSTGRE gest = new Gestor_conexion_POSTGRE("juego",true);
        origen="'"+origen+"'";
        destino="'"+destino+"'";
        String consulta2 = "update vuelo set idpiloto=null" + " where idpiloto="+p.getIdPiloto()+"and origen like"+origen+"and destino like"+destino;
        Bd.consultaModificacion(gest, consulta2);
        gest.cerrar_Conexion(true);
    }

    
    public static String[][] mostrarPilotos(){
        Gestor_conexion_POSTGRE gest = new Gestor_conexion_POSTGRE("juego",true);
        String vec[][];
        String consulta2="select * from piloto;";
        vec=Bd.consultaSelect(gest, consulta2);
        gest.cerrar_Conexion(true);
        return vec;
    }
    public static String[][] mostrarVuelosPiloto(Piloto p){
        Gestor_conexion_POSTGRE gest = new Gestor_conexion_POSTGRE("juego",true);
        String vec[][];
        String consulta2="select * from vuelo where dniPiloto='"+p.getDniPiloto()+"';";
        vec=Bd.consultaSelect(gest, consulta2);
        gest.cerrar_Conexion(true);
        return vec;
    }

    public String getNivelPiloto() {
        return nivelPiloto;
    }

    public void setNivelPiloto(String nivelPiloto) {
        this.nivelPiloto = nivelPiloto;
    }
 
    public int getIdPiloto() {
        return idPiloto;
    }

    public void setIdPiloto(int idPiloto) {
        this.idPiloto = idPiloto;
    }
    
    
    public String getDniPiloto() {
        return dniPiloto;
    }

    public void setDniPiloto(String dniPiloto) {
        this.dniPiloto = dniPiloto;
    }

    public String getNombrePiloto() {
        return nombrePiloto;
    }

    public void setNombrePiloto(String nombrePiloto) {
        this.nombrePiloto = nombrePiloto;
    }

    public String getPrimerApellidoPiloto() {
        return primerApellidoPiloto;
    }

    public void setPrimerApellidoPiloto(String primerApellidoPiloto) {
        this.primerApellidoPiloto = primerApellidoPiloto;
    }

    public int getTelefonoPiloto() {
        return telefonoPiloto;
    }

    public void setTelefonoPiloto(int telefonoPiloto) {
        this.telefonoPiloto = telefonoPiloto;
    }

    public String getCorreoPiloto() {
        return correoPiloto;
    }

    public void setCorreoPiloto(String correoPiloto) {
        this.correoPiloto = correoPiloto;
    }

    public String getPasswdCorreoPiloto() {
        return passwdCorreoPiloto;
    }

    public void setPasswdCorreoPiloto(String passwdCorreoPiloto) {
        this.passwdCorreoPiloto = passwdCorreoPiloto;
    }
}

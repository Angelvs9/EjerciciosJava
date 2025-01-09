package aerolillas;
import org.apache.commons.codec.digest.DigestUtils;//contraseña hash
import utilidades.bbdd.Bd;
import static utilidades.bbdd.Bd.crearBBDD;
import utilidades.bbdd.Gestor_conexion_POSTGRE;


public class Persona {
    private String dni;
    private String nombre;
    private String primerApellido;
    private int telefono;
    private String correo;
    private String passwdCorreo;
    

    // Constructor
    public Persona(String dni,String nombre, String primerApellido, int telefono, String correo, String passwdCorreo) {
        this.dni = dni;
        this.nombre= nombre;
        this.primerApellido = primerApellido;
        this.telefono = telefono;
        this.correo = correo;
        this.passwdCorreo = passwdCorreo;
        
    }
 
    public void addPersona(Persona p){
        /*a parte de añadir a la base de datos la persona cifrara la contraseña antes
        la passwdCorreo esta sin cifrar y la passwordCorreo esta cifrada*/
        String passwordCorreo=DigestUtils.sha256Hex(this.passwdCorreo);//contraseña cifrada
        Gestor_conexion_POSTGRE gest = new Gestor_conexion_POSTGRE("juego",true);
        String consulta1 = "INSERT INTO persona (dni, nombre, primerApellido, telefono, correo, passwdcorreo) VALUES ('" + p.getDni() + "', '" + p.getNombre() + "', '" + p.getPrimerApellido() + "', " + p.getTelefono() + ", '" + p.getCorreo() + "', '" + passwordCorreo + "')";
        Bd.consultaModificacion(gest, consulta1);
        gest.cerrar_Conexion(true);
        consulta1="";
    }
    
    public void borrarPersona(Persona p){
        Gestor_conexion_POSTGRE gest = new Gestor_conexion_POSTGRE("juego",true);
        String consultaEliminar = "DELETE FROM persona WHERE dni = '" + p.getDni() + "' AND nombre = '" + p.getNombre() + "' AND primerApellido = '" + p.getPrimerApellido() + "' AND telefono = " + p.getTelefono() + " AND correo = '" + p.getCorreo() + "'";
        Bd.consultaModificacion(gest, consultaEliminar);
        gest.cerrar_Conexion(true);
        consultaEliminar="";
    }
    
    
    
    public static String[][] mostrarPersonas(){
        Gestor_conexion_POSTGRE gest = new Gestor_conexion_POSTGRE("juego",false);
        String vecPersona[][];
        String consulta2="select * from persona;";
        vecPersona=Bd.consultaSelect(gest, consulta2);
        gest.cerrar_Conexion(true);
        return vecPersona;
    }
    
    public boolean comprarBillete (String origen, String destino, String dniPersona){
        Boolean booleano=false;
        String vec[][];//el metodo de consulta select devuelve siempre un vector[][]
        String vec2[][];
        Gestor_conexion_POSTGRE gest = new Gestor_conexion_POSTGRE("juego",false);
        String consulta1="select idvuelo from vuelo where origen LIKE "+"'"+origen+"'"+"and destino like "+"'"+destino+"'";
        vec=Bd.consultaSelect(gest, consulta1);
        String consulta2="select idbillete from billete where idvuelo="+vec[0][0]+" and dnipersona is null order by nasiento limit 1;";
        vec2=Bd.consultaSelect(gest, consulta2);
        String consulta3="update billete set dnipersona="+"'"+dniPersona+"' where "+"idbillete="+vec2[0][0]+";";
        Bd.consultaModificacion(gest, consulta3);
        gest.cerrar_Conexion(true);
         return booleano;
    }
    public static String[][] mostrarBilletesPersona(Persona p){
        Gestor_conexion_POSTGRE gest = new Gestor_conexion_POSTGRE("juego",false);
        String vecBilletePersona[][];
        String consulta2="select * from persona where dni='"+p.getDni()+"'";
        vecBilletePersona=Bd.consultaSelect(gest, consulta2);
        gest.cerrar_Conexion(true);
        return vecBilletePersona;
    }
    
    
    
    public boolean cancelarBillete (String origen, String destino, String dniPersona){
        Boolean booleano=false;
        String vec[][];//el metodo de consulta select devuelve siempre un vector[][]
        String vec2[][];
        Gestor_conexion_POSTGRE gest = new Gestor_conexion_POSTGRE("juego",true);
        String consulta1="select idvuelo from vuelo where origen LIKE "+"'"+origen+"'"+"and destino like "+"'"+destino+"'";
        vec=Bd.consultaSelect(gest, consulta1);
        String consulta2="select idbillete from billete where idvuelo="+vec[0][0]+" and dnipersona is null order by nasiento limit 1;";
        vec2=Bd.consultaSelect(gest, consulta2);
        String consulta3="alter table billete alter column dnipersona "+"set null"+"where idbillete="+vec2[0][0]+";";
        Bd.consultaModificacion(gest, consulta3);
        gest.cerrar_Conexion(true);
         return booleano;
    }
    
    // Getters
    public String getDni() {
        return dni;
    }
    public String getNombre() {
        return nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public String getPasswdCorreo() {
        return passwdCorreo;
    }

    // Setters
    public void setDni(String dni) {
        this.dni = dni;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setPasswdCorreo(String passwdCorreo) {
        this.passwdCorreo = passwdCorreo;
    }
}


package aerolillas;
import utilidades.bbdd.Bd;
import utilidades.bbdd.Gestor_conexion_POSTGRE;


public class Avion {
    private int id;
    private String modelo;
    private double peso;
    private double depositoTotal;
    private double combustibleActual;
    private int salidasEmergencia;
    private int chalecosDisp;
    private int asientos;
    private int contador=1;

    public Avion(int id,String modelo, double peso, double depositoTotal, double combustibleActual, int salidasEmergencia, int chalecosDisp, int asientos) {
        this.id = id;
        this.modelo = modelo;
        this.peso = peso;
        this.depositoTotal = depositoTotal;
        this.combustibleActual = combustibleActual;
        this.salidasEmergencia = salidasEmergencia;
        this.chalecosDisp = chalecosDisp;
        this.asientos = asientos;
    }

    public void hacerVuelo(int idvuelo,String origen,String destino,double km, int puertaembarque, int idavion){
        Gestor_conexion_POSTGRE gest = new Gestor_conexion_POSTGRE("juego", true);
        
        //String consulta = "INSERT INTO vuelo (idvuelo, origendestino, km, puertaembarque, idavion) VALUES ("+contador+",+'origendestino'+,"+km+", "+puertaembarque+","+idavion+")";
        String consulta = "INSERT INTO vuelo (idvuelo, origen, destino, km, puertaembarque, idavion) VALUES (" + idvuelo + ", '"+ origen +"', '"+ destino +"', "+ km + ", " + puertaembarque + ", " + idavion + ")";
        contador++;
        Bd.consultaModificacion(gest, consulta);
    }
    
    public static void addAvion(Avion a){
        Gestor_conexion_POSTGRE gest = new Gestor_conexion_POSTGRE("juego", true);
        
        //String consulta = "INSERT INTO vuelo (idvuelo, origendestino, km, puertaembarque, idavion) VALUES ("+contador+",+'origendestino'+,"+km+", "+puertaembarque+","+idavion+")";
        String consulta1 = "INSERT INTO avion (id, modelo, peso, depositototal, combustibleactual, salidasemergencia, chalecosdisp, asientos) VALUES (" + a.getId() + ", '" + a.getModelo() + "', " + a.getPeso() + ", " + a.getDepositoTotal() + ", " + a.getCombustibleActual() + ", " + a.getSalidasEmergencia() + ", " + a.getChalecosDisp() + ", " + a.getAsientos() + ")";
        Bd.consultaModificacion(gest, consulta1);
       
    }
    
    public static String[][] mostrarVuelos(){
        Gestor_conexion_POSTGRE gest = new Gestor_conexion_POSTGRE("juego", true);
        String listaVuelos[][];
        listaVuelos=Bd.consultaSelect(gest, "select * from vuelo;");
        return listaVuelos;
    }
    
    
   public static String[][] mostrarVuelos(Avion a){
       Gestor_conexion_POSTGRE gest = new Gestor_conexion_POSTGRE("juego", true);
        String listaVuelosAvion[][];
        listaVuelosAvion=Bd.consultaSelect(gest, "select * from vuelo where idvuelo="+a.getId());
        return listaVuelosAvion;
    }

    public int getId() {
        return id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getDepositoTotal() {
        return depositoTotal;
    }

    public void setDepositoTotal(double depositoTotal) {
        this.depositoTotal = depositoTotal;
    }

    public double getCombustibleActual() {
        return combustibleActual;
    }

    public void setCombustibleActual(double combustibleActual) {
        this.combustibleActual = combustibleActual;
    }

    public int getSalidasEmergencia() {
        return salidasEmergencia;
    }

    public void setSalidasEmergencia(int salidasEmergencia) {
        this.salidasEmergencia = salidasEmergencia;
    }

    public int getChalecosDisp() {
        return chalecosDisp;
    }

    public void setChalecosDisp(int chalecosDisp) {
        this.chalecosDisp = chalecosDisp;
    }

    public int getAsientos() {
        return asientos;
    }

    public void setAsientos(int asientos) {
        this.asientos = asientos;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    @Override
    public String toString() {
        
        return "Avion{" + "modelo=" + modelo + ", peso=" + peso + ", depositoTotal=" + depositoTotal + ", combustibleActual=" + combustibleActual + ", salidasEmergencia=" + salidasEmergencia + ", chalecosDisp=" + chalecosDisp + ", asientos=" + asientos + '}';
    }
}


package Modelo;

/**
 *
 * @author Usuario
 */
public class Maquina {
    
    private int ncodigo;
    private String cmodelo;
    private double npeso;
    private double naltura;
    private int nlocal;

    public Maquina(String cmodelo, double npeso, double naltura, int nlocal) {
        this.cmodelo = cmodelo;
        this.npeso = npeso;
        this.naltura = naltura;
        this.nlocal = nlocal;
    }

    public int getNcodigo() {
        return ncodigo;
    }

    public void setNcodigo(int ncodigo) {
        this.ncodigo = ncodigo;
    }

    public String getCmodelo() {
        return cmodelo;
    }

    public void setCmodelo(String cmodelo) {
        this.cmodelo = cmodelo;
    }

    public double getNpeso() {
        return npeso;
    }

    public void setNpeso(double npeso) {
        this.npeso = npeso;
    }

    public double getNaltura() {
        return naltura;
    }

    public void setNaltura(double naltura) {
        this.naltura = naltura;
    }

    public int getNlocal() {
        return nlocal;
    }

    public void setNlocal(int nlocal) {
        this.nlocal = nlocal;
    }

    @Override
    public String toString() {
        return "Maquina{" + "ncodigo=" + ncodigo + ", cmodelo=" + cmodelo + ", npeso=" + npeso + ", naltura=" + naltura + ", nlocal=" + nlocal + '}';
    }
    
}

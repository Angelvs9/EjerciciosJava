
package Modelo;

/**
 *
 * @author Angel
 */
public class Canal {
    
    private int ncodigo;
    private String cnombre;
    private int nprecio;
    private int nseries;

    public Canal(String cnombre, int nprecio, int nseries) {
        this.cnombre = cnombre;
        this.nprecio = nprecio;
        this.nseries = nseries;
    }

    public int getNcodigo() {
        return ncodigo;
    }

    public void setNcodigo(int ncodigo) {
        this.ncodigo = ncodigo;
    }

    public String getCnombre() {
        return cnombre;
    }

    public void setCnombre(String cnombre) {
        this.cnombre = cnombre;
    }

    public int getNprecio() {
        return nprecio;
    }

    public void setNprecio(int nprecio) {
        this.nprecio = nprecio;
    }

    public int getNseries() {
        return nseries;
    }

    public void setNseries(int nseries) {
        this.nseries = nseries;
    }

    @Override
    public String toString() {
        return "Canal{" + "ncodigo=" + ncodigo + ", cnombre=" + cnombre + ", nprecio=" + nprecio + ", nseries=" + nseries + '}';
    }
    
}

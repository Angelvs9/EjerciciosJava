
package Modelo;

/**
 *
 * @author Usuario
 */
public class Producto {
    
    private int ncodigo;
    private String cnombre;
    private double nprecio;
    private byte [] bfoto;
    private Nutriente bnutrientes;

    public Producto(String cnombre, double nprecio, byte[] bfoto, Nutriente bnutrientes) {
        this.cnombre = cnombre;
        this.nprecio = nprecio;
        this.bfoto = bfoto;
        this.bnutrientes = bnutrientes;
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

    public double getNprecio() {
        return nprecio;
    }

    public void setNprecio(double nprecio) {
        this.nprecio = nprecio;
    }

    public byte[] getBfoto() {
        return bfoto;
    }

    public void setBfoto(byte[] bfoto) {
        this.bfoto = bfoto;
    }

    public Nutriente getBnutrientes() {
        return bnutrientes;
    }

    public void setBnutrientes(Nutriente bnutrientes) {
        this.bnutrientes = bnutrientes;
    }

    @Override
    public String toString() {
        return "Producto{" + "ncodigo=" + ncodigo + ", cnombre=" + cnombre + ", nprecio=" + nprecio + ", bfoto=" + bfoto + ", bnutrientes=" + bnutrientes + '}';
    }
    
    
    
    
    
}

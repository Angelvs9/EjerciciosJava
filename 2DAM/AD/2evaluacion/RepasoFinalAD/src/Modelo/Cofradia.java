package Modelo;

/**
 * @author Usuario
 */
public class Cofradia {
    
    private int ncodigo;
    private String cnombre;
    private String cdireccion;
    private String cfichero;
    private byte [] bfoto;
    private int nparroquia;//fk a parroquias

    public Cofradia(int ncodigo, String cnombre, String cdireccion, String cfichero, byte[] bfoto, int nparroquia) {
        this.ncodigo = ncodigo;
        this.cnombre = cnombre;
        this.cdireccion = cdireccion;
        this.cfichero = cfichero;
        this.bfoto = bfoto;
        this.nparroquia = nparroquia;
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

    public String getCdireccion() {
        return cdireccion;
    }

    public void setCdireccion(String cdireccion) {
        this.cdireccion = cdireccion;
    }

    public String getCfichero() {
        return cfichero;
    }

    public void setCfichero(String cfichero) {
        this.cfichero = cfichero;
    }

    public byte[] getBfoto() {
        return bfoto;
    }

    public void setBfoto(byte[] bfoto) {
        this.bfoto = bfoto;
    }

    public int getNparroquia() {
        return nparroquia;
    }

    public void setNparroquia(int nparroquia) {
        this.nparroquia = nparroquia;
    }

    @Override
    public String toString() {
        return "Cofradia{" + "ncodigo=" + ncodigo + ", cnombre=" + cnombre + ", cdireccion=" + cdireccion + ", cfichero=" + cfichero + ", nparroquia=" + nparroquia + '}';
    }

}

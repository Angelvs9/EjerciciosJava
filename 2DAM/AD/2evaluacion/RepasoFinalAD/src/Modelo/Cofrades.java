
package Modelo;
/*
 * @author Usuario
 */
public class Cofrades {
    
    private int ncodigo;
    private int ncofradia;//fk a ncofradia
    private String cnombre;
    private String capellidos;
    private String ctelefono;
    private int nedad;

    public Cofrades(int ncodigo, int ncofradia, String cnombre, String capellidos, String ctelefono, int nedad) {
        this.ncodigo = ncodigo;
        this.ncofradia = ncofradia;
        this.cnombre = cnombre;
        this.capellidos = capellidos;
        this.ctelefono = ctelefono;
        this.nedad = nedad;
    }

    public Cofrades(int ncofradia, String cnombre, String capellidos, String ctelefono, int nedad) {
        this.ncofradia = ncofradia;
        this.cnombre = cnombre;
        this.capellidos = capellidos;
        this.ctelefono = ctelefono;
        this.nedad = nedad;
    }

    public int getNcodigo() {
        return ncodigo;
    }

    public void setNcodigo(int ncodigo) {
        this.ncodigo = ncodigo;
    }

    public int getNcofradia() {
        return ncofradia;
    }

    public void setNcofradia(int ncofradia) {
        this.ncofradia = ncofradia;
    }

    public String getCnombre() {
        return cnombre;
    }

    public void setCnombre(String cnombre) {
        this.cnombre = cnombre;
    }

    public String getCapellidos() {
        return capellidos;
    }

    public void setCapellidos(String capellidos) {
        this.capellidos = capellidos;
    }

    public String getCtelefono() {
        return ctelefono;
    }

    public void setCtelefono(String ctelefono) {
        this.ctelefono = ctelefono;
    }

    public int getNedad() {
        return nedad;
    }

    public void setNedad(int nedad) {
        this.nedad = nedad;
    }

    @Override
    public String toString() {
        return "Cofrades{" + "ncodigo=" + ncodigo + ", ncofradia=" + ncofradia + ", cnombre=" + cnombre + ", capellidos=" + capellidos + ", ctelefono=" + ctelefono + ", nedad=" + nedad + '}';
    }
    
    
}

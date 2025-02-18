
package Modelo;

/**
 * @author Usuario
 */
public class Parroquia {
    
    private int ncodigo;
    private String cnombre;
    private String cdireccion;
    private String csacerdote;

    public Parroquia(int ncodigo, String cnombre, String cdireccion, String csacerdote) {
        this.ncodigo = ncodigo;
        this.cnombre = cnombre;
        this.cdireccion = cdireccion;
        this.csacerdote = csacerdote;
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

    public String getCsacerdote() {
        return csacerdote;
    }

    public void setCsacerdote(String csacerdote) {
        this.csacerdote = csacerdote;
    }

    @Override
    public String toString() {
        return "Parroquia{" + "ncodigo=" + ncodigo + ", cnombre=" + cnombre + ", cdireccion=" + cdireccion + ", csacerdote=" + csacerdote + '}';
    }
    
    
}


package Modelo;

/**

 * @author Usuario
 */
public class Local {
    
    private int ncodigo;
    private String cpoblacion;
    private String cdireccion;

    public Local(String cpoblacion, String cdireccion) {
        this.cpoblacion = cpoblacion;
        this.cdireccion = cdireccion;
    }

    public int getNcodigo() {
        return ncodigo;
    }

    public void setNcodigo(int ncodigo) {
        this.ncodigo = ncodigo;
    }

    public String getCpoblacion() {
        return cpoblacion;
    }

    public void setCpoblacion(String cpoblacion) {
        this.cpoblacion = cpoblacion;
    }

    public String getCdireccion() {
        return cdireccion;
    }

    public void setCdireccion(String cdireccion) {
        this.cdireccion = cdireccion;
    }

    @Override
    public String toString() {
        return "Local{" + "ncodigo=" + ncodigo + ", cpoblacion=" + cpoblacion + ", cdireccion=" + cdireccion + '}';
    }
     
}


package Modelo;

import java.io.Serializable;

/**
 *
 * @author Usuario
 */
public class Cosa implements Serializable{
    
    private int ncodigo;
    private OtraCosa otro;
    private byte [] fichero;

    public Cosa(OtraCosa otro, byte[] fichero) {
        this.otro = otro;
        this.fichero = fichero;
    }

    public int getNcodigo() {
        return ncodigo;
    }

    public void setNcodigo(int ncodigo) {
        this.ncodigo = ncodigo;
    }

    public OtraCosa getOtro() {
        return otro;
    }

    public void setOtro(OtraCosa otro) {
        this.otro = otro;
    }

    public byte[] getFichero() {
        return fichero;
    }

    public void setFichero(byte[] fichero) {
        this.fichero = fichero;
    }

    @Override
    public String toString() {
        return "Cosa{" + "ncodigo=" + ncodigo + ", otro=" + otro + ", fichero=" + fichero + '}';
    }

    
    
    
    
    
}

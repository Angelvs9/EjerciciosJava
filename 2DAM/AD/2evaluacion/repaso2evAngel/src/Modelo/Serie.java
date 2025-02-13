
package Modelo;

import java.sql.Blob;

/**
 * @author Usuario
 */
public class Serie {
   
    private int ncodigo;
    private String ctitulo;
    private String cgenero;
    private int nanyo;
    private Blob bfoto;
    private int ncanal;
    private String cfoto;

    public Serie(int ncodigo, String ctitulo, String cgenero, int nanyo, int ncanal, String cfoto) {
        this.ncodigo = ncodigo;
        this.ctitulo = ctitulo;
        this.cgenero = cgenero;
        this.nanyo = nanyo;
        this.ncanal = ncanal;
        this.cfoto = cfoto;
    }

    public void setBfoto(Blob bfoto) {
        this.bfoto = bfoto;
    }
    
    

    public int getNcodigo() {
        return ncodigo;
    }

    public void setNcodigo(int ncodigo) {
        this.ncodigo = ncodigo;
    }

    public String getCfoto() {
        return cfoto;
    }

    public void setCfoto(String cfoto) {
        this.cfoto = cfoto;
    }

    public String getCtitulo() {
        return ctitulo;
    }

    public void setCtitulo(String ctitulo) {
        this.ctitulo = ctitulo;
    }

    public String getCgenero() {
        return cgenero;
    }

    public void setCgenero(String cgenero) {
        this.cgenero = cgenero;
    }

    public int getNanyo() {
        return nanyo;
    }

    public void setNanyo(int nanyo) {
        this.nanyo = nanyo;
    }

    public int getNcanal() {
        return ncanal;
    }

    public void setNcanal(int ncanal) {
        this.ncanal = ncanal;
    }

    @Override
    public String toString() {
        return "Serie{" + "ctitulo=" + ctitulo + ", cgenero=" + cgenero + ", nanyo=" + nanyo + ", ncanal=" + ncanal + '}';
    }
    
}


package Modelo;

/**
 *
 * @author Angel
 */
public class Serie {
    
    private int ncodigo;
    private String ctitulo;
    private String cgenero;
    private int nanyo;
    private byte[] bfoto;
    private int ncanal;
    private String cfoto;

    public Serie(int ncodigo, String ctitulo, String cgenero, int nanyo, byte[] bfoto, int ncanal, String cfoto) {
        this.ncodigo = ncodigo;
        this.ctitulo = ctitulo;
        this.cgenero = cgenero;
        this.nanyo = nanyo;
        this.bfoto = bfoto;
        this.ncanal = ncanal;
        this.cfoto = cfoto;
    }

    public int getNcodigo() {
        return ncodigo;
    }

    public void setNcodigo(int ncodigo) {
        this.ncodigo = ncodigo;
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

    public byte[] getBfoto() {
        return bfoto;
    }

    public void setBfoto(byte[] bfoto) {
        this.bfoto = bfoto;
    }

    public int getNcanal() {
        return ncanal;
    }

    public void setNcanal(int ncanal) {
        this.ncanal = ncanal;
    }

    public String getCfoto() {
        return cfoto;
    }

    public void setCfoto(String cfoto) {
        this.cfoto = cfoto;
    }

    @Override
    public String toString() {
        return "Serie{" + "ncodigo=" + ncodigo + ", ctitulo=" + ctitulo + ", cgenero=" + cgenero + ", nanyo=" + nanyo + ", bfoto=" + bfoto + ", ncanal=" + ncanal + ", cfoto=" + cfoto + '}';
    }

}

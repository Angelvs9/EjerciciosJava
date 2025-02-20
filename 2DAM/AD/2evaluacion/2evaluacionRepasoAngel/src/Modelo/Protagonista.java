
package Modelo;

/**
 *
 * @author Angel
 */
public class Protagonista {
    
    private int ncodigo;
    private String cnombre;
    private int nedad;
    private byte[] bcurriculum;
    private int nseries;
    private String ccurriculum;// nombre del archvio 

    public Protagonista(int ncodigo, String cnombre, int nedad, byte[] bcurriculum, int nseries, String ccurriculum) {
        this.ncodigo = ncodigo;
        this.cnombre = cnombre;
        this.nedad = nedad;
        this.bcurriculum = bcurriculum;
        this.nseries = nseries;
        this.ccurriculum = ccurriculum;
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

    public int getNedad() {
        return nedad;
    }

    public void setNedad(int nedad) {
        this.nedad = nedad;
    }

    public byte[] getBcurriculum() {
        return bcurriculum;
    }

    public void setBcurriculum(byte[] bcurriculum) {
        this.bcurriculum = bcurriculum;
    }

    public int getNseries() {
        return nseries;
    }

    public void setNseries(int nseries) {
        this.nseries = nseries;
    }

    public String getCcurriculum() {
        return ccurriculum;
    }

    public void setCcurriculum(String ccurriculum) {
        this.ccurriculum = ccurriculum;
    }

    @Override
    public String toString() {
        return "Protagonista{" + "ncodigo=" + ncodigo + ", cnombre=" + cnombre + ", nedad=" + nedad + ", bcurriculum=" + bcurriculum + ", nseries=" + nseries + ", ccurriculum=" + ccurriculum + '}';
    }
    
    
}

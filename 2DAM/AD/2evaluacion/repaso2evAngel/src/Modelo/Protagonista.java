
package Modelo;

import java.sql.Blob;


public class Protagonista {
    private int ncodigo;//no es autonumerica
    private String cnombre;
    private int nedad;
    private Blob bcurriculum;//pdf
    private int nserie;
    private String ccurriculum;

    public Protagonista(int ncodigo, String cnombre, int nedad, Blob bcurriculum, int nserie, String ccurriculum) {
        this.ncodigo = ncodigo;
        this.cnombre = cnombre;
        this.nedad = nedad;
        this.bcurriculum = bcurriculum;
        this.nserie = nserie;
        this.ccurriculum = ccurriculum;
    }

    public int getNcodigo() {
        return ncodigo;
    }

    public String getCnombre() {
        return cnombre;
    }

    public int getNedad() {
        return nedad;
    }

    public Blob getBcurriculum() {
        return bcurriculum;
    }

    public int getNserie() {
        return nserie;
    }

    public void setNcodigo(int ncodigo) {
        this.ncodigo = ncodigo;
    }

    public void setCnombre(String cnombre) {
        this.cnombre = cnombre;
    }

    public void setNedad(int nedad) {
        this.nedad = nedad;
    }

    public void setBcurriculum(Blob bcurriculum) {
        this.bcurriculum = bcurriculum;
    }

    public void setNserie(int nserie) {
        this.nserie = nserie;
    }

    public void setCcurriculum(String ccurriculum) {
        this.ccurriculum = ccurriculum;
    }

    @Override
    public String toString() {
        return "Protagonista{" + "ncodigo=" + ncodigo + ", cnombre=" + cnombre + ", nedad=" + nedad + ", bcurriculum=" + bcurriculum + ", nserie=" + nserie + ", ccurriculum=" + ccurriculum + '}';
    }
    
        
    
    
}

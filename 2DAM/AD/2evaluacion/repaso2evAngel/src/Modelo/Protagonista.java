
package Modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Blob;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Protagonista implements Serializable{
    private int ncodigo;//no es autonumerica
    private String cnombre;
    private int nedad;
    private byte[] bcurriculum;//pdf
    private int nserie;
    private String ccurriculum;

    public Protagonista(int ncodigo, String cnombre, int nedad, int nserie, String ccurriculum) {
        this.ncodigo = ncodigo;
        this.cnombre = cnombre;
        this.nedad = nedad;
        this.nserie = nserie;
        this.ccurriculum = ccurriculum;
        this.insertarCV(cnombre+".pdf");
    }

    public void insertarCV(String nombreCV){
        try {
            File f=new File(nombreCV);
            bcurriculum=new byte[(int)f.length()];
            FileInputStream fis=new FileInputStream(f);
            fis.read(bcurriculum);
            fis.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Protagonista.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Protagonista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public byte[] getBcurriculum() {
        return bcurriculum;
    }
    
    public String getCcurriculum() {
        return ccurriculum;
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

    public void setBcurriculum(byte[] bcurriculum) {
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

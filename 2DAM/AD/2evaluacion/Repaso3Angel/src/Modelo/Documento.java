
package Modelo;

import com.itextpdf.text.pdf.qrcode.ByteArray;

/**
 *
 * @author Usuario
 */
public class Documento {
    private int ncliente; //c ajena a ncodigo clientes
    private String ctipo;
    private ByteArray[] bdoc;//documento en si longblob
    private Metadatos bmeta;//metadatos solo uno por documento blob

    public Documento(int ncliente, String ctipo, ByteArray[] bdoc, Metadatos bmeta) {
        this.ncliente = ncliente;
        this.ctipo = ctipo;
        this.bdoc = bdoc;
        this.bmeta = bmeta;
    }

    public Documento(int ncliente, ByteArray[] bdoc, Metadatos bmeta) {
        this.ncliente = ncliente;
        this.bdoc = bdoc;
        this.bmeta = bmeta;
        ctipo="pdf";
    }



    public int getNcliente() {
        return ncliente;
    }

    public String getCtipo() {
        return ctipo;
    }

    public ByteArray[] getBdoc() {
        return bdoc;
    }

    public Metadatos getBmeta() {
        return bmeta;
    }

    @Override
    public String toString() {
        return "Documento{" + "ncliente=" + ncliente + ", ctipo=" + ctipo + ", bdoc=" + bdoc + ", bmeta=" + bmeta + '}';
    }
  
}

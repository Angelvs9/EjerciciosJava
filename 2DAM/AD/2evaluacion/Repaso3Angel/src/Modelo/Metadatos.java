
package Modelo;

import com.itextpdf.text.pdf.qrcode.ByteArray;

/**
 *
 * @author Usuario
 */
public class Metadatos extends Documento{
    private String nombre;
    private String fecha;
    private Cliente usuario;
    private String ctipo;
    private double tamanyo ;
    private String nombrefichero;//nombre en si del fichero

    public Metadatos(String nombre, String fecha, Cliente usuario, String ctipo, double tamanyo, String nombrefichero, int ncliente, ByteArray[] bdoc, Metadatos bmeta) {
        super(ncliente, bdoc, bmeta);
        this.nombre = nombre;
        this.fecha = fecha;
        this.usuario = usuario;
        this.ctipo = ctipo;
        this.tamanyo = tamanyo;
        this.nombrefichero = nombrefichero;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public Cliente getUsuario() {
        return usuario;
    }

    public String getCtipo() {
        return ctipo;
    }

    public double getTamanyo() {
        return tamanyo;
    }

    public String getNombrefichero() {
        return nombrefichero;
    }

   

    @Override
    public String toString() {
        return "Metadatos{" + "nombre=" + nombre + ", fecha=" + fecha + ", usuario=" + usuario + ", ctipo=" + ctipo + ", tamanyo=" + tamanyo + ", nombrefichero=" + nombrefichero + '}';
    }

    
}

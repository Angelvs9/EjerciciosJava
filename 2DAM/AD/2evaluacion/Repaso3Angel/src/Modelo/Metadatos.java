
package Modelo;

import com.itextpdf.text.pdf.qrcode.ByteArray;
import java.io.File;
import java.io.Serializable;

/**
 *
 * @author Usuario
 */
public class Metadatos implements Serializable{
    private String nombre;
    private String fecha;
    private Cliente usuario;
    private String ctipo;
    private double tamanyo ;
    private String nombrefichero;//nombre en si del fichero

    public Metadatos(String nombre, String fecha, Cliente usuario, String ctipo,String nombrefichero) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.usuario = usuario;
        this.ctipo = ctipo;
        this.nombrefichero = nombrefichero;
        File f=new File(nombrefichero);
        this.tamanyo=f.getTotalSpace();
    }

    public Metadatos(String nombre, String fecha, Cliente usuario, String nombrefichero) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.usuario = usuario;
        this.tamanyo = tamanyo;
        this.nombrefichero = nombrefichero;
        ctipo="pdf";
        File f=new File(nombrefichero);
        this.tamanyo=f.getTotalSpace();
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

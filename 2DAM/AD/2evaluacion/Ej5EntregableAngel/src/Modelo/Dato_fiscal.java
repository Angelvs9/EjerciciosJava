
package Modelo;

/**
 *
 * @author Angel
 */
public class Dato_fiscal {
    private int codigo;//auto
    private String nif;
    private String nombre;
    private String apellidos;
    private int cp;//clave ajena al codigo de poblaciones
    private long ca;//clave ajena al codigo(long) de cuenta_clientes

    public Dato_fiscal(int codigo, String nif, String nombre, String apellidos, int cp, long ca) {
        this.codigo = codigo;
        this.nif = nif;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.cp = cp;
        this.ca = ca;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public long getCa() {
        return ca;
    }

    public void setCa(long ca) {
        this.ca = ca;
    }

    @Override
    public String toString() {
        return "Dato_fiscal{" + "codigo=" + codigo + ", nif=" + nif + ", nombre=" + nombre + ", apellidos=" + apellidos + ", cp=" + cp + ", ca=" + ca + '}';
    }
    
    
}

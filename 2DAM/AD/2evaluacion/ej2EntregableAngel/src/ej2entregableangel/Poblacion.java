
package ej2entregableangel;


public class Poblacion {
    private int codigo;
    private String nombre;
    private String cod_postal;

    public Poblacion(int codigo, String nombre, String co_postal) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cod_postal = co_postal;
    }

    public Poblacion(String nombre, String cod_postal) {
        this.nombre = nombre;
        this.cod_postal = cod_postal;
    }
    

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCod_postal() {
        return cod_postal;
    }

    public void setCod_postal(String co_postal) {
        this.cod_postal = co_postal;
    }

    @Override
    public String toString() {
        return "Poblacion{" + "codigo=" + codigo + ", nombre=" + nombre + ", co_postal=" + cod_postal + '}';
    }
    
    
    
}


package ej2entregableangel;


public class Datos_fiscales {
    
    private String nombre;
    private String apellidos;
    private String nif;
    private int edad;
    private int poblacion;

    public Datos_fiscales(String nombre, String apellidos, String nif, int edad, int poblacion) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nif = nif;
        this.edad = edad;
        this.poblacion = poblacion;
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

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(int poblacion) {
        this.poblacion = poblacion;
    }

    @Override
    public String toString() {
        return "Datos_fiscales{" + "nombre=" + nombre + ", apellidos=" + apellidos + ", nif=" + nif + ", edad=" + edad + ", poblacion=" + poblacion + '}';
    }
    
    
    
}

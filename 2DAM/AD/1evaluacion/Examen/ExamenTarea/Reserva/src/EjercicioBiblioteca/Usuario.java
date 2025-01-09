
package EjercicioBiblioteca;

import java.io.Serializable;


public class Usuario implements Serializable,Comparable<Usuario>{
    private String dni;
    private String nombre;
    private int edad;

    public Usuario(String dni, String nombre, int edad) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
    }

    public boolean equals(Usuario r){
        boolean booleano=false;
        if(this.getDni().equals(r.getDni()))
            booleano=true;
        
        return booleano;
    }
    
    
    
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "dni=" + dni + ", nombre=" + nombre + ", edad=" + edad + '}';
    }

    @Override
    public int compareTo(Usuario o) {
        int i=0;
            if (this.getEdad() > o.getEdad())
                i=1;
            if(this.getEdad()<o.getEdad())
                i=-1;
            //si no entra es que es igual de edad
        return i;
    }
    
    
    
    
    
}

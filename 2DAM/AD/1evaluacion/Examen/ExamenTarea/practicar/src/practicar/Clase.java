
package practicar;

import java.util.ArrayList;
import java.util.List;


public class Clase {
    private String nombre;
    private String instructor;
    private String horario;
    private int capacidadMaxima;
    private List<Usuario> inscritos;

    // Constructor
    public Clase(String nombre, String instructor, String horario, int capacidadMaxima) {
        this.nombre = nombre;
        this.instructor = instructor;
        this.horario = horario;
        this.capacidadMaxima = capacidadMaxima;
        this.inscritos = new ArrayList<>();
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public List<Usuario> getInscritos() {
        return inscritos;
    }

    @Override
    public String toString() {
        return "Clase{" + "nombre=" + nombre + ", instructor=" + instructor + ", horario=" + horario + ", capacidadMaxima=" + capacidadMaxima + ", inscritos=" + inscritos + '}';
    }

    
}

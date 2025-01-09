
package practicar;


public class Usuario {
    private String nombre;
    private String apellido;
    private String id;
    private Membresia membresia;

    public Usuario(String nombre, String apellido, String id, Membresia membresia) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
        this.membresia = membresia;
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Membresia getMembresia() {
        return membresia;
    }

    public void setMembresia(Membresia membresia) {
        this.membresia = membresia;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre + ", apellido=" + apellido + ", id=" + id + ", membresia=" + membresia + '}';
    }
    
    
}

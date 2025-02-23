
package Modelo;

/**
 *
 * @author Angel
 */
public class Persona {
    private int id;
    private String nif;
    private String nombre;
    private String apellidos;
    private int viaje;
    private byte [] foto;

    public Persona(String nif, String nombre, String apellidos, int viaje, byte[] foto) {
        this.nif = nif;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.viaje = viaje;
        this.foto = foto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getViaje() {
        return viaje;
    }

    public void setViaje(int viaje) {
        this.viaje = viaje;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", nif=" + nif + ", nombre=" + nombre + ", apellidos=" + apellidos + ", viaje=" + viaje + ", foto=" + foto + '}';
    }
    
}

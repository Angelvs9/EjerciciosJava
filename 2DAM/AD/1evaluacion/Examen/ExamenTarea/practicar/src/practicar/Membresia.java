
package practicar;


public class Membresia {
    private String tipo;
    private String duracion;
    private double precio;

    public Membresia(String tipo, String duracion, double precio) {
        this.tipo = tipo;
        this.duracion = duracion;
        this.precio = precio;
    }
    
    

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Membresia{" + "tipo=" + tipo + ", duracion=" + duracion + ", precio=" + precio + '}';
    }


    
    
    
}

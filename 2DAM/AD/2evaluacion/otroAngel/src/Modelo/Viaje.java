
package Modelo;

/**
 *
 * @author Angel
 */
public class Viaje {
    
    private int id;
    private String origen;
    private String destino;
    private Tren tren;

    public Viaje(String origen, String destino, Tren tren) {
        this.origen = origen;
        this.destino = destino;
        this.tren = tren;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Tren getTren() {
        return tren;
    }

    public void setTren(Tren tren) {
        this.tren = tren;
    }

    @Override
    public String toString() {
        return "Viaje{" + "id=" + id + ", origen=" + origen + ", destino=" + destino + ", tren=" + tren + '}';
    }
    
    
    
    
}


package Modelo;

import java.io.Serializable;

/**
 *
 * @author Angel
 */
public class Tren implements Serializable{
    
    private String modelo;
    private int id;
    private double potencia;
    private boolean electrico;
    private int nasientos;

    public Tren(String modelo, int id, double potencia, boolean electrico, int nasientos) {
        this.modelo = modelo;
        this.id = id;
        this.potencia = potencia;
        this.electrico = electrico;
        this.nasientos = nasientos;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPotencia() {
        return potencia;
    }

    public void setPotencia(double potencia) {
        this.potencia = potencia;
    }

    public boolean isElectrico() {
        return electrico;
    }

    public void setElectrico(boolean electrico) {
        this.electrico = electrico;
    }

    public int getNasientos() {
        return nasientos;
    }

    public void setNasientos(int nasientos) {
        this.nasientos = nasientos;
    }

    @Override
    public String toString() {
        return "Tren{" + "modelo=" + modelo + ", id=" + id + ", potencia=" + potencia + ", electrico=" + electrico + ", nasientos=" + nasientos + '}';
    }
    
    
    
    
}


package Modelo;

import java.io.Serializable;

/**
 *
 * @author Angel
 */
public abstract class Vehiculo implements Serializable{
    private String color;
    private int puertas;
    private String bastidor;
    private float peso;

    public Vehiculo(String color, int puertas, String bastidor, float peso) {
        this.color = color;
        this.puertas = puertas;
        this.bastidor = bastidor;
        this.peso = peso;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPuertas() {
        return puertas;
    }

    public void setPuertas(int puertas) {
        this.puertas = puertas;
    }

    public String getBastidor() {
        return bastidor;
    }

    public void setBastidor(String bastidor) {
        this.bastidor = bastidor;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "color=" + color + ", puertas=" + puertas + ", bastidor=" + bastidor + ", peso=" + peso + '}';
    }
    
    
    
}

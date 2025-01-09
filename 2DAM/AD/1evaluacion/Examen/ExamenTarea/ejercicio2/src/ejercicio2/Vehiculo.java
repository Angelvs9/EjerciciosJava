
package ejercicio2;

import java.io.Serializable;

public class Vehiculo implements Serializable{
    private String color;
    private int npuertas;
    private String nbastidor;
    private double peso;

    public Vehiculo(String color, int npuertas, String nbastidor, double peso) {
        this.color = color;
        this.npuertas = npuertas;
        this.nbastidor = nbastidor;
        this.peso = peso;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNpuertas() {
        return npuertas;
    }

    public void setNpuertas(int npuertas) {
        this.npuertas = npuertas;
    }

    public String getNbastidor() {
        return nbastidor;
    }

    public void setNbastidor(String nbastidor) {
        this.nbastidor = nbastidor;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "_____________________________________________\nVehiculo{" + "color=" + color + ", npuertas=" + npuertas + ", nbastidor=" + nbastidor + ", peso=" + peso + '}';
    }
    
    
    
}

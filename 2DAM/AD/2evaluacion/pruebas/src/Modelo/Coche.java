/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;

/**
 *
 * @author Angel
 */
public class Coche implements Serializable{
    private static int ruedas;
    private String color;
    private String matricula;

    public Coche(String color,String m) {
        this.color = color;
        matricula=m;
    }

    public static int getRuedas() {
        return ruedas;
    }

    public static void setRuedas(int ruedas) {
        Coche.ruedas = ruedas;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    
    
    @Override
    public String toString() {
        return "Coche{" +"matricula"+matricula+ "color=" + color +"ruedas: "+ruedas+ '}';
    }
    
    
}

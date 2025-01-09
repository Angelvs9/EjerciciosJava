/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonogil;

import java.io.Serializable;

/**
 *
 * @author Angel
 */
public class Resultado implements Serializable{
    
    private int id;
    private String linea;

    public Resultado(int id, String linea) {
        this.id = id;
        this.linea = linea;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    @Override
    public String toString() {
        return "Resultado{" + "id=" + id + ", linea=" + linea + '}';
    }
    
    
            
            
    
}


package Modelo;

import java.io.Serializable;

/**
 * @author Usuario
 */
public class Nutriente implements Serializable{
    
    private int proteinas;
    private int grasas;
    private int azucares;
    private int hidratos;

    public Nutriente(int proteinas, int grasas, int azucares, int hidratos) {
        this.proteinas = proteinas;
        this.grasas = grasas;
        this.azucares = azucares;
        this.hidratos = hidratos;
    }

    public int getProteinas() {
        return proteinas;
    }

    public void setProteinas(int proteinas) {
        this.proteinas = proteinas;
    }

    public int getGrasas() {
        return grasas;
    }

    public void setGrasas(int grasas) {
        this.grasas = grasas;
    }

    public int getAzucares() {
        return azucares;
    }

    public void setAzucares(int azucares) {
        this.azucares = azucares;
    }

    public int getHidratos() {
        return hidratos;
    }

    public void setHidratos(int hidratos) {
        this.hidratos = hidratos;
    }

    @Override
    public String toString() {
        return "Nutriente{" + "proteinas=" + proteinas + ", grasas=" + grasas + ", azucares=" + azucares + ", hidratos=" + hidratos + '}';
    }
    
    
    
    
}

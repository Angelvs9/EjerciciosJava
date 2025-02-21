
package Modelo;

/**
 *
 * @author Usuario
 */
public class Maquina_producto {
    
    private int nmaquina;
    private int nproducto;
    private int ncantidad;

    public Maquina_producto(int nmaquina, int nprodcuto, int ncantidad) {
        this.nmaquina = nmaquina;
        this.nproducto = nprodcuto;
        this.ncantidad = ncantidad;
    }

    public int getNmaquina() {
        return nmaquina;
    }

    public void setNmaquina(int nmaquina) {
        this.nmaquina = nmaquina;
    }

    public int getNproducto() {
        return nproducto;
    }

    public void setNproducto(int nproducto) {
        this.nproducto = nproducto;
    }



    public int getNcantidad() {
        return ncantidad;
    }

    public void setNcantidad(int ncantidad) {
        this.ncantidad = ncantidad;
    }

    @Override
    public String toString() {
        return "Maquina_producto{" + "nmaquina=" + nmaquina + ", nprodcuto=" + nproducto + ", ncantidad=" + ncantidad + '}';
    }
    
    
    
}

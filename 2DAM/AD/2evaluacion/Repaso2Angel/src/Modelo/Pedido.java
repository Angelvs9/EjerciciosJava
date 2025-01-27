
package Modelo;

import java.sql.Date;

/**
 *
 * @author Angel
 */
public class Pedido {
    private int cliente;
    private String fecha;
    private int cantidad;

    public Pedido(int cliente, String fecha, int cantidad) {
        this.cliente = cliente;
        this.fecha = fecha;
        this.cantidad = cantidad;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    
    
    
}


package ej16angel;

import java.io.Serializable;

public class Productos implements Serializable {
    private int id;
    private String nombre;
    private String descripcion;
    private double precio_coste;
    private double precio_venta;
    private int descuento;
    private String proveedor;

    public Productos(int id, String nombre, String descripcion, double precio_coste, double precio_venta, int descuento, String proveedor) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio_coste = precio_coste;
        this.precio_venta = precio_venta;
        this.descuento = descuento;
        this.proveedor = proveedor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio_coste() {
        return precio_coste;
    }

    public void setPrecio_coste(double precio_coste) {
        this.precio_coste = precio_coste;
    }

    public double getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(double precio_venta) {
        this.precio_venta = precio_venta;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }
    public String getPrecio_ventaS(){
        String temp=Double.toString(precio_venta);
        temp=temp.replace('.', ',');
        return temp;
  
    }
     public String getPrecio_costeS(){
        String temp=Double.toString(precio_coste);
        temp=temp.replace('.', ',');
        return temp;
  
    }
    @Override
    public String toString() {
        return id + ";"+ nombre + ";" + descripcion + ";" + getPrecio_costeS() + ";" + getPrecio_ventaS() + ";" + descuento + ";" + proveedor;
    }
}

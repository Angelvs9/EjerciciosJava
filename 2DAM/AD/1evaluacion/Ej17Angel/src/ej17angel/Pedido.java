package ej17angel;



import java.util.List;



public class Pedido {

    private int id_pedido;
    private int id_cliente;
    private List<Producto> productos;

    public Pedido(int id_pedido, int id_cliente, List<Producto> productos) {
        this.id_pedido = id_pedido;
        this.id_cliente = id_cliente;
        this.productos = productos;
    }

    public int getId_pedido() {
        return id_pedido;
    }


    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public int getId_cliente() {
        return id_cliente;
    }


    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return id_pedido + ";" + id_cliente+";";
    }

    

    

    

    

    

}

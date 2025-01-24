
package actividad2angelpsp;

/**
 *
 * @author Angel
 */
import java.util.ArrayList;
import java.util.List;

class CuentaCompartida {
    private static double saldo; 
    private List<Thread> colaFIFO = new ArrayList<>(); 

    public CuentaCompartida(double saldoInicial) {
        this.saldo = saldoInicial; 
    }

 
    public synchronized void ingresar(double cantidad,int id) {
        saldo += cantidad;
        System.out.println("Propietario: "+id+" Ingresados:" + String.format("%.2f", cantidad) + "€. Saldo actual: " + String.format("%.2f", saldo) + "€");
        notifyAll();
    }

    
    public synchronized void sacar(double cantidad,int id) {
        //agrego hil en la cola
        colaFIFO.add(Thread.currentThread());

        while (colaFIFO.get(0) != Thread.currentThread() || saldo - cantidad < 0) {
            try {
                wait(); //o no hay dinero sufifiente o no es el turno de ese hilo aun
            } catch (InterruptedException e) {
                System.out.println("Hilo interrumpido mientras esperaba para sacar dinro");
                Thread.currentThread().interrupt();
                break;
            }
        }
        //si llega aqui es que hay slado suficiente 
        saldo -= cantidad;
        System.out.println("Propietario: "+id+" Retirados " + String.format("%.2f", cantidad) + "€. Saldo actual: " + String.format("%.2f", saldo) + "€");
        // Eliminar el hilo actual de la cola FIFO
        colaFIFO.remove(0);
        notifyAll();
    }
}
    


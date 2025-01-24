
package actividad2angelpsp;

import javax.realtime.NoHeapRealtimeThread;

/**
 *
 * @author Angel
 */

class Propietario extends NoHeapRealtimeThread{ 
    private CuentaCompartida cuenta;
    private int id;

    public Propietario(CuentaCompartida cuenta, int id) {
        this.cuenta = cuenta;
        this.id = id;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                double Ingreso = Math.random() * 100; 
                cuenta.ingresar(Ingreso,id);
                
                double Retirada = Math.random() * 100; 
                cuenta.sacar(Retirada,id);
                
                
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                System.out.println("Propietario " + id + " interrumpido.");
                //restauro el estado
                Thread.currentThread().interrupt();
            }
        }
    }
}

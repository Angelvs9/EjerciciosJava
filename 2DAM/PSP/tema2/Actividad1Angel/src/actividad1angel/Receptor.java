
package actividad1angel;

public class Receptor implements Runnable{
    private Puerto puerto;

    public Receptor(Puerto puerto) {
        this.puerto = puerto;
    }


    public void run() {
        while (true) {
                Object mensaje = puerto.Receive();
                System.out.println("Mensaje recibido Recibido: " + mensaje);
        } 
    }
}




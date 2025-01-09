
package actividad1angel;

public class Emisor implements Runnable {
    private Puerto puerto;

    public Emisor(Puerto puerto) {
        this.puerto = puerto;
    }

    public void run() {
        for (int i = 0; i < 8; i++) {
            try {
                puerto.Send("Mensaje numero: " + i);
                Thread.sleep(500); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
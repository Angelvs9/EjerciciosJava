
package actividad2angel;

import java.util.Random;
import javax.realtime.NoHeapRealtimeThread;
import javax.realtime.RealtimeThread;

/**
 *
 * @author Angel
 */
public class SensorTemperatura extends NoHeapRealtimeThread{
    
    private final String nombre;
    private final long intervalo;
    private final Random random; 

    public SensorTemperatura(String nombre, long intervalo) {
        this.nombre = nombre;
        this.intervalo = intervalo;
        this.random = new Random(); 
    }

    public void run() {
        try {
            while (true) {
                
                double temperatura = 20 + (random.nextDouble() * 20);
                System.out.println(nombre + " - Temperatura actual: " + temperatura + "°C");

                
                if (temperatura > 30) {
                    System.out.println("¡ALERTA! " + nombre + " ha superado los 30°C: " + temperatura + "°C");
                }

                // Dormir 
                RealtimeThread.sleep(intervalo);
            }
        } catch (InterruptedException e) {
            System.out.println(nombre + " detenido.");
        }
    }
    
    
}

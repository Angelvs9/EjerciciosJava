
package actividad1angel;

import java.util.ArrayList;
import java.util.List;


public class Puerto {

    private List<Object> buzon = new ArrayList<>();//arraylist donde se guardan los mensajes
    

    public synchronized void Send(Object mensaje){
        buzon.add(mensaje);
        notifyAll();
    
    }

    public synchronized Object Receive() {
        //solo puede usarlo un hilo al mismo tiempo
        Object msg = null;
        try {
            while (buzon.isEmpty()) {
                wait(); // Esperar hasta que haya un mensaje en el buffer
            }
            msg = buzon.remove(0);// lo guarda antes de eliminarlo
        } 
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        return msg; 
    }
    
    
    
//otra version que tambien funciona pero usa break para salir del bucle
//     public synchronized Object Receive() {
//         Object msg = null;

//         try {
//             while (true) {
//                 if (!buffer.isEmpty()) {
//                     msg = buffer.remove(0); // Si no está vacío, elimina y asigna el mensaje a msg
//                     break; 
//                 } else {
//                     wait(); // Esperar hasta que haya un mensaje en el buffer
//                 }
//             }
//         } catch (InterruptedException e) {
//             e.printStackTrace(); // Captura y muestra cualquier interrupción que ocurra durante la espera
//         }

//         return msg; // Devolver el mensaje, aunque normalmente no debería llegar aquí
//     }
// 
    
    
    
    
    
}
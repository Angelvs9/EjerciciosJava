
package actividad1angel;

public class Actividad1Angel{

    public static void main(String[] args) {
       Puerto puerto = new Puerto();
        Emisor emisor = new Emisor(puerto);
        Receptor receptor = new Receptor(puerto);

        Thread emisorHilo = new Thread(emisor);
        Thread receptorHilo = new Thread(receptor);

        emisorHilo.start();
        receptorHilo.start();
    }


    
}

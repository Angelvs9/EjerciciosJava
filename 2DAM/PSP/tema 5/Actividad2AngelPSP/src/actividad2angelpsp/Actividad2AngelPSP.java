
package actividad2angelpsp;

/**
 *
 * @author Angel
 */
public class Actividad2AngelPSP {


    public static void main(String[] args) {
        
        CuentaCompartida cuenta = new CuentaCompartida(0.0); 

        
        for (int i = 1; i <= 15; i++) {
            Propietario propietario = new Propietario(cuenta, i);
            propietario.start();
        }
    }
    
}

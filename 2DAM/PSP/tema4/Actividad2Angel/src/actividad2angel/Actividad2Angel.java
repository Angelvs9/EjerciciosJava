/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad2angel;

/**
 *
 * @author Angel
 */
public class Actividad2Angel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SensorTemperatura sensor1 = new SensorTemperatura("Sensor 1", 2000); // 2 segundos
        SensorTemperatura sensor2 = new SensorTemperatura("Sensor 2", 3000); // 3 segundos
        SensorTemperatura sensor3 = new SensorTemperatura("Sensor 3", 5000); // 5 segundos

        sensor1.start();
        sensor2.start();
        sensor3.start();
    }
    
}

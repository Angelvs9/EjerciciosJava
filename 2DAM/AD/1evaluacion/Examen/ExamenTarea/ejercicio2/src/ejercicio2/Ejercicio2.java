
package ejercicio2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Ejercicio2 {

    Object [] ListaVehiculos =new Object [4];
    private int contador=0;
    
    public void insertarVehiculo(Vehiculo v){
        boolean apuntado=false;
        for (int i = 0; i < ListaVehiculos.length; i++) {
            if(ListaVehiculos[i]==null && !apuntado){
                ListaVehiculos[i]=v;
                apuntado=true;
            }
            
        }
         insertarVehiculoArchivo();
    }
    
    
    private void insertarVehiculoArchivo(){
        File f=new File("Vehiculos.txt");
        try {
            ObjectOutputStream salida=new ObjectOutputStream(new FileOutputStream(f));
            for (int i = 0; i < ListaVehiculos.length; i++) {
                if(ListaVehiculos[i]!=null){
                    salida.writeObject(ListaVehiculos[i]);
                }
            }
            salida.writeObject(null);
            salida.close();
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio2.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    
    private boolean vectorLleno(){
        boolean b=true;
        for (int i = 0; i < ListaVehiculos.length; i++) {
            if(ListaVehiculos[i]==null){
                b=false;
            }
        }
        return b;
    }
    
    
    public static String leerListado(String archivo){
        String listado="";
        try {
            ObjectInputStream entrada=new ObjectInputStream(new FileInputStream(archivo));
            Object v1;
            while((v1=entrada.readObject())!=null){
                listado+=v1.toString(); 
            }
                    
                    
                    
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ejercicio2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Ejercicio2.class.getName()).log(Level.SEVERE, null, ex);
        }
             
        return listado;
    }
    
    public static void main(String[] args) {
        Ejercicio2 gestor=new Ejercicio2();
        Vehiculo seatIbiza = new Coche("Seat", "Ibiza", "1234ABC", "Rojo", 5, "ABCD1234", 1200.5);
        Vehiculo hondaCivic = new Coche("Honda", "Civic", "5678XYZ", "Azul", 4, "EFGH5678", 1300.0);
        
        Vehiculo bici1 = new Bicicleta("BICI001", true, 100.0, "Negro", 0, "IJKL9101", 15.0);
        Vehiculo bici2 = new Bicicleta("BICI002", false, 80.0, "Verde", 0, "MNOP1112", 12.5);

        gestor.insertarVehiculo(seatIbiza);
        gestor.insertarVehiculo(hondaCivic);
        gestor.insertarVehiculo(bici1);
        gestor.insertarVehiculo(bici2);
        

        
        String listado=leerListado("Vehiculos.txt");
        System.out.println(listado);
        
        
        
    }
    
}

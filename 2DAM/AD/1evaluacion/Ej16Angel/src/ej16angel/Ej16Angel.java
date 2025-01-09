
package ej16angel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Ej16Angel {

    ArrayList<Productos> productos = new ArrayList<>();


    private static void exportar_a_CSV(File f){
      
        File file=new File("productos.csv");
        try {  
            ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(f));
            /*escribo en el archivocsv no en el que paso como parametro*/
            FileWriter fw=new FileWriter(file);
            fw.write("id;nombre;descripcion;precio_coste;precio_venta;descuento;proveedor\n");
            Productos obj;
            while((obj=(Productos)entrada.readObject()) != null) {
                fw.write(obj.toString()+"\n");
                /*se ponen lo ; porque están en el toString()*/
            }
            fw.close();
            entrada.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ej16Angel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ej16Angel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Ej16Angel.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        
    
    }

    
    private void escribirArchivo(String nombre){
        File f=new File(nombre);
        try {
            ObjectOutputStream salida=new ObjectOutputStream(new FileOutputStream(f));
            /*aquí lo serializo sin los ;*/
            for (int i = 0; i < productos.size(); i++) {
                salida.writeObject(productos.get(i));
            }
            /*se añade para que se sepa cual es el final*/
            salida.writeObject(null);
            salida.close();
            /*llamo al método*/
            exportar_a_CSV(f);
            
        } catch (IOException ex) {
            Logger.getLogger(Ej16Angel.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    

    public static void main(String[] args) {
        
        Ej16Angel ej = new Ej16Angel(); 

        ej.productos.add(new Productos(1, "Tornillo", "tornillos 12mm", 2.0, 5.0, 1, "Sandalietes"));
        ej.productos.add(new Productos(2, "Arandela", "Arandela 12mm", 1.2, 5.8, 0, "SuperMark"));
        ej.productos.add(new Productos(3, "Rosca", "rosca 5mm", 2.0, 5.0, 1, "Sandalietes"));
        ej.productos.add(new Productos(4, "Rosca", "rosca 12mm", 3.0, 5.6, 1, "Sandalietes"));
        ej.productos.add(new Productos(5, "Bridas", "Dridas negras", 7.0, 10.0, 2, "Sandalietes"));
        ej.productos.add(new Productos(6, "Secador", "Secador Taurus", 15.0, 10.0, 1, "MediaSec"));
        ej.productos.add(new Productos(7, "Mastil", "Mastil 3m", 20.0, 25.2, 1, "Sandalietes"));
        ej.productos.add(new Productos(8, "Mastil", "Mastil 6m", 25.0, 30.0, 1, "Sandalietes"));
        ej.productos.add(new Productos(9, "Antena", "Yagui 24e", 45.0, 56.0, 3, "Sandalietes"));
        ej.productos.add(new Productos(10, "Cable", "RG59", 2.5, 4.5, 1, "Sandalietes"));

        
        System.out.println("Creando archivos.....");
        ej.escribirArchivo("productos.dat");
    }
    
}

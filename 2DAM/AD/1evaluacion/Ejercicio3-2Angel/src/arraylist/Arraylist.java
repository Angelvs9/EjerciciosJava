package arraylist;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Arraylist {
    
    public static void crearArchivo(ArrayList<String> l,String nombre){
        File f=new File(nombre+".txt");
        try {
            FileWriter fw=new FileWriter(f);
            for (int i = 0; i < l.size(); i++) {
                fw.write(l.get(i)); //es como poner vector[i]
                if (i < l.size() - 1) {//lo que hace esto es comprobar si no ha llegado al final que añada el *
                    fw.write('*');
                }
                
            }
            fw.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Arraylist.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    

    
    public static void main(String[] args) {
       ArrayList<String> lista = new ArrayList<String>();
       lista.add("buenas");
       lista.add("tardes");
       lista.add("soy");
       lista.add("pepe");
       lista.add("lopez");
       String nombre="lista";
       
       crearArchivo(lista,nombre);
        
    }
    
}

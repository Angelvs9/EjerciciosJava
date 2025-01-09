
package ej3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.FileReader;


public class Ej3 {


    public static void mostrarContenido(File f){
        try{
            FileReader fr = new FileReader(f);
            int charleido = fr.read();
            while(charleido!= -1) {//-1 porque representa el final
                char caracter = (char) charleido;
                if(caracter!=' '){
                    System.out.print(caracter);
                    
                }
                charleido = fr.read();//pasa al siguiente caracter aunque no se haya leido
            }
            
        }catch(IOException ex){}
    
    }
    
    
    public static void main(String[] args) {
        File f=new File("Ej3Angel.txt");
        FileWriter fw=null;
        try {
            
            fw = new FileWriter(f);
            PrintWriter pwr = new PrintWriter(fw);
            pwr.println("esto es una prueba para el ejercicio 3 de acceso a datos");
            
            
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(Ej3.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        mostrarContenido(f);
    }
    
}


package ej2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Ej2 {
        
    
    public static int sumarNumeros(String n){
        File archivo=new File(n);
        int resultado=0;
        int numero=0;
        FileReader fr;
        try {
            BufferedReader br = new BufferedReader(new FileReader(n));
            String linea;
            while((linea = br.readLine()) != null && !linea.equals("") && !linea.isEmpty()){
                numero = Integer.parseInt(linea);
                resultado+= numero;
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Ej2.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultado;
    }
    
    

    public static void main(String[] args) {
        String nombreArchivo="";
        int suma=0;
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("nombre del archivo: ");
            nombreArchivo = br.readLine();
            
            suma=sumarNumeros(nombreArchivo);
            System.out.println("el resutlado es: "+suma);
        }
        catch(IOException i){
            
        }
        
        
    }
    
}

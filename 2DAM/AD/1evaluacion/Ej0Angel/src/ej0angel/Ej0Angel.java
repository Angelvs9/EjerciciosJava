
package ej0angel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ej0Angel {

    public static void main(String[] args) {
        String texto="";
        String resultado="";
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("escribe:");
            
            while(texto!=null){
                texto = br.readLine();
                resultado=resultado+texto+"\n";
                
                if(texto.equals(""))
                    texto=null;
            }
            
            System.out.println("Has escrito:\n"+resultado);
        }
        catch(IOException i){
            
        }
        
         
    }
    
}


package ejer1angel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;




public class Ejer1Angel {

    
    public static void escribirnumeros(String nombre,int min,int max){
    
        File f=new File(nombre);
        try{
            String numeros="";
            for (int i = min; i < max; i++) {
                numeros+= i+ "\n";
            }
            FileWriter fw = new FileWriter(f);
            PrintWriter pwr = new PrintWriter(fw); 
            pwr.println(numeros);
            pwr.close();
            fw.close();
        }
        
        catch(IOException e){
        }
        f=null;
        

    }

    public static void main(String[] args) {
       escribirnumeros("numNaturales.txt",1,101);
      
    
    }
}


package ej1.angel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;


public class Ej12Angel {

    
    
    public static void addNumeros(String archivo){
        int numero=0;
        Scanner sc=new Scanner(System.in);
        
        while(numero<=0){
            System.out.println("Introduce un numero positivo: ");
            numero=sc.nextInt();
        }
        try{
            String resultado="";
            int n=0;
            File f=new File(archivo);
            FileWriter fw = new FileWriter(f,true);//el true es para añadir sin sobreescribir
            PrintWriter pwr = new PrintWriter(fw);
            Random rnd=new Random();
            for (int i = 0; i < numero; i++) {
                n=rnd.nextInt(100)+1;
                resultado+=n+"\n";
            }
            System.out.println(resultado);
            pwr.print(resultado);
            fw.close();
            pwr.close();
            resultado="";
        }
        catch(IOException e){}
        
    }

    public static void main(String[] args) {
      addNumeros("numeros.txt");  
    }
}

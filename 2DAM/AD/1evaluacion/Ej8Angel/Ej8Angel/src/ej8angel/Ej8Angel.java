
package ej8angel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Ej8Angel {

    private static String [] preguntas;
    private static String [] preguntasAleatorias;
            
    private static int numeroPreguntasFichero(File f){
        int numeroPreguntasFichero=0;
        try{
            FileReader fr=new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            numeroPreguntasFichero= Integer.parseInt(br.readLine());
        }
        catch(IOException e){
            
        }
        return numeroPreguntasFichero;
    }
    
    
    public static String [] metodo(String nombre,int numeroPreguntas){
        File f=new File(nombre);
        try {
            FileReader fr=new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            int numeroPreguntasF=numeroPreguntasFichero(f);//el primer numero del fichero
            if(numeroPreguntas<=numeroPreguntasF){
                preguntas=new String [numeroPreguntas];
                for (int i = 0; i < preguntas.length; i++) {
                    preguntas[i]=br.readLine();//relleno el vector de el numero que quieras
                }
                preguntasAleatorias=new String [preguntas.length];
                int contador=0;
                while (contador!=numeroPreguntas) {
                    int nAleatorio=(int) (Math.random() * preguntas.length);
                    if(preguntas[nAleatorio]!=null){
                        preguntasAleatorias[contador]=preguntas[nAleatorio];
                        preguntas[nAleatorio]=null;
                        contador++;
                        // para que no se repita y no salga la ultima letra
                    }
                }

                
            }
           fr.close();
           br.close(); 
        } 
        catch (FileNotFoundException ex) {
            Logger.getLogger(Ej8Angel.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch(IOException e){}
        
        

        
        return preguntasAleatorias;
    }
    
    
    

    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       File f=new File("preguntas.txt");
       System.out.println("Introduce el numero de preguntas que quieras: ");
       int numero=sc.nextInt();
       sc.nextLine();
       metodo("preguntas.txt",numero);
       char opcion;
       if(numeroPreguntasFichero(f)>=numero){
        for (int i = 0; i < numero; i++) {
            System.out.print(preguntasAleatorias[i].substring(0, preguntasAleatorias[i].length() - 1)+": ");
            opcion=sc.nextLine().charAt(0);
            String ultimaLetra = preguntasAleatorias[i].substring(preguntasAleatorias[i].length() - 1);
            if(opcion==ultimaLetra.charAt(0)){
                System.out.println("correcto");
            }else{
                System.out.println("incorrecto");
            }
        }
           
       }
       else{
           System.out.println("no hay tantas preguntas ");
       }
    }

    
}

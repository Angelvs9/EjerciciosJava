
package bonogil;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Bonogil implements Serializable{

/*Ejercicio 1*/
    private static int ContarLineas(String nombreArchivo){
        File f=new File(nombreArchivo);
        int numero=0;
        try {
            BufferedReader br=new BufferedReader(new FileReader(f));
            String linea;
            while((linea=br.readLine())!=null){
                numero++;
            }
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Bonogil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Bonogil.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return numero;
    }
    /*Ejercicio 2*/
    private static int VecesAparece(String nombre,int numeroBuscar){
        int nApariciones=0;
        File f=new File(nombre);
        try {
            BufferedReader br=new BufferedReader(new FileReader(f));
            String linea;
            while((linea=br.readLine())!=null){
                String [] lineaSeparada=linea.split(" ");
                //creo aqui el vector y así a la siguiente iteración lo vuelve a crear
                //osea me deshago de lo anterior
                for (int i = 0; i < lineaSeparada.length; i++) {
                    
                    if (Integer.parseInt(lineaSeparada[i])==numeroBuscar) {
                        nApariciones++;
                    }
                    
                }
               
            }
             br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Bonogil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Bonogil.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return nApariciones;
    }
    /*Ejercicio 3*/
    private static boolean algunGanador(String nombre,int [] bono){
        boolean ganador=false;
        int aciertos=0;
        File f = new File(nombre);
        try {
            BufferedReader br=new BufferedReader(new FileReader(f));
            String linea;
            while((linea=br.readLine())!=null){
                String [] lineaSeparada=linea.split(" ");
                for (int i = 0; i < lineaSeparada.length; i++) {
                    for (int j = 0; j < lineaSeparada.length; j++) {
                        if (Integer.parseInt(lineaSeparada[i])==bono[j]) {
                            aciertos++;
                        }
                        if (aciertos==6) {
                            ganador=true;
                        }
                    }
                    
                }
                
            
            }
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Bonogil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Bonogil.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return ganador;
    }
    /*Ejercicio 4*/
    private static int numeroAcertados(String nombre, int [] bono,int numeroVeces){
        int numero=0;
        int aparece=0;
        File f = new File(nombre);
        try {
            BufferedReader br=new BufferedReader(new FileReader(f));
            String linea;
            while((linea=br.readLine())!=null){
                String [] lineaSeparada=linea.split(" ");
                for (int i = 0; i < lineaSeparada.length; i++) {
                    for (int j = 0; j < lineaSeparada.length; j++) {
                        if (bono[j]==Integer.parseInt(lineaSeparada[i])) {
                            aparece++;
                        }
                    }   
                }
                if (aparece==numeroVeces) {
                    numero++;    
                }
                aparece=0;
            
            }
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Bonogil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Bonogil.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return numero;
    
    }
    private static void convertirDat(String nombreSinExtension){
        int contadorId=0;
        File f=new File(nombreSinExtension+".txt");
        File file =new File(nombreSinExtension+".dat");
        try {
            ObjectOutputStream salida=new ObjectOutputStream(new FileOutputStream(file));
            BufferedReader br=new BufferedReader(new FileReader(f));
            Object o;
            while((o=br.readLine())!=null){
                salida.writeObject(new Resultado(contadorId,o.toString()));
                contadorId++;
            }
            salida.writeObject(null);
            salida.close();
            br.close();
            
        } catch (FileNotFoundException ex) {
        Logger.getLogger(Bonogil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Bonogil.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    private static String leerDat(String nombreDat){
        File file=new File(nombreDat);
        String todo="";
        try {
            ObjectInputStream entrada=new ObjectInputStream(new FileInputStream(file));
            Object o;
            while((o=entrada.readObject())!=null){
                todo+=o.toString()+"\n";
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Bonogil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Bonogil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Bonogil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return todo;
    }
    
    
    
    
    public static void main(String[] args) {
        String nombreSinExtension="juegos";
        System.out.println(ContarLineas(nombreSinExtension+".txt"));
        int [] bono={9,40,33,28,22,21};
        System.out.println(VecesAparece(nombreSinExtension+".txt", 11));
        System.out.println(algunGanador(nombreSinExtension+".txt", bono));
        System.out.println(numeroAcertados(nombreSinExtension+".txt", bono, 2));
        convertirDat(nombreSinExtension);
        System.out.println(leerDat(nombreSinExtension+".dat"));
    }
    
}

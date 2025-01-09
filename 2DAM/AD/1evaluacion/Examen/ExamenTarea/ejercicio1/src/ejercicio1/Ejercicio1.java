
package ejercicio1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ejercicio1 {
    
    List <String> lineas=new ArrayList<String>();

    public void guardarlineas(String archivo){
    
        File f=new File(archivo+".txt");
        
        try {
            BufferedReader br=new BufferedReader(new FileReader(f));
            String linea;
            while((linea=br.readLine())!=null){
                if (!linea.isEmpty()) {
                    lineas.add(linea);
                }
            }
            
            br.close();
        } catch (FileNotFoundException ex) {
            System.out.println("no se llama así o no existe el archivo");
            Logger.getLogger(Ejercicio1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio1.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    
    public static void ordenarLineas(List<String> lineas) {
        int z = 1;
        boolean cambio = true;
        char primeraLetra1;
        char primeraLetra2;

        while (z < lineas.size() && cambio) {
            cambio = false;

            for (int j = 0; j < lineas.size() - z; j++) {
                // consigo primera letra de una linea y de su siguiente
                primeraLetra1 = Character.toLowerCase(lineas.get(j).charAt(0));
                primeraLetra2 = Character.toLowerCase(lineas.get(j + 1).charAt(0));

                if (primeraLetra1 > primeraLetra2) {
                    // Intercambia elementos
                    String temp = lineas.get(j);
                    lineas.set(j, lineas.get(j + 1));
                    lineas.set(j + 1, temp);

                    cambio = true;
                }
            }

            z++;
        }
    }

    public void crearNuevoArchivo(String nombre){
        File f=new File(nombre+".txt");
        try {
            FileWriter fw=new FileWriter(f);
            for (int i = 0; i < lineas.size(); i++) {
                fw.write(lineas.get(i)+"\n");
            }
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio1.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.println("nombre del archivo que quieres ordenar:(sin extensión)");
        String temp=sc.nextLine();
 
        Ejercicio1 ej1=new Ejercicio1();
        ej1.guardarlineas(temp);
        ej1.ordenarLineas(ej1.lineas);
        ej1.crearNuevoArchivo(temp+"OrdenadoAlfabeticamente");
    }
    
}

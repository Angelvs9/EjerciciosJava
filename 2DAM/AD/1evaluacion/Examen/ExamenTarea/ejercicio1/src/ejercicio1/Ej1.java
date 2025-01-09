/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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


public class Ej1 {

    
    public static List<String> guardarLineas(String nombreArchivo){
        File f=new File(nombreArchivo+".txt");
        List <String> lineas=new ArrayList<String>();
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
            System.out.println("el archivo no se llama asi o no existe\n");
            Logger.getLogger(Ej1.class.getName()).log(Level.SEVERE, null, ex);
            
        } catch (IOException ex) {
            Logger.getLogger(Ej1.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return lineas;
    }
    
    public static void ordenarVector(List<String> lineas){
	int z=1;
	boolean cambio=true;
	int aux;
        char primerCaracterlinea1;
        char primerCaracterlinea2;
            while(z<lineas.size() && cambio){
		cambio=false;
		for(int j=0;j<lineas.size()-z;j++){
                    primerCaracterlinea1=Character.toLowerCase(lineas.get(j).charAt(0));
                    primerCaracterlinea2=Character.toLowerCase(lineas.get(j+1).charAt(0));
                        if (primerCaracterlinea1> primerCaracterlinea2)
                        {
                            String temp = lineas.get(j);
                            lineas.set(j, lineas.get(j + 1));
                            lineas.set(j + 1, temp);
                            cambio=true;
			}
		}
			z++;
            }

    }
    
    public static void nuevoArchivoOrdenado(String archivo,List<String> lineasOrdenadas){
        File f=new File(archivo+"OrdenadoAlfabeticamente.txt");
        try {
            FileWriter fw=new FileWriter(f);
            for (int i = 0; i < lineasOrdenadas.size(); i++) {
                fw.write(lineasOrdenadas.get(i)+"\n");
            }
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(Ej1.class.getName()).log(Level.SEVERE, null, ex);
        } 
    
    }
    
    
    
    public static void main(String[] args) {
        String temp="";
        Scanner sc=new Scanner(System.in);
        System.out.println("como se llama el archivo que quieres ordenar:(sin extensión)");
        temp=sc.nextLine();
        sc.close();
        List <String> lineas=guardarLineas(temp);
        ordenarVector(lineas);
        nuevoArchivoOrdenado(temp,lineas);
    }
    
    
    
}
    
  

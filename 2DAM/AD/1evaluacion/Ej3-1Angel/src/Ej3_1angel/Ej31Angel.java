package Ej3_1angel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ej31Angel {

    
    public static int costeEnvio(String archivo){
        FileReader fr =null;
        int coste=0;
        try{
       
            fr=new FileReader(archivo);
            BufferedReader br= new BufferedReader(fr);
            int carac;
            while((carac=br.read())!=-1){
                if(carac<=90 && carac>=65 || carac>=97 && carac<=122)
                    coste=coste+2;
                else if(carac<=57 && carac>=48)
                    coste=coste+3;
                
                else if(carac==' ' || carac=='\n' || carac=='\r'){
                    coste=coste+5;
                }
                else{
                    coste=coste+5;
                }   
                    
            }
        
        
        }catch(IOException e){}
        
        return coste;
    }
    

    public static void main(String[] args) {
        System.out.println(costeEnvio("hola.txt"));
        
        
        
        
    }
    
}

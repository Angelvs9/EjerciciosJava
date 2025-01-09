
package ej4entregableangel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Ej4EntregableAngel {

    public static boolean existeProducto(int codigo){
        boolean booleano=false;
        boolean salir=false;
        String resultado="";
        try{   
            FileReader fr = new FileReader("productos.txt");
            BufferedReader br=new BufferedReader(fr);
            String linea="";
            while((linea = br.readLine())!=null){
                salir=false;
                for (int i = 0; i < linea.length(); i++) {
                    char c=linea.charAt(i);
                    
                    if(c=='/'){
                        salir=true;
                    }
                    else if(c!='/' && salir==false){
                        resultado+=c;
                        if(Integer.parseInt(resultado)==codigo){
                            booleano=true;
                        }
                    }

                }
                resultado="";
            }
                    
            br.close();
            fr.close();
        }
        
        catch(IOException e){}
        
        
        return booleano;
    }
    
    public static void porReabastecer(){
        File f;
        f=new File("porReabastecer.txt");
        try{
            FileReader fr = new FileReader("productos.txt");
            BufferedReader br=new BufferedReader(fr);
            FileWriter fw=new FileWriter(f);
            PrintWriter pwr=new PrintWriter(fw);
            String linea="";
            String resultado="";
            String r="";
            boolean salir=false;

            while((linea = br.readLine())!=null){
                r="";
                resultado="";
                salir=false;
                //aqui si realmente hay 86 obtengo 68
                for (int i = linea.length()-1; i >= 0; i--){
                    char c=linea.charAt(i);
                    if(c=='/'){
                        salir=true;
                    }
                    
                    if(salir==false && c!='/'){
                       resultado+=c;
                    }
                    
                }
                //le doy la vuelta porque lo leo del revés paso de 68 a 86 que es lo correcto
                for (int i = resultado.length()-1; i >= 0; i--) {
                    r+=resultado.charAt(i)+"";
                }
                if(Integer.parseInt(r)<=10){
                    pwr.println(linea);
                    
                }
                
                
            }
            
            pwr.close();
            br.close();
            fr.close();
        }
        catch(IOException e){}
    
    }
    
    

    public static void main(String[] args) {
        System.out.println("el producto 2145 existe: "+existeProducto(2145));
        System.out.println("el producto 1265 existe: "+existeProducto(1265));
        System.out.println("el producto 2177 existe: "+existeProducto(2177));
        System.out.println("el producto 321 existe: "+existeProducto(321));
        System.out.println("el producto 613 existe: "+existeProducto(613));
        System.out.println("reabastecimiento...");
        porReabastecer();
        
    }
    
}

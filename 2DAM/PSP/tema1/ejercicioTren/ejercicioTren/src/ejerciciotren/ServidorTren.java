
package ejerciciotren;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class ServidorTren {
    
 
    private static int[][] TrenRelleno;
    public static final int puerto=9797;
    
    //este método va aquí
    
    private static int[][] rellenarTren(){
        int[][] tren=new int[4][4];
        for (int i = 0; i < tren.length; i++) {
            for (int j = 0; j < tren[0].length; j++) {
                tren[i][j]=0;
            }
        }
    return tren;
    } 
    
    
    public static void main(String[] args) {
        
        try{
            ServerSocket servidor=new ServerSocket(puerto);
            TrenRelleno = rellenarTren();
            while(true){
                Socket aux = servidor.accept();         
                new Thread(new ManejoHilos(aux,TrenRelleno)).start();
                
                //si cierro el aux deja de funciona y le devuelve null al cliente
            }
        }
            catch(IOException e){}
        
        
        
    }
    
}

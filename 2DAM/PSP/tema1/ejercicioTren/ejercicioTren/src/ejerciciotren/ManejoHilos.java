
package ejerciciotren;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;



public class ManejoHilos implements Runnable{

    
    Socket socket;
    int [][] Tren;

    private boolean haySitio(){
       boolean booleano=false;
       boolean b=true;
        for (int i = 0; i < Tren.length; i++) {
            for (int j = 0; j < Tren[0].length; j++) {
                if (Tren[i][j]==0 && b==true) {
                    booleano=true;
                    b=false;
                }
            }
        }
       
       //si hay un sitio por lo menos, devuelve true
       return booleano;
    }
    
    private String imprimirTren(){
        String temp="";
        for (int i = 0; i < Tren.length; i++) {
            for (int j = 0; j < Tren[0].length; j++) {
                temp+=Tren[i][j]+" ";
            }
            temp+="\n";
        }

        return temp;
        
    }
    
    
    
    public String reservarAsiento(int vagon,int asiento){
        String temp="TREN LLENO"; 
        boolean booleano=haySitio();

            if(asiento < 0 || asiento >= Tren.length || vagon < 0 || vagon >= Tren[0].length){
                temp="ASIENTO O VAGÓN INVALIDO";
                System.out.println("a verr aqui siz");
            }else{
                if(booleano==true){

                    if(Tren[vagon][asiento]==0){
                       Tren[vagon][asiento]=1;
                       temp="RESERVANDO";
                    }else{
                        temp="OCUPADO";
                    }
                }
            }


        
        return temp;
    }
    
    ManejoHilos(Socket s,int [][] vec){
        socket=s;
        Tren=vec;
    }
    
    @Override
    public void run() {
        try{
            PrintWriter mensaje=new PrintWriter(socket.getOutputStream(),true);

            mensaje.println(reservarAsiento(2,1));
            
            mensaje.println(imprimirTren());

            
            mensaje.close();
            socket.close();
            /*si cierras socket empieza a hacer cosas raras o te devuelve null o no te deja ejecutar varios a la vez*/
        }
        catch(IOException e){}
    }
    
}

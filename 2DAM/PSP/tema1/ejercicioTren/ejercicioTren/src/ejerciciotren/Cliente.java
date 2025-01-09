package ejercicioTren;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import ejerciciotren.ServidorTren;


public class Cliente {
    
    public static void main(String[] args){

        try{
            Socket s=new Socket("127.0.0.1",ServidorTren.puerto);
            InputStream entrada=s.getInputStream();
            BufferedReader lector=new BufferedReader(new InputStreamReader(entrada));
            String linea;
            while((linea= lector.readLine())!=null && !linea.isEmpty()){
                System.out.println(linea);
            }
        
            while((linea= lector.readLine())!=null && !linea.isEmpty()){
                System.out.println(linea);
            }
           
            
            lector.close();
            entrada.close();
            s.close();
        }
        catch(UnknownHostException u){}
        catch (IOException ioex) {}
    }
}
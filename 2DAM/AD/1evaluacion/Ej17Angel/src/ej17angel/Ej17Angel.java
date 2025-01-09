
package ej17angel;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Ej17Angel {


    public static void main(String[] args) {

        File f=new File("MongoDB.json");
        File file=new File("MongoDB.csv");
        try{

            BufferedReader br=new BufferedReader(new FileReader(f));
            String linea="";
            String json="";
            while((linea=br.readLine())!=null){

                json+=linea;

            }
            Gson gson=new Gson();
            Pedido[] pedidos = gson.fromJson(json, Pedido[].class);
            BufferedWriter bw=new BufferedWriter(new FileWriter(file));
            bw.write("id_pedido;id_cliente;id_producto;nombre;fabricante;cantidad\n");
            for (int i = 0; i < pedidos.length; i++) {

                for (int j = 0; j < pedidos[i].getProductos().size(); j++) {

                    bw.write(pedidos[i]+""+pedidos[i].getProductos().get(j)+"\n");

                }

            }

            br.close();
            bw.close();

        } 

        catch (FileNotFoundException ex) {
            Logger.getLogger(Ej17Angel.class.getName()).log(Level.SEVERE, null, ex);

        } catch (IOException ex) {
            Logger.getLogger(Ej17Angel.class.getName()).log(Level.SEVERE, null, ex);

        } 

    }

}

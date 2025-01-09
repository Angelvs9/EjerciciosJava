
package EjercicioBiblioteca;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Reserva implements Serializable{

    private Usuario usr;
    private int idLibro;
    private static List <Reserva> reservas=new ArrayList<Reserva>();
    
    public Reserva(Usuario usr, int idLibro) {
        this.usr = usr;
        this.idLibro = idLibro;
    }

    public boolean equals(Reserva r){
        boolean booleano=false;
        if(this.getIdLibro()==r.getIdLibro() && this.usr.equals(r))
            booleano=true;
        
        return booleano;
    }
    
    
    public Usuario getUsr() {
        return usr;
    }

    public void setUsr(Usuario usr) {
        this.usr = usr;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }
    
    
    private static void ActualizarArchivo(){
        File f=new File("reservas.dat");
        try {
            ObjectOutputStream salida=new ObjectOutputStream(new FileOutputStream(f));
            for (int i = 0; i < reservas.size(); i++) {
                if(reservas.get(i)!=null){
                    salida.writeObject(reservas.get(i));
                }
            }
            salida.writeObject(null);
            salida.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Reserva.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Reserva.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }
    
    public boolean anyadir(Usuario usr,int idLibro){
        boolean booleano=true;
        Reserva r=new Reserva(usr,idLibro);

        for (int i = 0; i < reservas.size(); i++) {
            if(reservas.get(i)!=null && reservas.get(i).equals(r))
                booleano=false;
        }
        if (booleano==true) {
            reservas.add(r);
            //solo la añade si no esta repetida
            ActualizarArchivo();
        }
        
        return booleano;
    }

    public String servirLibro(int idLibro){
        String temp=null;
        boolean booleano=false;
        for (int i = 0; i < reservas.size(); i++) {
            if(reservas.get(i)!=null && reservas.get(i).getIdLibro()==idLibro && !booleano){
                temp=reservas.get(i).getUsr().toString();
                reservas.remove(i);
                booleano=true;
                i--;
            }
        }
        if (booleano) {
            ActualizarArchivo();
            //si el booleano es true es que algo a quitado y ha devuleto algo
            //con lo cual hay que volver a apuntar la lista 
        }
        return temp;
    }
    public int anularReservas(Usuario usr){
        int contador=0;
        for (int i = 0; i < reservas.size(); i++) {
            if(reservas.get(i)!=null && reservas.get(i).getUsr().equals(usr)){
                reservas.remove(i);
                contador++;
            }
            
        }
        if (contador>=1) {
            ActualizarArchivo();
            //si el contador es mayor a uno o uno es que algo a eliminado 
            //con lo cual hay que volver a apuntar la lista 
        }
        return contador;
    }
    
    public String usuarioMasReservas(){
        String usuarioMasReservas=null;
        int contador=0;
        int contadorMaximo=0;
        for (int i = 0; i < reservas.size(); i++) {
            contador=0;
            Usuario usrActual=reservas.get(i).getUsr();
            for (int j = 0; j < reservas.size(); j++) {
                if (usrActual.equals(reservas.get(j).getUsr())) {
                    contador++;
                }
            }
            if(contador>contadorMaximo){
                contadorMaximo=contador;
                usuarioMasReservas=usrActual.toString();
            }
        }
        
        
        return usuarioMasReservas;
    }
    public String imprimirArchivoReservas(){
        File f=new File("reservas.dat");
        String temp=null;
        if(f.exists()){   
            Object r;
            try {
              ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(f));
              while((r=entrada.readObject())!=null){
                  temp+=r.toString()+"\n";
              }
              entrada.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Reserva.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Reserva.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Reserva.class.getName()).log(Level.SEVERE, null, ex);
            }

        
        }
        return temp;
    }
    
    
    
    @Override
    public String toString() {
        return "Reserva{" + "usr=" + usr.toString() + ", idLibro=" + idLibro + '}';
    }
    
    
    
    
    
}

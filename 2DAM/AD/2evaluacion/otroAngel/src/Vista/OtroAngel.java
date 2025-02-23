/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import BBDD.Metodos;
import static BBDD.Metodos.crearPersona;
import static BBDD.Metodos.crearViaje;
import static BBDD.Metodos.desSerializar;
import BBDD.gestorConexion;
import Modelo.Persona;
import Modelo.Tren;
import Modelo.Viaje;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Angel
 */
public class OtroAngel {

    public static byte[] fileBytes(Connection conexion,String foto){
        File f=new File(foto);
        byte [] vector=new byte[(int)f.length()];
        try {
            FileInputStream fis=new FileInputStream(f);
            fis.read(vector);
            fis.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OtroAngel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(OtroAngel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return vector;        
    }
    

    
    
    public static void main(String[] args) {
        gestorConexion conexion=new gestorConexion();
        conexion.use("renfe");
        
        Tren tren1=new Tren("modelo1",1,100,true,250);
        Tren tren2=new Tren("modelo5",2,200,false,150);
        Tren tren3=new Tren("mo19",3,50,true,50);
        
        //creo viaje
        Viaje v1=new Viaje("origen","destino",tren1);
        Viaje v2=new Viaje("ro","re",tren2);
        Viaje v3=new Viaje("fa","fe",tren3);
        
        
        int codigoViaje1=crearViaje(conexion.getConexion(),v1);
        int codigoViaje2=crearViaje(conexion.getConexion(),v2);
        int codigoViaje3=crearViaje(conexion.getConexion(),v3);
        ///////////////////////////////////////////////////////////////
        
        
        byte [] pep=fileBytes(conexion.getConexion(),"pep.jpg");
        byte [] jusep=fileBytes(conexion.getConexion(),"jusep.jpg");
        byte [] fabri=fileBytes(conexion.getConexion(),"fabri.jpg");
        
        //creo personas
        Persona p1=new Persona("245178548K", "pep", "pep", codigoViaje1, pep);
        Persona p2=new Persona("845178548L", "jusep", "jusep", codigoViaje2, jusep);
        Persona p3=new Persona("995178111P", "fabri", "fabri", codigoViaje3, fabri);
        
        int codigoPersona1=crearPersona(conexion.getConexion(),p1);
        int codigoPersona2=crearPersona(conexion.getConexion(),p2);
        int codigoPersona3=crearPersona(conexion.getConexion(),p3);
        
        
        
        System.out.println(desSerializar(conexion.getConexion(), codigoViaje3));
        
        conexion.cerrar();
    }
    
}

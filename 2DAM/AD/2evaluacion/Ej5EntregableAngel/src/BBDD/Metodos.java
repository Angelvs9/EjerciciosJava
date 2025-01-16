/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BBDD;

import Vista.Ej5EntregableAngel;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Angel
 */
public class Metodos {
    
    public static boolean crearBaseDatos(Connection gestor,String bd){
        boolean temp=false;
        String linea="";
        String consulta="";
        File f=new File(bd);
        try {
            BufferedReader br=new BufferedReader(new FileReader(f));
            Statement sta=gestor.createStatement();
            while((linea=br.readLine())!=null){
                if (linea.isEmpty() && linea.startsWith("--")) {
                    consulta+=linea;
                    if (consulta.endsWith(";")) {
                        sta.execute(consulta);
                        if (temp) {
                        //se ejecuta solo una vez el use 
                            use(gestor);
                            temp=false;
                        }
                        consulta="";
                    }
                }
                
            }
            br.close();
            sta.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ej5EntregableAngel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ej5EntregableAngel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return temp;
    }
    
    
    public static void use(Connection gestor){
        try {
            Statement stmt=gestor.createStatement();
            String use="USE vehiculos";
            stmt.execute(use);
            stmt.close();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
}

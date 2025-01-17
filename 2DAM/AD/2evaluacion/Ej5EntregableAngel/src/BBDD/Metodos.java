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
import java.sql.ResultSet;
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
        if (!ExisteBD(gestor, bd)) {
            String linea="";
            String consulta="";
            File f=new File(bd);
            try {
                BufferedReader br=new BufferedReader(new FileReader(f));
                Statement sta=gestor.createStatement();
                while((linea=br.readLine())!=null){
                    if (!linea.isEmpty() && !linea.startsWith("--")) {
                        consulta+=linea;
                        if (consulta.endsWith(";")) {
                            sta.execute(consulta);
                            consulta="";
                            temp=true;
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
        }//cierre if
        
        
        return temp;
    }
    
    private static boolean ExisteBD(Connection gestor,String nombre){
        boolean existe=false;
        try {
            Statement sta=gestor.createStatement();
            gestor.createStatement(); 
            String consulta = "SELECT COUNT(*) AS total FROM information_schema.schemata WHERE schema_name = '" + nombre + "'";
            ResultSet rs=sta.executeQuery(consulta);
            if (rs.next()) {
                //si hay mas de 0 bd con ese nombre ya existe
                if(rs.getInt("total")>0){
                    existe=true;
                    System.out.println("a ver ");
                }
            }
            rs.close();
            sta.close();
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("no funciona de momento "+existe);
        return existe;
    }
    
    
    public static boolean traspasoDatos(Connection bdPostgres,Connection bdMySql){
        boolean traspaso=false;
        
        
        
        
        return traspaso;
    }
    
    
}

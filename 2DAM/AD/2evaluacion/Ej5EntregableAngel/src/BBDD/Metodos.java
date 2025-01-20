/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BBDD;

import Modelo.Dato_fiscal;
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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Angel
 */
public class Metodos {
    
    public static boolean crearBaseDatos(Connection gestor,String bd){
        boolean temp=false;
        if (!ExisteBD(gestor, "audiogil")) {
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

            String consulta = "SELECT COUNT(*) AS total FROM information_schema.schemata WHERE schema_name = '" + nombre + "'";
            ResultSet rs=sta.executeQuery(consulta);
            if (rs.next()) {
                //si hay mas de 0 bd con ese nombre ya existe
                if(rs.getInt("total")>0){
                    existe=true;

                }
            }
            rs.close();
            sta.close();
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }

        return existe;
    }
    
    public static void use(Connection gestor,String nombrebd){
        try {
            Statement stmt=gestor.createStatement();
            String use="USE "+nombrebd+";";
            stmt.execute(use);
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
    public static boolean traspasoADatosFiscales(Connection bdPostgres,Connection bdMySql){
        boolean traspaso=false;
        //la postgres es la del 127 y la mysql lo de siempre
        
        //a la bd vieja de postgres
        String consulta1="select nif,nombre,apellidos,cp,cc from clientes";
        try {
            Statement staPostgres=bdPostgres.createStatement();
            Statement staMySql=bdMySql.createStatement();
            
            //lista para guardar datos fiscales nuevos
            List<Dato_fiscal> datosFiscalesList = new ArrayList<>();
            //uso la de postgres(vieja)
            
            
            ResultSet rs=staPostgres.executeQuery(consulta1);
            while (rs.next()) {
                String nif = rs.getString("nif");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                int cp = rs.getInt("cp");
                long cc = rs.getLong("cc");
                
                Dato_fiscal datoFiscal = new Dato_fiscal(nif, nombre, apellidos, cp, cc); 
                datosFiscalesList.add(datoFiscal);
            }
            //uso la mysql nueva
            
            for (Dato_fiscal df : datosFiscalesList) {
                String consultaInsertarDatosfiscales = "INSERT INTO datos_fiscales (nif, nombre, apellidos, cp, cc) VALUES ('" + df.getNif() + "', '" + df.getNombre() + "', '" + df.getApellidos() + "', '" + df.getCp() + "', " + df.getCa() + ")";
                staMySql.executeUpdate(consultaInsertarDatosfiscales);
                traspaso=true;
            }
            staPostgres.close();
            staMySql.close();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return traspaso;
    }
    
    
}

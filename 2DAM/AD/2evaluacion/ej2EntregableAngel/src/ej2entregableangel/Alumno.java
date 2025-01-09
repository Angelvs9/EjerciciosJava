
package ej2entregableangel;

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

public class Alumno extends Datos_fiscales{
    private int codigo;
    //tabla alumnos
    private int id_persona;//en la bd es autonumerica es la relación
    private int curso;
    private String carrera;
    private double nota_media;



    public Alumno(int codigo, int id_persona, int curso, String carrera, double nota_media, String nombre, String apellidos, String nif, int edad, int poblacion) {
        super(nombre, apellidos, nif, edad, poblacion);
        this.codigo = codigo;
        this.id_persona = id_persona;
        this.curso = curso;
        this.carrera = carrera;
        this.nota_media = nota_media;
    }

    public Alumno(int codigo, int curso, String carrera, double nota_media, String nombre, String apellidos, String nif, int edad, int poblacion) {
        super(nombre, apellidos, nif, edad, poblacion);
        this.codigo = codigo;
        this.curso = curso;
        this.carrera = carrera;
        this.nota_media = nota_media;
    }
    

    
    public static int getUltimoCodigo(Connection conexion){
        int codigo=0;
        String consultaSelect="select MAX(codigo) from Alumnos";
        ResultSet rs;
        try {
            Statement sta=conexion.createStatement();
            rs=sta.executeQuery(consultaSelect);
            if(rs.next())
                codigo=rs.getInt(1);//coge primera columna

            rs.close();
            sta.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Alumno.class.getName()).log(Level.SEVERE, null, ex);
        }
        //si devuelve 0 es que no hay ningun alumno y devuelve null la consulta
        //no devuelvo el siguiente, la suma la hago fuera
        return codigo;
    }

    
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    //importante
    public int getId_persona() {
        return id_persona;
    }


    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public double getNota_media() {
        return nota_media;
    }

    public void setNota_media(double nota_media) {
        this.nota_media = nota_media;
    }

    @Override
    public String toString() {
        return super.toString()+"Alumno{" + "codigo=" + codigo + ", id_persona=" + id_persona + ", curso=" + curso + ", carrera=" + carrera + ", nota_media=" + nota_media + '}';
    }


    
    
    
}


package ej2entregableangel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Administracion extends Datos_fiscales{
    

    private int codigo;//no autonumerico
    private int id_persona; //relacion autonumerica con datos_fiscales
    private int anyos_trabajados;
    private String departamento;
    private char horario;

    public Administracion(int codigo, int id_persona, int anyos_trabajados, String departamento, char horario, String nombre, String apellidos, String nif, int edad, int poblacion) {
        super(nombre, apellidos, nif, edad, poblacion);
        this.codigo = codigo;
        this.id_persona = id_persona;
        this.anyos_trabajados = anyos_trabajados;
        this.departamento = departamento;
        this.horario = horario;
    }

    public Administracion(int codigo, int anyos_trabajados, String departamento, char horario, String nombre, String apellidos, String nif, int edad, int poblacion) {
        super(nombre, apellidos, nif, edad, poblacion);
        this.codigo = codigo;
        this.anyos_trabajados = anyos_trabajados;
        this.departamento = departamento;
        this.horario = horario;
    }
    
    
    public int getCodigo() {
        return codigo;
    }

    
    public static int getUltimoCodigo(Connection conexion){
        int codigo=0;
        String consultaSelect="select MAX(codigo) from Administracion";
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

    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }

    public int getAnyos_trabajados() {
        return anyos_trabajados;
    }

    public void setAnyos_trabajados(int anyos_trabajados) {
        this.anyos_trabajados = anyos_trabajados;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public char getHorario() {
        return horario;
    }

    public void setHorario(char horario) {
        this.horario = horario;
    }

    @Override
    public String toString() {
        return "Administracion{" + "codigo=" + codigo + ", id_persona=" + id_persona + ", anyos_trabajados=" + anyos_trabajados + ", departamento=" + departamento + ", horario=" + horario + '}';
    }
    
    
    
}

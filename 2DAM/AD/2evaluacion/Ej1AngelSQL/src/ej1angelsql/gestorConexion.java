
package ej1angelsql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class gestorConexion {
    
    Connection conn1 = null;
    //String bd = "jdbc:mysql://localhost:3306/notasevaluaciones";
    
    public gestorConexion(String urlBd) {
        //el link entero se lo paso al constructor osea urlBd
        try {
            String user="root";
            String password="";
            conn1=DriverManager.getConnection(urlBd,user,password);
            if (conn1!=null) {
                System.out.println("todo bien conectado a notasevaluaciones");
            }
        } catch (SQLException ex) {
            Logger.getLogger(gestorConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//fin constructor
    
    public void Insert(Alumno a){
        try {
            //INSERT INTO `alumnos` (`id`, `nombre`, `apellidos`, `edad`, `curso`, `NIF`) VALUES (NULL, 'asdasd', 'asdas', '11', '11', '24584714F');
            Statement sta=conn1.createStatement();
            //en caso de que no pongas id a mano es autonumerico
            String consulta="";
            consulta="INSERT INTO `alumnos` (`id`, `nombre`, `apellidos`, `edad`, `curso`, `NIF`) VALUES (NULL, '"+a.getNombre()+"', '"+a.getApellidos()+"', "+a.getEdad()+", "+a.getCurso()+", '"+a.getNIF()+"')";
            if (a.getId()>0) {
                //si hay un id que has puesto a mano
                consulta="INSERT INTO `alumnos` (`id`, `nombre`, `apellidos`, `edad`, `curso`, `NIF`) VALUES ("+a.getId()+", '"+a.getNombre()+"', '"+a.getApellidos()+"', "+a.getEdad()+", "+a.getCurso()+", '"+a.getNIF()+"')";
            }
            sta.executeUpdate(consulta);
            sta.close();
        } catch (SQLException ex) {
            System.out.println("Error en el insert alumno");
            Logger.getLogger(gestorConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void Delete(Alumno a){
        try {
            Statement sta=conn1.createStatement();
            String consultaQuitarAlumno = "DELETE FROM `alumnos` WHERE `id` = " + a.getId();
            //String consultaSelect="SELECT * FROM evaluacion WHERE alumnoNif like"+"'"+a.getNIF()+"'";
            String consultaSelect="SELECT * FROM evaluacion";
            //prefiero pillar todas las filas y luego mirar cual es la que quiero borrar "manualmente"
            ResultSet rs = sta.executeQuery(consultaSelect);
            while(rs.next()){
                //pillo todos los nif y cuando es igual al del objeto que le has pasado lo quita
                String nifs = rs.getString("alumnoNif");
                String borrar = "DELETE FROM `evaluacion` WHERE `alumnoNif` = " + a.getNIF();
                sta.executeUpdate(borrar);
            }
            
            sta.executeUpdate(consultaQuitarAlumno);
            sta.close();
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Error al eliminar");
            Logger.getLogger(gestorConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void Update(int id, String nombre, String apellidos, int edad, int curso, String NIF){
        try {
            //tengo en cuenta el nif para cambiarlo porque es UNIQUE
            Statement sta=conn1.createStatement();
            String consulta = "UPDATE `alumnos` SET `nombre` = '" + nombre + "', `apellidos` = '" + apellidos + "', `edad` = " + edad + ", `curso` = " + curso + ", `id` = '" + id + "' WHERE `nif` = " + NIF;
            sta.executeUpdate(consulta); 
            sta.close();
        } catch (SQLException ex) {
            System.out.println("no se ha podido actualizar");
            Logger.getLogger(gestorConexion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void Insert(Evaluacion e){
        try {
            //INSERT INTO `alumnos` (`id`, `nombre`, `apellidos`, `edad`, `curso`, `NIF`) VALUES (NULL, 'asdasd', 'asdas', '11', '11', '24584714F');
            Statement sta=conn1.createStatement();
            //en caso de que no pongas id a mano es autonumerico
            String consulta="";
            consulta="INSERT INTO `evaluacion` (`id`, `evaluacion`, `nota`, `alumnoNif`) VALUES (NULL, '"+e.getEvaluacion()+"', "+e.getNota()+", '"+e.getAlumnoNif()+"')";
            if (e.getId()>0) {
                //si hay un id que has puesto a mano
                consulta="INSERT INTO `evaluacion` (`id`, `evaluacion`, `nota`, `alumnoNif`) VALUES ("+e.getId()+", '"+e.getEvaluacion()+"', '"+e.getNota()+"', '"+e.getAlumnoNif()+"')";
            }
            System.out.println(consulta);
            sta.executeUpdate(consulta);
            sta.close();
        } catch (SQLException ex) {
            System.out.println("Error en el insert de fila en la tabla evaluacion");
            Logger.getLogger(gestorConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public void cerrar_Conexion(){
        try {
            conn1.close();
        } catch (SQLException ex) {
            System.out.println("no se puede cerrar la conexión");
            Logger.getLogger(gestorConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    
    
}

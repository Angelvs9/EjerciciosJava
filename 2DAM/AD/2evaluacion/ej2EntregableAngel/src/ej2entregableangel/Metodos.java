
package ej2entregableangel;

import static ej2entregableangel.Alumno.getUltimoCodigo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Angel
 */
public class Metodos {
    
    public static boolean altaAlumno(gestorConexion gestor, Alumno a){
        boolean insertado=false;
        boolean existeDatos_fiscales=false;
        boolean existeAlumno=false;
        int codigoSumadoAlumno=getUltimoCodigo(gestor.getConexion())+1;
        int idRecuperado=0;
        String verificarExiste="select id from datos_fiscales where nif='"+a.getNif()+"';";
        Statement sta;
        //verificar si existe en datos fiscales antes de hacer nada 
        //si no esta en datos fiscales seguro que no esta en alumnos porque la id_persona es obligatoria
        try {
            sta = gestor.getConexion().createStatement();
            ResultSet resultset = sta.executeQuery(verificarExiste);
            if (resultset.next() &&  resultset.getInt(1) > 0) {
                existeDatos_fiscales=true;
                idRecuperado = resultset.getInt("id");
            }
            resultset.close();
            sta.close(); 
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        String consultaInsertFiscales="INSERT INTO datos_fiscales (nombre, apellidos, nif, edad, poblacion) VALUES (" + "'" + a.getNombre() + "', '" + a.getApellidos() + "', '" + a.getNif() + "', " + a.getEdad() + ", " + a.getPoblacion() + ");";
        String consultaId="Select id from datos_fiscales where nif='"+a.getNif()+"';";
        
            try {
                Statement stmt = gestor.getConexion().createStatement();
                if(!existeDatos_fiscales){
                    //si no existe la persona en los datos fiscales lo inserta
                    stmt.executeUpdate(consultaInsertFiscales);
                }
                ResultSet rs = stmt.executeQuery(consultaId);
                if (rs.next()) {
                    idRecuperado = rs.getInt("id");
                }
                String verificarExisteAlumno="SELECT COUNT(*) FROM alumnos WHERE id_persona ="+idRecuperado+";";
                ResultSet resultset = stmt.executeQuery(verificarExisteAlumno);
                if (resultset.next() && resultset.getInt(1) == 0) {
                    //si no esta repetido como alumno
                    String consultaInsert2="INSERT INTO alumnos (codigo, curso, carrera, nota_media,id_persona) VALUES (" + codigoSumadoAlumno + ", " + a.getCurso() + ", '" + a.getCarrera() + "', " + a.getNota_media() +","+idRecuperado +");";
                    stmt.executeUpdate(consultaInsert2);
                    insertado=true; 
                }            
                resultset.close();
                rs.close();
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
            }
        

        return insertado;
    }
    public static boolean bajaAlumno(gestorConexion gestor, String nif){
        boolean eliminado=false;
        boolean existe=false;
        int codigoObtenido=0;
        String consultaSacarIdDatos_fiscales="select id from datos_fiscales where nif='"+nif+"'";
        
        //si existe en datos_fiscales saco el id para irme a la tabla de alumnos a eliminarlo
        //en el codigo no deja insetar dos personas del mismo nif
        try {
            Statement stmt = gestor.getConexion().createStatement();
            ResultSet resultset = stmt.executeQuery(consultaSacarIdDatos_fiscales);
            if (resultset.next() &&  resultset.getInt(1) > 0) {
                existe=true;
                codigoObtenido = resultset.getInt("id");
            }
            resultset.close();
            stmt.close(); 
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (existe) {
            String consulta="DELETE FROM alumnos where id_persona='"+codigoObtenido+"'";
            try {
                Statement sta=gestor.getConexion().createStatement();
                if (existe) {
                    sta.executeUpdate(consulta);
                    eliminado=true;
                }
                sta.close();
            } catch (SQLException ex) {
                Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return eliminado;
    }
    
        public static boolean bajaAdministrador(gestorConexion gestor, String nif){
        boolean eliminado=false;
        boolean existe=false;
        int codigoObtenido=0;
        String consultaSacarIdDatos_fiscales="select id from datos_fiscales where nif='"+nif+"'";
        
        //si existe en datos_fiscales saco el id para irme a la tabla de alumnos a eliminarlo
        //en el codigo no deja insetar dos personas del mismo nif
        try {
            Statement stmt = gestor.getConexion().createStatement();
            ResultSet resultset = stmt.executeQuery(consultaSacarIdDatos_fiscales);
            if (resultset.next() &&  resultset.getInt(1) > 0) {
                existe=true;
                codigoObtenido = resultset.getInt("id");
            }
            resultset.close();
            stmt.close(); 
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (existe) {
            String consulta="DELETE FROM administracion where id_persona='"+codigoObtenido+"'";
            try {
                Statement sta=gestor.getConexion().createStatement();
                if (existe) {
                    sta.executeUpdate(consulta);
                    eliminado=true;
                }
                sta.close();
            } catch (SQLException ex) {
                Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return eliminado;
    }
    
    
    
    
    public static boolean modificarAlumno(gestorConexion gestor, Alumno a){
        boolean modificado=false;
        boolean existe=false;
        int codigoObtenido=0;
        String consultaSacarIdDatos_fiscales="select id from datos_fiscales where nif='"+a.getNif()+"'";
        try {
            Statement stmt=gestor.getConexion().createStatement();
            ResultSet resultset = stmt.executeQuery(consultaSacarIdDatos_fiscales);
            if (resultset.next() &&  resultset.getInt(1) > 0) {
                codigoObtenido = resultset.getInt("id");
                existe=true;
            }
            if (existe) {
                String consultaupdate = "UPDATE alumnos SET curso='" + a.getCurso() + "', carrera='" + a.getCarrera() + "', nota_media=" + a.getNota_media()+ " WHERE id_persona = "+codigoObtenido;
                stmt.executeUpdate(consultaupdate);
                modificado=true;
            }
            resultset.close();
            stmt.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        
        }

        return modificado;
    }
    
    public static boolean modificarAdministracion(gestorConexion gestor, Administracion a) {
    boolean modificado = false;
    boolean existe = false;
    int codigoObtenido = 0;
    String consultaSacarIdDatosFiscales = "SELECT id FROM datos_fiscales WHERE nif='" + a.getNif() + "';";
    
    try {
        Statement stmt = gestor.getConexion().createStatement();
        ResultSet resultset = stmt.executeQuery(consultaSacarIdDatosFiscales);
        if (resultset.next() && resultset.getInt(1) > 0) {
            codigoObtenido = resultset.getInt("id");
            existe = true;
        }
        if (existe) {
            String consultaUpdate = "UPDATE administracion SET anyos_trabajados='" + a.getAnyos_trabajados() + "', departamento='" + a.getDepartamento() + "', horario='" + a.getHorario() + "' WHERE id_persona = " + codigoObtenido;
            stmt.executeUpdate(consultaUpdate);
            modificado = true;
        }
        resultset.close();
        stmt.close();
        
    } catch (SQLException ex) {
        Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
    }

    return modificado;
}

    
    
    public static ArrayList<String> consultarAlumno(gestorConexion gestor,String nif){
        String consulta="SELECT a.*,d.*,p.* FROM alumnos a LEFT JOIN datos_fiscales d ON a.id_persona = d.id LEFT JOIN poblaciones p ON d.poblacion = p.codigo WHERE d.nif = '"+nif+"';";
        ArrayList<String> alumnoInfo = new ArrayList<>();
        Statement stmt;
        try {
            stmt = gestor.getConexion().createStatement();
            ResultSet resultset = stmt.executeQuery(consulta);
            if (resultset.next() &&  resultset.getInt(1) > 0) {
                alumnoInfo.add("CodigoAlumno: " + resultset.getInt("codigo")); 
                alumnoInfo.add("IDPersona: " + resultset.getInt("id_persona")); 
                alumnoInfo.add("Curso: " + resultset.getInt("curso")); 
                alumnoInfo.add("Carrera: " + resultset.getString("carrera")); 
                alumnoInfo.add("NotaMedia: " + resultset.getBigDecimal("nota_media")); 
                alumnoInfo.add("Nombre: " + resultset.getString("nombre")); 
                alumnoInfo.add("Apellidos: " + resultset.getString("apellidos")); 
                alumnoInfo.add("NIF: " + resultset.getString("nif")); 
                alumnoInfo.add("Edad: " + resultset.getInt("edad")); 
                alumnoInfo.add("NombrePoblacion: " + resultset.getString("nombre")); 
                alumnoInfo.add("CodigoPostal: " + resultset.getString("cod_postal"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        return alumnoInfo;
    }
    public static ArrayList<String> consultarAdministracion(gestorConexion gestor, String nif) {
        String consulta = "SELECT a.*, d.*, p.* FROM administracion a LEFT JOIN datos_fiscales d ON a.id_persona = d.id LEFT JOIN poblaciones p ON d.poblacion = p.codigo WHERE d.nif = '" + nif + "';";
        ArrayList<String> adminInfo = new ArrayList<>();
        Statement stmt;
        try {
            stmt = gestor.getConexion().createStatement();
            ResultSet resultset = stmt.executeQuery(consulta);
            if (resultset.next() && resultset.getInt(1) > 0) {
                adminInfo.add("CodigoAdministracion: " + resultset.getInt("codigo"));
                adminInfo.add("IDPersona: " + resultset.getInt("id_persona"));
                adminInfo.add("AñosTrabajados: " + resultset.getInt("anyos_trabajados"));
                adminInfo.add("Departamento: " + resultset.getString("departamento"));
                adminInfo.add("Horario: " + resultset.getString("horario"));
                adminInfo.add("Nombre: " + resultset.getString("nombre"));
                adminInfo.add("Apellidos: " + resultset.getString("apellidos"));
                adminInfo.add("NIF: " + resultset.getString("nif"));
                adminInfo.add("Edad: " + resultset.getInt("edad"));
                adminInfo.add("NombrePoblacion: " + resultset.getString("p.nombre"));
                adminInfo.add("CodigoPostal: " + resultset.getString("p.cod_postal"));
            }
            resultset.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return adminInfo;
    }

    
    
    public static boolean altaAdministracion(gestorConexion gestor,Administracion a){
        
        boolean insertado=false;
        boolean existeDatos_fiscales=false;
        boolean existeAdministrador=false;
        int codigoSumadoAdmin=getUltimoCodigo(gestor.getConexion())+1;
        int idRecuperado=0;
        String verificarExiste="select id from datos_fiscales where nif='"+a.getNif()+"';";
        Statement sta;
        //verificar si existe en datos fiscales antes de hacer nada 
        //si no esta en datos fiscales seguro que no esta en administracion porque la id_persona es obligatoria
        try {
            sta = gestor.getConexion().createStatement();
            ResultSet resultset = sta.executeQuery(verificarExiste);
            if (resultset.next() &&  resultset.getInt(1) > 0) {
                existeDatos_fiscales=true;
                idRecuperado = resultset.getInt("id");
            }
            resultset.close();
            sta.close(); 
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        String consultaInsertFiscales="INSERT INTO datos_fiscales (nombre, apellidos, nif, edad, poblacion) VALUES (" + "'" + a.getNombre() + "', '" + a.getApellidos() + "', '" + a.getNif() + "', " + a.getEdad() + ", " + a.getPoblacion() + ");";
        String consultaId="Select id from datos_fiscales where nif='"+a.getNif()+"';";
        
            try {
                Statement stmt = gestor.getConexion().createStatement();
                if(!existeDatos_fiscales){
                    //si no existe la persona en los datos fiscales lo inserta
                    stmt.executeUpdate(consultaInsertFiscales);
                }
                ResultSet rs = stmt.executeQuery(consultaId);
                if (rs.next()) {
                    idRecuperado = rs.getInt("id");
                }
                String verificarExisteAdministrador="SELECT COUNT(*) FROM administracion WHERE id_persona ="+idRecuperado+";";
                ResultSet resultset = stmt.executeQuery(verificarExisteAdministrador);
                if (resultset.next() && resultset.getInt(1) == 0) {
                    
                    String consultaInsert2 = "INSERT INTO administracion (codigo, id_persona, anyos_trabajados, departamento, horario) VALUES (" + codigoSumadoAdmin + ", " + idRecuperado + ", " + a.getAnyos_trabajados() + ", '" + a.getDepartamento() + "', '" + a.getHorario() + "');";

                    stmt.executeUpdate(consultaInsert2);
                    insertado=true; 
                }            
                resultset.close();
                rs.close();
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
            }
        

        return insertado;
        
    }
    

    
    public static boolean altaPoblaciones(gestorConexion gestor,Poblacion p){
        boolean insertado=false;
        int idBueno=0;
        String sacarUltimoIdPoblacion="Select max(codigo) as maximo from poblaciones";
        String sacarCodigosPostales="select cod_postal from poblaciones";            
        try {
            Statement stmt = gestor.getConexion().createStatement();
            ResultSet resultset = stmt.executeQuery(sacarUltimoIdPoblacion);
            if (resultset.next()) {
                idBueno = resultset.getInt("maximo")+1;
            }
            resultset = stmt.executeQuery(sacarCodigosPostales);
            String temp="";
            boolean repetido=false;
            while(resultset.next()){
                temp=resultset.getString("cod_postal");
                if (temp.equals(p.getCod_postal())) {
                    repetido=true;
                }
            }
            String insertPoblacion="insert into poblaciones (codigo,nombre,cod_postal) values ("+idBueno+",'"+p.getNombre()+"',"+p.getCod_postal()+");";
            if (!repetido) {
                
                stmt.executeUpdate(insertPoblacion);
                insertado=true;
            }

            
            resultset.close();
            stmt.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return insertado;
    
    }
    
}

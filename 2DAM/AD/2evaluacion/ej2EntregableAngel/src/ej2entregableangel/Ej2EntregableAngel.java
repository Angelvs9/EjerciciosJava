
package ej2entregableangel;

import static ej2entregableangel.Alumno.getUltimoCodigo;
import static ej2entregableangel.Metodos.consultarAdministracion;
import static ej2entregableangel.Metodos.consultarAlumno;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Ej2EntregableAngel {

    
    public static String getPoblaciones(gestorConexion gest){
        String poblaciones="";
        String consulta="select codigo,nombre,cod_postal from Poblaciones";
        Statement stmt;
        try {
            stmt = gest.getConexion().createStatement(); 
            ResultSet rs = stmt.executeQuery(consulta);
            while(rs.next()){
                 int codigo = rs.getInt("codigo"); 
                String nombre = rs.getString("nombre"); 
                poblaciones += codigo + " - " + nombre + "\n";
            }
        } catch (SQLException ex) {
            Logger.getLogger(Ej2EntregableAngel.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        return poblaciones;
    }
    
    
    

    public static void main(String[] args) {
        int opcion;
        gestorConexion gestor=new gestorConexion();
        Metodos metodos=new Metodos();
        Scanner sc =new Scanner(System.in);
        System.out.println("1-alumnos");
        System.out.println("2-administracion");
        System.out.println("3-agregar poblacion");
        opcion=sc.nextInt();
        if (opcion<=1) {
            opcion=0;
            System.out.println("1-Alta alumno");
            System.out.println("2-Baja alumno");
            System.out.println("3-Modificacion alumno");
            System.out.println("4-Consultar alumno");
            opcion=sc.nextInt();
            switch(opcion){
                case 1:
                    //llamar a alta alumno
                    boolean existeFiscales=false;
                    String nombre="";
                    String apellidos="";
                    int edad=0;
                    int poblacion=0;
                    
                    int id_persona=0;
                    sc.nextLine();
                    System.out.println("Introduce el nif del alumno");
                    String nif=sc.nextLine();
                    //si ya extaban sus datos en datos_fiscales antes no se le preguntaran 
                    //si es totalemente nuevo si 
                    String consultaSacarDatos="select * from datos_fiscales where nif='"+nif+"';";
                    try {
                       Statement p = gestor.getConexion().createStatement();
                       ResultSet resultset = p.executeQuery(consultaSacarDatos);
                        if (resultset.next()) {
                            
                            nombre = resultset.getString("nombre");
                            apellidos = resultset.getString("apellidos");
                            edad = resultset.getInt("edad");
                            poblacion=resultset.getInt("poblacion");
                            id_persona=resultset.getInt("id");
                            existeFiscales=true;
                        }
                        p.close();
                        resultset.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(Ej2EntregableAngel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    
                    if (!existeFiscales) {
                        System.out.println("no estan los datos en datos_fiscales ni en alumnos");
                        //si no estan sus datos ya en datos_fiscales se lo preguntara todo porque no esta e  inguna tabla
                        System.out.println("Introduce el nombre del alumno");
                        nombre=sc.nextLine();
                        System.out.println("Introduce el apellidos del alumno");
                        apellidos=sc.nextLine();
                        System.out.println("Introduce el edad del alumno");
                        edad=sc.nextInt();
                        sc.nextLine(); 
                        System.out.println("Introduce la poblacion(codigo) de entre esta lista");
                        System.out.println(getPoblaciones(gestor));
                        poblacion=sc.nextInt();
                        
                        
                        System.out.println("introduce el curso del alumno(numero)");
                        int curso=sc.nextInt();
                        System.out.println("Introduce carrera alumno");
                        sc.nextLine();
                        String carrera=sc.nextLine();
                        System.out.println("nota media alumno");
                        double notaMedia=sc.nextDouble();
                        Alumno alumno = new Alumno(getUltimoCodigo(gestor.getConexion())+1, curso, carrera, notaMedia, nombre, apellidos, nif, edad, poblacion);
                        if(metodos.altaAlumno(gestor, alumno)){
                            System.out.println("el alumno de nif: "+ alumno.getNif()+" y nombre completo: "+alumno.getNombre() +" " +alumno.getApellidos()+" se insertó correctamente ");
                        }
                            
                            
                    }
                    else{
                        //si ya tenía antes los datos de fiscales
                        boolean existeAlumnoYa=false;
                        String comprobar="select count(*) from alumnos where id_persona="+id_persona;
                        try {
                            Statement p = gestor.getConexion().createStatement();
                            ResultSet resultset = p.executeQuery(comprobar);
                            if (resultset.next() && resultset.getInt(1) >0) {
                                existeAlumnoYa=true;
                            }
                            p.close();
                            resultset.close();
                        } catch (SQLException ex) {
                            Logger.getLogger(Ej2EntregableAngel.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        if (!existeAlumnoYa) {
                            
                            System.out.println("introduce el curso del alumno(numero)");
                            int curso=sc.nextInt();
                            System.out.println("Introduce carrera alumno");
                            sc.nextLine();
                            String carrera=sc.nextLine();
                            System.out.println("nota media alumno");
                            double notaMedia=sc.nextDouble();
                            Alumno alumno = new Alumno(getUltimoCodigo(gestor.getConexion())+1, curso, carrera, notaMedia, nombre, apellidos, nif, edad, poblacion);
                            if(metodos.altaAlumno(gestor, alumno)){
                                System.out.println("el alumno de nif: "+ alumno.getNif()+" y nombre completo: "+alumno.getNombre() +" " +alumno.getApellidos()+" se insertó correctamente ");
                            }
                        }else{
                            System.out.println("ese nif ya está y ese alumno ya existe");
                        }
  
                        
                    }
                    gestor.cerrar_Conexion();
                    break;
                case 2:
                    //llamar a baja alumno
                    sc.nextLine();
                    System.out.println("introduce el nif del alumno a eliminar: ");
                    String tempnif=sc.nextLine();
                    if(metodos.bajaAlumno(gestor, tempnif)){
                        System.out.println("el alumno de nif: "+ tempnif+" se eliminó correctamente ");
                    }
                    else{
                        System.out.println("no se puedo eliminar porque no existe");
                    }
                    gestor.cerrar_Conexion();
                    break;
                case 3:
                    //llamar a modificar alumno
                    sc.nextLine();
                    int IdObtenidoFiscales=0;
                    int viejoCurso=0;
                    double viejaMedia=0.0;
                    String viejaCarrera="";
                    
                    String nb="";
                    String ap="";
                    int ed=0;
                    String np="";
                    String cp="";
                    int p=0;
                    int codigoAlumno=0;
                    
                    boolean existeAlumno=false;
                    System.out.println("NIF del alumno a modificar");
                    String nifTemporal = sc.nextLine(); 
                    String consultaSacarIdDatosFiscales="Select id from datos_fiscales where nif='"+nifTemporal+"'";
                    
                    try {
                        Statement stmt = gestor.getConexion().createStatement();
                        ResultSet rs = stmt.executeQuery(consultaSacarIdDatosFiscales);
                        if (rs.next()) {
                            IdObtenidoFiscales=rs.getInt("id");
                            String consultaSacarDatosViejos = "SELECT a.*, d.*, p.* FROM alumnos a LEFT JOIN datos_fiscales d ON a.id_persona = d.id LEFT JOIN poblaciones p ON d.poblacion = p.codigo WHERE a.id_persona = " + IdObtenidoFiscales;
                            Statement sta = gestor.getConexion().createStatement();
                            ResultSet res=sta.executeQuery(consultaSacarDatosViejos);
                            if (res.next()) {
                                codigoAlumno = res.getInt("codigo");
                                viejoCurso = res.getInt("curso");
                                viejaCarrera = res.getString("carrera");
                                viejaMedia = res.getDouble("nota_media");
                                nb = res.getString("nombre");
                                ap = res.getString("apellidos");
                                ed = res.getInt("edad");
                                np = res.getString("nombre");
                                cp = res.getString("cod_postal");
                                p=res.getInt("codigo");
                                existeAlumno = true;
                            }
 
                            sta.close();
                            res.close();
                        }

                        stmt.close();
                        rs.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(Ej2EntregableAngel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    if(existeAlumno){
                        
                        System.out.println("Nuevo curso (presiona Enter para mantener " + viejoCurso + "):");
                        String nuevoCursoInput = sc.nextLine();
                        int nuevoCurso = viejoCurso; 
                        if (!nuevoCursoInput.isEmpty()) {
                            nuevoCurso = Integer.parseInt(nuevoCursoInput);
                        }

                        System.out.println("Nueva nota media (coma) (presiona Enter para mantener " + viejaMedia + "):");
                        String nuevaMediaInput = sc.nextLine();
                        double nuevaMedia = viejaMedia; 
                        if (!nuevaMediaInput.isEmpty()) {
                            nuevaMedia = Double.parseDouble(nuevaMediaInput);
                        }

                        System.out.println("Nueva carrera (presiona Enter para mantener " + viejaCarrera + "):");
                        String nuevaCarrera = sc.nextLine();
                        if (nuevaCarrera.isEmpty()) {
                            nuevaCarrera = viejaCarrera;
                        }

                        Alumno al=new Alumno(codigoAlumno,IdObtenidoFiscales,nuevoCurso,nuevaCarrera,nuevaMedia,nb,ap,nifTemporal,ed,p);
                        al.setNif(nifTemporal);
                        if (metodos.modificarAlumno(gestor, al)) {
                            System.out.println("modificado correctamente");
                        }
                    }else if(!existeAlumno){
                        System.out.println("no se ha podido modificar porque no existe el alumno");
                    }
                    
                    
                    gestor.cerrar_Conexion();
                    break;
                case 4:
                    //llamar a consultar alumno
                    sc.nextLine();
                    System.out.println("Introduce el nif del alumno");
                    String n=sc.nextLine();
                    ArrayList<String> alumnoInfo=consultarAlumno(gestor,n);
                    if (!alumnoInfo.isEmpty()) {
                        for (int i = 0; i < alumnoInfo.size(); i++) {
                            System.out.println(alumnoInfo.get(i));
                        }
                    } else {
                        System.out.println("No se encontró ningún alumno con ese NIF.");
                    }

                    gestor.cerrar_Conexion();
                    break;
            
            }
        }
        else if (opcion==2){
            opcion=0;
            System.out.println("1-Alta administración");
            System.out.println("2-Baja administración");
            System.out.println("3-Modificacion administración");
            System.out.println("4-Consultar administración");
            opcion=sc.nextInt();
            switch(opcion){
                case 1:
                // llamar a alta administración
                boolean existeFiscales = false;
                String nombre = "";
                String apellidos = "";
                int edad = 0;
                int poblacion = 0;

                int id_persona = 0;
                sc.nextLine();
                System.out.println("Introduce el nif del administrador");
                String nif = sc.nextLine();
                // si ya estaban sus datos en datos_fiscales antes no se le preguntarán
                // si es totalmente nuevo sí
                String consultaSacarDatos = "SELECT * FROM datos_fiscales WHERE nif='" + nif + "';";
                try {
                    Statement p = gestor.getConexion().createStatement();
                    ResultSet resultset = p.executeQuery(consultaSacarDatos);
                    if (resultset.next()) {
                        nombre = resultset.getString("nombre");
                        apellidos = resultset.getString("apellidos");
                        edad = resultset.getInt("edad");
                        poblacion = resultset.getInt("poblacion");
                        id_persona = resultset.getInt("id");
                        existeFiscales = true;
                    }
                    resultset.close();
                    p.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Ej2EntregableAngel.class.getName()).log(Level.SEVERE, null, ex);
                }

                if (!existeFiscales) {
                    System.out.println("No están los datos en datos_fiscales ni en administración.");
                    // si no están sus datos ya en datos_fiscales se lo preguntará todo porque no está en ninguna tabla
                    System.out.println("Introduce el nombre del administrador");
                    nombre = sc.nextLine();
                    System.out.println("Introduce los apellidos del administrador");
                    apellidos = sc.nextLine();
                    System.out.println("Introduce la edad del administrador");
                    edad = sc.nextInt();
                    sc.nextLine(); 
                    System.out.println("Introduce la población (código) de entre esta lista");
                    System.out.println(getPoblaciones(gestor));
                    poblacion = sc.nextInt();
                    sc.nextLine(); // Limpiar buffer

                    System.out.println("Introduce los años trabajados");
                    int anyos_trabajados = sc.nextInt();
                    sc.nextLine(); // Limpiar buffer
                    System.out.println("Introduce el departamento");
                    String departamento = sc.nextLine();
                    char horario = 'f';
                    while (horario != 'M' && horario != 'T') {
                        System.out.println("Horario (M/T)");
                        horario = sc.nextLine().charAt(0);
                    }

                    Administracion admin = new Administracion(getUltimoCodigo(gestor.getConexion()) + 1, anyos_trabajados, departamento, horario, nombre, apellidos, nif, edad, poblacion);
                    if (metodos.altaAdministracion(gestor, admin)) {
                        System.out.println("El administrador con NIF: " + admin.getNif() + " y nombre completo: " + admin.getNombre() + " " + admin.getApellidos() + " se insertó correctamente.");
                    }

                } else {
                    // si ya tenía antes los datos de fiscales
                    boolean existeAdminYa = false;
                    String comprobar = "SELECT COUNT(*) FROM administracion WHERE id_persona=" + id_persona;
                    try {
                        Statement p = gestor.getConexion().createStatement();
                        ResultSet resultset = p.executeQuery(comprobar);
                        if (resultset.next() && resultset.getInt(1) > 0) {
                            existeAdminYa = true;
                        }
                        resultset.close();
                        p.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(Ej2EntregableAngel.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    if (!existeAdminYa) {
                        System.out.println("Introduce los años trabajados");
                        int anyos_trabajados = sc.nextInt();
                        sc.nextLine(); // Limpiar buffer
                        System.out.println("Introduce el departamento");
                        String departamento = sc.nextLine();
                        char horario = 'f';
                        while (horario != 'M' && horario != 'T') {
                            System.out.println("Horario (M/T)");
                            horario = sc.nextLine().charAt(0);
                        }

                        Administracion admin = new Administracion(getUltimoCodigo(gestor.getConexion()) + 1, anyos_trabajados, departamento, horario, nombre, apellidos, nif, edad, poblacion);
                        if (metodos.altaAdministracion(gestor, admin)) {
                            System.out.println("El administrador con NIF: " + admin.getNif() + " y nombre completo: " + admin.getNombre() + " " + admin.getApellidos() + " se insertó correctamente.");
                        } else {
                            System.out.println("No se pudo insertar el administrador.");
                        }
                    } else {
                        System.out.println("Ese NIF ya está y ese administrador ya existe.");
                    }
                }

                gestor.cerrar_Conexion();
                break;
                case 2:
                    //llamar a baja administración
                    sc.nextLine();
                    System.out.println("introduce el nif del administrador a eliminar: ");
                    String tempnif=sc.nextLine();
                    if(metodos.bajaAdministrador(gestor, tempnif)){
                        System.out.println("el administrador de nif: "+ tempnif+" se eliminó correctamente ");
                    }
                    else{
                        System.out.println("no se puede eliminar porque no existe");
                    }
                    
                    gestor.cerrar_Conexion();
                    break;
                case 3:
                    //llamar a modificar administración
                    sc.nextLine();
                    int IdObtenidoFiscales = 0;
                    int viejosAnyosTrabajados = 0;
                    String viejoDepartamento = "";
                    char viejoHorario = ' ';

                    String ns = "";
                    String ape = "";
                    int edd = 0;
                    String nombrePoblacion = "";
                    String codigoPostal = "";
                    int pbl = 0;
                    int codigoAdmin = 0;

                    boolean existeAdmin = false;
                    System.out.println("NIF del administrador a modificar");
                    String nifTemporal = sc.nextLine(); 
                    String consultaSacarIdDatosFiscales = "SELECT id FROM datos_fiscales WHERE nif='" + nifTemporal + "';";

                    try {
                        Statement stmt = gestor.getConexion().createStatement();
                        ResultSet rs = stmt.executeQuery(consultaSacarIdDatosFiscales);
                        if (rs.next()) {
                            IdObtenidoFiscales = rs.getInt("id");
                            String consultaSacarDatosViejos = "SELECT a.*, d.*, p.* FROM administracion a LEFT JOIN datos_fiscales d ON a.id_persona = d.id LEFT JOIN poblaciones p ON d.poblacion = p.codigo WHERE a.id_persona = " + IdObtenidoFiscales + ";";
                            Statement sta = gestor.getConexion().createStatement();
                            ResultSet res = sta.executeQuery(consultaSacarDatosViejos);
                            if (res.next()) {
                                codigoAdmin = res.getInt("codigo");
                                viejosAnyosTrabajados = res.getInt("anyos_trabajados");
                                viejoDepartamento = res.getString("departamento");
                                viejoHorario = res.getString("horario").charAt(0);
                                ns = res.getString("nombre");
                                ape = res.getString("apellidos");
                                edd = res.getInt("edad");
                                nombrePoblacion = res.getString("nombre");
                                codigoPostal = res.getString("cod_postal");
                                pbl = res.getInt("codigo");
                                existeAdmin = true;
                            }
                            sta.close();
                            res.close();
                        }
                        stmt.close();
                        rs.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(Ej2EntregableAngel.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    if (existeAdmin) {
                        System.out.println("Nuevos años trabajados (presiona Enter para mantener " + viejosAnyosTrabajados + "):");
                        String nuevosAnyosTrabajadosInput = sc.nextLine();
                        int nuevosAnyosTrabajados = viejosAnyosTrabajados;
                        if (!nuevosAnyosTrabajadosInput.isEmpty()) {
                            nuevosAnyosTrabajados = Integer.parseInt(nuevosAnyosTrabajadosInput);
                        }

                        System.out.println("Nuevo departamento (presiona Enter para mantener " + viejoDepartamento + "):");
                        String nuevoDepartamento = sc.nextLine();
                        if (nuevoDepartamento.isEmpty()) {
                            nuevoDepartamento = viejoDepartamento;
                        }

                        System.out.println("Nuevo horario (M/T) (presiona Enter para mantener " + viejoHorario + "):");
                        String nuevoHorarioInput = sc.nextLine();
                        char nuevoHorario = viejoHorario;
                        if (!nuevoHorarioInput.isEmpty()) {
                            nuevoHorario = nuevoHorarioInput.charAt(0);
                        }

                        Administracion admin = new Administracion(codigoAdmin, IdObtenidoFiscales, nuevosAnyosTrabajados, nuevoDepartamento, nuevoHorario, ns, ape, nifTemporal, edd, pbl);
                        admin.setNif(nifTemporal);
                        if (metodos.modificarAdministracion(gestor, admin)) {
                            System.out.println("Modificado correctamente");
                        }
                    } else {
                        System.out.println("No se ha podido modificar porque no existe el administrador");
                    }
           
                    gestor.cerrar_Conexion();
                    break;
                case 4:
                    //llamar a consultar administración
                    sc.nextLine();
                    System.out.println("Introduce el NIF de la persona");
                    String n = sc.nextLine();
                    ArrayList<String> adminInfo = consultarAdministracion(gestor, n);
                    if (!adminInfo.isEmpty()) {
                        for (String info : adminInfo) {
                            System.out.println(info);
                        }
                    } else {
                        System.out.println("No se encontró ninguna persona con ese NIF en administración.");
                    }

                    gestor.cerrar_Conexion();
                    break;
            
            }
        }
        
        else if(opcion==3){
            sc.nextLine();
            System.out.println("introduce el nombre");
            String nombre=sc.nextLine();
            System.out.println("introduce el codigo postal");
            String cp=sc.nextLine();
            Poblacion poblacion=new Poblacion(nombre,cp);
            System.out.println(metodos.altaPoblaciones(gestor, poblacion));
        }
        sc.close();
    }
    
}

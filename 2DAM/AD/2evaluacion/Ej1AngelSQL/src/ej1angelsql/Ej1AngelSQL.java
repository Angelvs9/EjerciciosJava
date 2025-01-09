
package ej1angelsql;


public class Ej1AngelSQL {


    public static void main(String[] args) {
        String bd = "jdbc:mysql://localhost:3306/notasevaluaciones";
        gestorConexion gc=new gestorConexion(bd);
        
        Alumno alumno1 = new Alumno(3, "Pep", "Martinez", 20, 3, "12345678A");
        Alumno alumno2 = new Alumno(4, "Luis", "Gomez", 22, 5, "45678901D");
        Alumno alumno3 = new Alumno("Maria", "Lopez", 18, 1, "34567890C");
        Alumno alumno4 = new Alumno("Juan", "Perez", 16, 2, "14741474G");


        gc.Insert(alumno4);
        gc.Insert(alumno2);
        
        Evaluacion eval1 = new Evaluacion(1, "1", 8.5, "12345678A");
        Evaluacion eval2 = new Evaluacion(2, "2", 7.0, "14741474G");
        Evaluacion eval3 = new Evaluacion("3", 9.2, "12345678A");
        
        //pep saca 9.2 y 8.5 y juan 7
        //he creado notas para confirmar que al quitar al alumno se quita todo
        gc.Insert(eval3);
        gc.Insert(eval2);
        gc.Insert(eval1);

        //quito los de pep
//        gc.Delete(alumno1);
        
        
        gc.cerrar_Conexion();
    }
    
}

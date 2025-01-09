
package ej1angelsql;

public class Evaluacion {
    private int id;
    private String evaluacion;
    private double nota;
    private String alumnoNif;

    public Evaluacion(int id, String evaluacion, double nota, String alumnoNif) {
        this.id = id;
        this.evaluacion = evaluacion;
        this.nota = nota;
        this.alumnoNif = alumnoNif;
    }

    public Evaluacion(String evaluacion, double nota, String alumnoNif) {
        this.evaluacion = evaluacion;
        this.nota = nota;
        this.alumnoNif = alumnoNif;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(String evaluacion) {
        this.evaluacion = evaluacion;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public String getAlumnoNif() {
        return alumnoNif;
    }

    public void setAlumnoNif(String alumnoNif) {
        this.alumnoNif = alumnoNif;
    }
    
    
    
}

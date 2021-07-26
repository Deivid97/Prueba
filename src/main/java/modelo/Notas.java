
package modelo;

import java.sql.Date;


public class Notas {
    
    private String idEstudiante;
    private String idMateria;
    private String idPeriodo;
    private double nota;

    public Notas(String idEstudiante, String idMateria, String idPeriodo, double nota) {
        this.idEstudiante = idEstudiante;
        this.idMateria = idMateria;
        this.idPeriodo = idPeriodo;
        this.nota = nota;
    }



    public String getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(String idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(String idMateria) {
        this.idMateria = idMateria;
    }

    public String getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(String idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
    
    
    
    
}

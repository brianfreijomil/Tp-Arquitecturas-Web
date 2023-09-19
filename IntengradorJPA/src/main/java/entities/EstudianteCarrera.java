package entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name = "estudiante_carrera")
public class EstudianteCarrera {
    @EmbeddedId
    private EstudianteCarreraId id;
    @Column(nullable = false)
    private Timestamp inscripcion;
    @Column(nullable = false)
    private Timestamp graduacion;
    @Column
    private int antiguedad;

    public EstudianteCarrera() {
        super();
    }

    public EstudianteCarrera(EstudianteCarreraId pk, Timestamp inscripcion, Timestamp graduacion, int antiguedad) {
        super();
        this.id = pk;
        this.inscripcion = inscripcion;
        this.graduacion = graduacion;
        this.antiguedad = antiguedad;
    }

    public EstudianteCarreraId getId() {
        return id;
    }

    public Timestamp getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(Timestamp inscripcion) {
        this.inscripcion = inscripcion;
    }

    public Timestamp getGraduacion() {
        return graduacion;
    }

    public void setGraduacion(Timestamp graduacion) {
        this.graduacion = graduacion;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    @Override
    public String toString() {
        return "Carrera: "+id+", "+inscripcion+", "+graduacion+", "+antiguedad;
    }
}

package entities;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

@Entity(name = "estudiante_carrera")
public class EstudianteCarrera {
    @EmbeddedId
    private EstudianteCarreraId id;
    @Column(nullable = false)
    private Timestamp inicio_carrera;
    @Column(nullable = false)
    private boolean graduado;

    public EstudianteCarrera() {
        super();
    }

    public EstudianteCarrera(EstudianteCarreraId ecID, Timestamp inicio_carrera, boolean graduado) {
        super();
        this.id = ecID;
        this.inicio_carrera = inicio_carrera;
        this.graduado = graduado;
    }

    public Date getInicio_carrera() {
        return inicio_carrera;
    }

    public void setInicio_carrera(Timestamp inicio_carrera) {
        this.inicio_carrera = inicio_carrera;
    }

    public boolean isGraduado() {
        return graduado;
    }

    public void setGraduado(boolean graduado) {
        this.graduado = graduado;
    }
}

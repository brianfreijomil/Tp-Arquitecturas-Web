package entities;
import org.hibernate.tool.schema.extract.spi.ForeignKeyInformation;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


public class Estudiante_Carrera {
    @Column(name="inicio_carrea", nullable = false)
    private Date inicio_carrera;
    @Id
    private Carrera carrera;
    @Id
    private Estudiante estudiante;
    @Column(name="graduado", nullable = false)
    private boolean graduado;

    public Estudiante_Carrera() {
    }

    public Estudiante_Carrera(Date inicio_carrera, Carrera carrera, Estudiante estudiante, boolean graduado) {
        this.inicio_carrera = inicio_carrera;
        this.carrera = carrera;
        this.estudiante = estudiante;
        this.graduado = graduado;
    }

    public Date getInicio_carrera() {
        return inicio_carrera;
    }

    public void setInicio_carrera(Date inicio_carrera) {
        this.inicio_carrera = inicio_carrera;
    }

    public boolean isGraduado() {
        return graduado;
    }

    public void setGraduado(boolean graduado) {
        this.graduado = graduado;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }
}

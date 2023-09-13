package entities;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

@Entity(name = "estudiante_carrera")
public class EstudianteCarrera {

    /*
    * idCarrera
    * idEstudiante
    * inicioCarrera
    * graduado
    * */

    @Id
    private int id; //id de estudiante carrera se mapea con los id de carrera y estudiante
    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    private Carrera carrera; //id carrera
    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    private Estudiante estudiante; //id estudiante
    @Column(nullable = false)
    private Timestamp inicio_carrera;
    @Column(nullable = false)
    private boolean graduado;

    public EstudianteCarrera() {
        super();
    }

    public EstudianteCarrera(Timestamp inicio_carrera, Carrera carrera, Estudiante estudiante, boolean graduado) {
        super();
        this.inicio_carrera = inicio_carrera;
        this.carrera = carrera;
        this.estudiante = estudiante;
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

    public Carrera getCarrera() {
        return carrera;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }
}

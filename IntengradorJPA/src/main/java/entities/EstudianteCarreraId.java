package entities;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class EstudianteCarreraId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "carrera_id")
    private Carrera carrera;

    @ManyToOne
    @JoinColumn(name = "estudiante_id")
    private Estudiante estudiante;

    public EstudianteCarreraId(Estudiante estudiante,Carrera carrera) {
        super();
        this.estudiante=estudiante;
        this.carrera=carrera;
    }
    public EstudianteCarreraId() {
        super();
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    @Override
    public String toString() {
        return carrera.getNombre()+", "+estudiante.getDNI();
    }
}

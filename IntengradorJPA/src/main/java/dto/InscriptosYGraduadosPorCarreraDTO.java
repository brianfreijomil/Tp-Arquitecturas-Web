package dto;

import java.sql.Timestamp;
import java.util.Date;

public class InscriptosYGraduadosPorCarreraDTO {
    private String nombre_carrera;

    private Long carreraId;
    private Long count;

    private Long graduados;
    private Date inscripcion;

    public InscriptosYGraduadosPorCarreraDTO(String nombre_carrera, Long carreraId, Long count, Long graduados, Date inscripcion) {
        this.nombre_carrera = nombre_carrera;
        this.carreraId = carreraId;
        this.count = count;
        this.graduados = graduados;
        this.inscripcion = inscripcion;
    }

    public Long getGraduacion() {
        return graduados;
    }

    public void setGraduacion(Long graduacion) {
        this.graduados = graduacion;
    }

    public Date getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(Date inscripcion) {
        this.inscripcion = inscripcion;
    }

    public String getNombre_carrera() {
        return nombre_carrera;
    }

    public void setNombre_carrera(String nombre_carrera) {
        this.nombre_carrera = nombre_carrera;
    }

    public Long getCarreraId() {
        return carreraId;
    }

    public void setCarreraId(Long carreraId) {
        this.carreraId = carreraId;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}

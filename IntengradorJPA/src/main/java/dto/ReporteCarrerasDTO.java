package dto;

import java.sql.Timestamp;
import java.util.Date;

public class ReporteCarrerasDTO {
    private String carrera;
    private int anio;
    private int cant_inscriptos;
    private int cant_graduados;

    public ReporteCarrerasDTO(String carrera, int cant_inscriptos, int cant_graduados, int anio) {
        this.carrera = carrera;
        this.anio = anio;
        this.cant_inscriptos = cant_inscriptos;
        this.cant_graduados = cant_graduados;
    }

    public String getCarrera() {
        return carrera;
    }
    public int getAnio() {
        return anio;
    }
    public int getCant_inscriptos() {
        return cant_inscriptos;
    }
    public int getCant_graduados() {
        return cant_graduados;
    }

    @Override
    public String toString() {
        return "ReporteDTO => Carrera: "+this.carrera+", año: "+this.anio+", inscriptos: "+this.cant_inscriptos+", graduados: "+this.cant_graduados;
    }
}

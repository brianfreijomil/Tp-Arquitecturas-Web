package dto;

public class CarrerasConInscriptosDTO{
    private String nombreCarrera;
    private long cant_inscriptos;
    private long id_carrera;

    public CarrerasConInscriptosDTO(String nombreCarrera, long id_carrera, long cant_inscriptos) {
        this.nombreCarrera = nombreCarrera;
        this.cant_inscriptos = cant_inscriptos;
        this.id_carrera = id_carrera;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }
    public long getCantInscriptos() {
        return cant_inscriptos;
    }
    public void setCantInscriptos(int cant_inscriptos) {
        this.cant_inscriptos = cant_inscriptos;
    }
    public long getId_carrera() {
        return id_carrera;
    }
    @Override
    public String toString() {
        return "Carrera: "+this.nombreCarrera+", "+this.id_carrera+", inscriptos: "+this.cant_inscriptos;
    }
}

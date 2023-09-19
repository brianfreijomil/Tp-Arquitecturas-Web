package dto;

public class CarrerasConInscriptosDTO{
    /*recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos.*/
    private String nombreCarrera;
    private long count;

    private long id_carrera;

    public CarrerasConInscriptosDTO(String nombreCarrera, long id_carrera, long count) {
        this.nombreCarrera = nombreCarrera;
        this.count = count;
        this.id_carrera = id_carrera;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public long getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public long getId_carrera() {
        return id_carrera;
    }

    public void setId_carrera(int id_carrera) {
        this.id_carrera = id_carrera;
    }
}

package dto;

public class CarrerasConInscriptosDTO{
    private String nombreCarrera;
    private Long count;

    private int id_carrera;

    public CarrerasConInscriptosDTO(String nombreCarrera, int id_carrera, Long count) {
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

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public int getId_carrera() {
        return id_carrera;
    }

    public void setId_carrera(int id_carrera) {
        this.id_carrera = id_carrera;
    }
}

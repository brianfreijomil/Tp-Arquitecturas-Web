package dto;

public class EstudiantesPorCiudad {
    private String ciudad;
    private int id_estudiante;
    private String estudiante_nombre;
    private String estudiante_apellido;
    private String carrera;

    public EstudiantesPorCiudad(int id_estudiante, String estudiante_nombre, String estudiante_apellido, String carrera) {
        this.id_estudiante = id_estudiante;
        this.estudiante_nombre = estudiante_nombre;
        this.estudiante_apellido = estudiante_apellido;
        this.carrera = carrera;
    }

    public String getCiudad(){
        return this.ciudad;
    }

    public int getId_estudiante() {
        return id_estudiante;
    }

    public void setId_estudiante(int id_estudiante) {
        this.id_estudiante = id_estudiante;
    }

    public String getEstudiante_nombre() {
        return estudiante_nombre;
    }

    public void setEstudiante_nombre(String estudiante_nombre) {
        this.estudiante_nombre = estudiante_nombre;
    }

    public String getEstudiante_apellido() {
        return estudiante_apellido;
    }

    public void setEstudiante_apellido(String estudiante_apellido) {
        this.estudiante_apellido = estudiante_apellido;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
}

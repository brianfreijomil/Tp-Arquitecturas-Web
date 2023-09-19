package Interfaces;

import java.util.List;

public interface InterfaceRepEstudiante<Estudiante> {

    public void createEstudiante(Estudiante e);

    public void deleteEstudianteByDNI(int DNI);

    public void updateEstudiante(Estudiante e);

    public Estudiante selectEstudianteByDNI(int DNI);

    public List<Estudiante> selectAllEstudiante();
}

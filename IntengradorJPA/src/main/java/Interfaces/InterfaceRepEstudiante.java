package Interfaces;

import java.util.List;

public interface InterfaceRepEstudiante<Estudiante> {

    public void createEstudiante(Estudiante e);

    public void deleteEstudianteById(long id);

    public void updateEstudiante(Estudiante e);

    public Estudiante selectEstudianteById(long id);

    public List<Estudiante> selectAllEstudiante();
}

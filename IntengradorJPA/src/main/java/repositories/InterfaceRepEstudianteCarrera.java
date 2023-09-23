package repositories;

import entities.EstudianteCarreraId;

import java.util.List;

public interface InterfaceRepEstudianteCarrera<EstudianteCarrera> {

    public void createEstudianteCarrera(EstudianteCarrera ec);

    public void deleteEstudianteCarreraById(long id);

    public void updateEstudianteCarrera(EstudianteCarrera ec);

    public EstudianteCarrera selectEstudianteCarreraById(EstudianteCarreraId id);

    public List<EstudianteCarrera> selectAllEstudianteCarrera();

}

package Interfaces;

import java.util.List;

public interface InterfaceRepCarrera<Carrera> {

    public void createCarrera(Carrera c);

    public void deleteCarreraById(long id);

    public void updateCarrera(Carrera c);

    public Carrera selectCarreraById(long id);

    public List<Carrera> selectAllCarrera();
}

package org.example;

import repository.CarreraRepository;
import repository.EstudianteCarreraRepository;
import repository.EstudianteRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;

public class Factory {
    private static Factory instance;
    private EntityManagerFactory emf;

    public static Factory getInstance() throws SQLException {
        if(instance == null){
            instance = new Factory();
        }

        return instance;
    }

    private Factory(){
        this.emf = Persistence.createEntityManagerFactory("Integrador2");
    }

    public CarreraRepository createCarreraRepository() {
        return CarreraRepository.getInstance(emf);
    }
    public EstudianteRepository createEstudianteRepository() {
        return EstudianteRepository.getInstance(emf);
    }

    public EstudianteCarreraRepository createEstudianteCarreraRepository() {
        return EstudianteCarreraRepository.getInstance(emf);
    }

    public void closeEntityManagerFactory() {
        emf.close();
    }

}

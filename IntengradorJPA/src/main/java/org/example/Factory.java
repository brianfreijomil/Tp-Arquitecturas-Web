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
    private EntityManager em;

    public static Factory getInstance() throws SQLException {
        if(instance == null){
            instance = new Factory();
        }

        return instance;
    }

    private Factory(){
        this.emf = Persistence.createEntityManagerFactory("Integrador2");
        this.em = emf.createEntityManager();
    }

    public CarreraRepository createCarreraRepository() {
        return CarreraRepository.getInstance(em);
    }
    public EstudianteRepository createEstudianteRepository() {
        return EstudianteRepository.getInstance(em);
    }

    public EstudianteCarreraRepository createEstudianteCarreraRepository() {
        return EstudianteCarreraRepository.getInstance(em);
    }

    public void closeEntityManager() {
        em.close();
        emf.close();
    }
}

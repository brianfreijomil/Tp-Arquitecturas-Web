package org.example;

import repositories.CarreraRepository;
import repositories.EstudianteCarreraRepository;
import repositories.EstudianteRepository;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;

public class PostgreSQLFactory extends AbstractFactory{
    private static PostgreSQLFactory instance;
    private EntityManagerFactory emf;

    public static PostgreSQLFactory getInstance() throws SQLException {
        if(instance == null){
            instance = new PostgreSQLFactory();
        }

        return instance;
    }

    private PostgreSQLFactory() {
        this.emf = Persistence.createEntityManagerFactory("POSTGRESQL_DB");
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

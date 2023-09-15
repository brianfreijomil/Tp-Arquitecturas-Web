package main.practico2.Repositories;

import main.practico2.entities.Partido;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class PartidoRepository implements CrudRepository<Partido>{

    private static PartidoRepository instance;
    private EntityManagerFactory emf;
    private EntityManager em;

    private PartidoRepository(EntityManagerFactory emf) {
        this.emf=emf;
    }

    public static PartidoRepository getInstance(EntityManagerFactory emf) {
        if (instance == null) {
            instance = new PartidoRepository(emf);
        }
        return instance;
    }

    @Override
    public void remove(Partido o) {

    }

    @Override
    public void persist(Partido o) {

    }

    @Override
    public void update(Partido o) {

    }

    @Override
    public Partido find(int pk) {
        return null;
    }

    @Override
    public List<Partido> findAll() {
        return null;
    }
}

package main.practico2.Repositories;

import main.practico2.entities.Jugador;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class JugadorRepository implements CrudRepository<Jugador>{

    private static JugadorRepository instance;
    private EntityManagerFactory emf;
    private EntityManager em;

    private JugadorRepository(EntityManagerFactory emf) {
        this.emf=emf;
    }

    public static JugadorRepository getInstance(EntityManagerFactory emf) {
        if (instance == null) {
            instance = new JugadorRepository(emf);
        }
        return instance;
    }
    @Override
    public void remove(Jugador j) {

    }

    @Override
    public void persist(Jugador j) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(j);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void update(Jugador j) {

    }

    @Override
    public Jugador find(int pk) {
        return null;
    }

    @Override
    public List<Jugador> findAll() {
        return null;
    }
}

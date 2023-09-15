package main.practico2.Repositories;

import main.practico2.entities.Torneo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class TorneoRepository implements CrudRepository<Torneo>{

    private static TorneoRepository instance;
    private EntityManagerFactory emf;
    private EntityManager em;

    private TorneoRepository(EntityManagerFactory emf) {
        this.emf=emf;
    }

    public static TorneoRepository getInstance(EntityManagerFactory emf) {
        if (instance == null) {
            instance = new TorneoRepository(emf);
        }
        return instance;
    }
    @Override
    public void remove(Torneo t) {

    }

    @Override
    public void persist(Torneo t) {
        if(t != null){
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(t);
            em.getTransaction().commit();
            em.close();
        }
    }

    @Override
    public void update(Torneo t) {

    }

    @Override
    public Torneo find(int pk) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Torneo tt = em.find(Torneo.class, pk);
        em.getTransaction().commit();
        em.close();
        return tt;
    }

    @Override
    public List<Torneo> findAll() {
        return null;
    }
}

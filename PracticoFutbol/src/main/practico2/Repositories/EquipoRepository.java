package main.practico2.Repositories;

import main.practico2.entities.Equipo;
import main.practico2.entities.Jugador;
import main.practico2.entities.Torneo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class EquipoRepository implements CrudRepository<Equipo>{

    private static EquipoRepository instance;
    private EntityManagerFactory emf;
    private EntityManager em;

    private EquipoRepository(EntityManagerFactory emf) {
        this.emf=emf;
    }

    public static EquipoRepository getInstance(EntityManagerFactory emf) {
        if (instance == null) {
             instance = new EquipoRepository(emf);
        }
        return instance;
    }

    @Override
    public void remove(Equipo e) {

    }

    @Override
    public void persist(Equipo e) {
        if(e != null) {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(e);
            em.getTransaction().commit();
            em.close();
        }
    }

    public void persistPlayer(Equipo e, Jugador j) {
        if(e != null && j != null) {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            e.addJugador(j);
            em.getTransaction().commit();
            em.close();
        }
    }

    @Override
    public void update(Equipo e) {

    }

    @Override
    public Equipo find(int pk) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Equipo ee = em.find(Equipo.class, pk);
        em.getTransaction().commit();
        em.close();
        return ee;
    }

    @Override
    public List<Equipo> findAll() {
        return null;
    }
}

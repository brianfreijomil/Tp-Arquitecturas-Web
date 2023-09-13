package repository;

import entities.Carrera;
import entities.EstudianteCarrera;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class EstudianteCarreraRepository implements CrudRepository{

    private EntityManagerFactory emf;
    private EntityManager em;
    private static EstudianteCarreraRepository instance;

    private EstudianteCarreraRepository(EntityManager em, EntityManagerFactory emf){
        this.em = em;
        this.emf = emf;
    }
    public static EstudianteCarreraRepository getInstance(EntityManager em, EntityManagerFactory emf){
        if(instance==null){
            return new EstudianteCarreraRepository(em,emf);
        }
        return instance;
    }

    @Override
    public void insert(Object o) {
        EstudianteCarrera ec = (EstudianteCarrera) o;
        if(em.isOpen()){
            em.persist(ec);
        }
        else {
            em.getTransaction().begin();
            em.persist(ec);
        }
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    @Override
    public void delete(Object o) {

    }

    @Override
    public void update(Object o) {

    }

    @Override
    public void selectAll() {

    }
}

package repository;

import entities.Carrera;
import entities.Estudiante;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class CarreraRepository implements CrudRepository {
    private EntityManagerFactory emf;
    private EntityManager em;
    private static CarreraRepository instance;

    private CarreraRepository(EntityManager em, EntityManagerFactory emf){
        this.em = em;
        this.emf = emf;
    }

    public static CarreraRepository getInstance(EntityManager em, EntityManagerFactory emf){
        if(instance==null){
            return new CarreraRepository(em,emf);
        }
        return instance;
    }
    @Override
    public void insert(Object o) {
        Carrera c = (Carrera) o;
        if(em.isOpen()){
            em.persist(c);
            em.getTransaction().commit();
        }
        else {
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
        }
        em.close();
        emf.close();
    }
    @Override
    public void delete(Object o) {
    }

    public void deleteByName(Carrera c) {
        em.getTransaction().begin();
        em.remove(c);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    @Override
    public void update(Object o) {

    }

    @Override
    public void selectAll() {
        em.getTransaction().begin();
        @SuppressWarnings("unchecked")
        List<Carrera> carreras = em.createQuery("SELECT c FROM Carrera c").getResultList();
        System.out.println("Carreras");
        for (Carrera car: carreras) {
                System.out.println(car.getName()+", Duracion: "+car.getDuracion()+" años");
        }
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

}

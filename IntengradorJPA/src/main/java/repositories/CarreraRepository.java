package repositories;

import entities.Carrera;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class CarreraRepository implements InterfaceRepCarrera<Carrera> {
    private EntityManagerFactory emf;
    private EntityManager em;
    private static CarreraRepository instance;

    private CarreraRepository(EntityManagerFactory emf){
        this.emf = emf;
    }

    public static CarreraRepository getInstance(EntityManagerFactory emf){
        if(instance==null){
            return new CarreraRepository(emf);
        }
        return instance;
    }

    public void createCarrera(Carrera c) {
        em = emf.createEntityManager();
        if(em.getTransaction().isActive()){
            em.getTransaction().rollback();
        }
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void deleteCarreraById(long id) {
        em = emf.createEntityManager();
        em.close();
    }

    public void deleteByName(Carrera c) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(c);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void updateCarrera(Carrera c) {
        em = emf.createEntityManager();
        em.close();
    }

    @Override
    public Carrera selectCarreraById(long id) {  //a mejorar
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Carrera c = em.find(Carrera.class,id);
        em.getTransaction().commit();
        em.close();
        return c;
    }

    public Carrera selectCarreraByName(String s) {  //a mejorar
        em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Carrera> c = em.createQuery("select c from Carrera c where c.nombre like :s")
                .setParameter("s", s)
                .getResultList();
        em.getTransaction().commit();
        em.close();
        return c.get(0);
    }

    @Override
    public List<Carrera> selectAllCarrera() {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Carrera> carreras = em.createQuery("SELECT c FROM Carrera c").getResultList();
        em.getTransaction().commit();
        em.close();
        return carreras;
    }

}

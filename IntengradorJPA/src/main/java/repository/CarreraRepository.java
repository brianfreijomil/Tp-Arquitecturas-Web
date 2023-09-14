package repository;

import entities.Carrera;
import entities.Estudiante;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class CarreraRepository {
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

    public void insert(Carrera c) {
        em = emf.createEntityManager();
        if(em.getTransaction().isActive()){ //chequeo si la transaccion no esta activa (no deberia)
            em.getTransaction().rollback();//tiro abajo transaccion erroneamente abierta
        }
        em.getTransaction().begin(); //inicio transaccion nueva
        em.persist(c);
        em.getTransaction().commit();
        em.close();
    }

    public void delete(Object o) {
        em = emf.createEntityManager();
    }

    public void deleteByName(Carrera c) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(c);
        em.getTransaction().commit();
        em.close();
    }


    public void update(Object o) {
        em = emf.createEntityManager();
    }


    public void selectAll() {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        @SuppressWarnings("unchecked")
        List<Carrera> carreras = em.createQuery("SELECT c FROM Carrera c").getResultList();
        System.out.println("Carreras");
        for (Carrera car: carreras) {
                System.out.println(car.getName()+", Duracion: "+car.getDuracion()+" años"+", Cantidad de inscriptos: ");
        }
        em.getTransaction().commit();
        em.close();
    }

    public void orderByCantidadInscriptos(){
        em = emf.createEntityManager();
    }
}

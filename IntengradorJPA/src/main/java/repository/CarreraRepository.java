package repository;

import entities.Carrera;
import entities.Estudiante;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class CarreraRepository {
    private EntityManager em;
    private static CarreraRepository instance;

    private CarreraRepository(EntityManager em){
        this.em = em;
    }

    public static CarreraRepository getInstance(EntityManager em){
        if(instance==null){
            return new CarreraRepository(em);
        }
        return instance;
    }

    public void insert(Carrera c) {
        if(em.getTransaction().isActive()){ //chequeo si la transaccion no esta activa (no deberia)
            em.getTransaction().rollback();//tiro abajo transaccion erroneamente abierta
        }
        em.getTransaction().begin(); //inicio transaccion nueva
        em.persist(c);
        em.getTransaction().commit();
    }

    public void delete(Object o) {
    }

    public void deleteByName(Carrera c) {
        em.getTransaction().begin();
        em.remove(c);
        em.getTransaction().commit();
    }


    public void update(Object o) {

    }


    public void selectAll() {
        em.getTransaction().begin();
        @SuppressWarnings("unchecked")
        List<Carrera> carreras = em.createQuery("SELECT c FROM Carrera c").getResultList();
        System.out.println("Carreras");
        for (Carrera car: carreras) {
                System.out.println(car.getName()+", Duracion: "+car.getDuracion()+" años"+", Cantidad de inscriptos: ");
        }
        em.getTransaction().commit();
    }

    public void orderByCantidadInscriptos(){
        em.getTransaction().begin();

    }
}

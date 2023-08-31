package servicios;

import entities.Carrera;
import entities.Estudiante;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class CarreraSV implements servicios{
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-example");
    private final EntityManager em = emf.createEntityManager();
    @Override
    public void insert(Object o) {
        Carrera c = (Carrera) o;
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
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
        em.getTransaction().begin();
        @SuppressWarnings("unchecked")
        List<Estudiante> estudiantes = em.createQuery("SELECT c FROM Carrera c").getResultList();
        estudiantes.forEach(c -> System.out.println(c));
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}

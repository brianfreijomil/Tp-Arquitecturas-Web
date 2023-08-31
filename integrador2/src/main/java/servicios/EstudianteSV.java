package servicios;

import entities.Estudiante;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class EstudianteSV implements servicios{
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-example");
    private final EntityManager em = emf.createEntityManager();

    public EstudianteSV() {
    }

    @Override
    public void insert(Object o) {
        Estudiante e = (Estudiante) o;
        em.getTransaction().begin();
        em.persist(e);
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
        List<Estudiante> estudiantes = em.createQuery("SELECT e FROM Estudiante e").getResultList();
        estudiantes.forEach(e -> System.out.println(e));
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}

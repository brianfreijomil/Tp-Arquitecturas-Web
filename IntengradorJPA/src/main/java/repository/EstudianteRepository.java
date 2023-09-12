package repository;

import entities.Estudiante;

import javax.persistence.*;
import java.util.List;

public class EstudianteRepository implements CrudRepository {
     private static EstudianteRepository instance;
     private EntityManagerFactory emf;
     private EntityManager em;

    private EstudianteRepository(EntityManager em, EntityManagerFactory emf) {
        this.em = em;
        this.emf = emf;
    }

    public static EstudianteRepository getInstance(EntityManager em, EntityManagerFactory emf){
        if(instance==null){
            return new EstudianteRepository(em,emf);
        }
        return instance;
    }

    @Override
    public void insert(Object o) {
        Estudiante e = (Estudiante) o;
        em.getTransaction().begin();
        em.persist(e);
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
        em.getTransaction().begin();
        @SuppressWarnings("unchecked")
        List<Estudiante> estudiantes = em.createQuery("SELECT e FROM Estudiante e").getResultList();
        for (Estudiante es: estudiantes) {
            System.out.println(es.getName()+ " " + es.getLastName()+", Carrera/s: "+ es.getCarrera());
        }
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    public void selectByNroLibreta(int nro_libreta){
        em.getTransaction().begin();
        TypedQuery<Estudiante> estudianteTypedQuery = em.createQuery("SELECT e FROM Estudiante e WHERE e.nro_libreta=nro_libreta", Estudiante.class);
        for(Estudiante e:estudianteTypedQuery.getResultList()) {
            System.out.println(e.getName()+ " " + e.getLastName());
        }
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    public void selectByGenre(String genre){
        em.getTransaction().begin();
        TypedQuery<Estudiante> estudianteTypedQuery = em.createQuery("SELECT e FROM Estudiante e WHERE e.genre=genre", Estudiante.class);
        for(Estudiante e:estudianteTypedQuery.getResultList()) {
            System.out.println(e.getName()+ " " + e.getLastName()+", Carrera/s: "+e.getCarrera());
        }
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}

package repository;

import entities.Estudiante;

import javax.persistence.*;
import java.util.List;

public class EstudianteRepository implements CrudRepository<Estudiante> {
     private static EstudianteRepository instance;
     private EntityManager em;

    private EstudianteRepository(EntityManager em) {
        this.em = em;
    }

    public static EstudianteRepository getInstance(EntityManager em){
        if(instance==null){
            return new EstudianteRepository(em);
        }
        return instance;
    }

    @Override
    public void insert(Estudiante e) {
        if(em.getTransaction().isActive()){ //chequeo si la transaccion no esta activa (no deberia)
            em.getTransaction().rollback();//tiro abajo transaccion erroneamente abierta
        }
        em.getTransaction().begin(); //inicio transaccion nueva
        em.persist(e);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Estudiante e) {

    }

    @Override
    public void update(Estudiante e) {
    }

    public void selectAll() {
        em.getTransaction().begin();
        @SuppressWarnings("unchecked")
        List<Estudiante> estudiantes = em.createQuery("SELECT e FROM Estudiante e").getResultList();
        for (Estudiante es: estudiantes) {
            System.out.println(es.getName()+ " " + es.getLastName());
        }
        em.getTransaction().commit();
    }

    public void selectByNroLibreta(int nro_libreta){
        em.getTransaction().begin();
        TypedQuery<Estudiante> estudianteTypedQuery = em.createQuery("SELECT e FROM Estudiante e WHERE e.nro_libreta=?1", Estudiante.class);
        estudianteTypedQuery.setParameter(1, nro_libreta);
        for(Estudiante e:estudianteTypedQuery.getResultList()) {
            System.out.println(e.getName()+ " " + e.getLastName());
        }
        em.getTransaction().commit();
    }

    public void selectByGenre(String gen){
        em.getTransaction().begin();
        TypedQuery<Estudiante> estudianteTypedQuery = em.createQuery("SELECT e FROM Estudiante e WHERE e.genre =?1", Estudiante.class);
        estudianteTypedQuery.setParameter(1, gen);
        for(Estudiante e:estudianteTypedQuery.getResultList()) {
            System.out.println(e.getName()+ " " + e.getLastName());
        }
        em.getTransaction().commit();
    }
}

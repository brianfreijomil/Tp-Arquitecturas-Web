package repository;

import entities.Estudiante;

import javax.persistence.*;
import java.util.List;

public class EstudianteRepository implements CrudRepository<Estudiante> {
     private static EstudianteRepository instance;
     private EntityManagerFactory emf;
     private EntityManager em;

    private EstudianteRepository(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public static EstudianteRepository getInstance(EntityManagerFactory emf){
        if(instance==null){
            return new EstudianteRepository(emf);
        }
        return instance;
    }

    @Override
    public void insert(Estudiante e) {
        em = emf.createEntityManager();
        if(em.getTransaction().isActive()){ //chequeo si la transaccion no esta activa (no deberia)
            em.getTransaction().rollback();//tiro abajo transaccion erroneamente abierta
        }
        em.getTransaction().begin(); //inicio transaccion nueva
        em.persist(e);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(Estudiante e) {
        em = emf.createEntityManager();
        em.close();

    }

    @Override
    public void update(Estudiante e) {
        em = emf.createEntityManager();
        em.close();
    }

    public void selectAll() {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        @SuppressWarnings("unchecked")
        List<Estudiante> estudiantes = em.createQuery("SELECT e FROM Estudiante e").getResultList();
        for (Estudiante es: estudiantes) {
            System.out.println(es.getName()+ " " + es.getLastName());
        }
        em.getTransaction().commit();
        em.close();
    }

    public void selectByNroLibreta(int nro_libreta){
        em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Estudiante> estudianteTypedQuery = em.createQuery("SELECT e FROM Estudiante e WHERE e.nro_libreta=?1", Estudiante.class);
        estudianteTypedQuery.setParameter(1, nro_libreta);
        for(Estudiante e:estudianteTypedQuery.getResultList()) {
            System.out.println(e.getName()+ " " + e.getLastName());
        }
        em.getTransaction().commit();
        em.close();
    }

    public void selectByGenre(String gen){
        em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Estudiante> estudianteTypedQuery = em.createQuery("SELECT e FROM Estudiante e WHERE e.genre =?1", Estudiante.class);
        estudianteTypedQuery.setParameter(1, gen);
        for(Estudiante e:estudianteTypedQuery.getResultList()) {
            System.out.println(e.getName()+ " " + e.getLastName());
        }
        em.getTransaction().commit();
        em.close();
    }
}

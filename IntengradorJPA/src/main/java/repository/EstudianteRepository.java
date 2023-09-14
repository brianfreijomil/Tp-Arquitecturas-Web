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

    public List<Estudiante> selectAll() {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        //falta criterio de ordenacion
        List<Estudiante> estudiantes = em.createQuery("SELECT e FROM Estudiante e")
                .getResultList();
        em.getTransaction().commit();
        em.close();
        return estudiantes;
    }

    public Estudiante selectByNroLibreta(int nro_libreta){ //arreglar query
        em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Estudiante> result = em.createQuery("SELECT e FROM Estudiante e WHERE e.nro_libreta = :nro_libreta")
                .setParameter(nro_libreta, "nro_libreta").getResultList();
        em.getTransaction().commit();
        em.close();
        return result.get(0);
    }

    public List<Estudiante> selectByGenre(String gen){ //arreglar query
        em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Estudiante> result = em.createQuery("SELECT e FROM Estudiante e WHERE e.genre = :genero")
        .setParameter(gen, "genero").getResultList();
        em.getTransaction().commit();
        em.close();
        return result;
    }
}

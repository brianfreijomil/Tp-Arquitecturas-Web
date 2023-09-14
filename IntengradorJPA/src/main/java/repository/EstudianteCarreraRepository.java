package repository;

import entities.Carrera;
import entities.EstudianteCarrera;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class EstudianteCarreraRepository implements CrudRepository<EstudianteCarrera> {

    private EntityManager em;
    private static EstudianteCarreraRepository instance;

    private EstudianteCarreraRepository(EntityManager em){
        this.em = em;
    }
    public static EstudianteCarreraRepository getInstance(EntityManager em){
        if(instance==null){
            return new EstudianteCarreraRepository(em);
        }
        return instance;
    }

    @Override
    public void insert(EstudianteCarrera ec) {
        if(em.getTransaction().isActive()){ //chequeo si la transaccion no esta activa (no deberia)
            em.getTransaction().rollback();//tiro abajo transaccion erroneamente abierta
        }
        em.getTransaction().begin(); //inicio transaccion nueva
        em.persist(ec);
        em.getTransaction().commit();
    }

    @Override
    public void delete(EstudianteCarrera o) {

    }

    @Override
    public void update(EstudianteCarrera o) {

    }

    public void selectAll() {

    }
}

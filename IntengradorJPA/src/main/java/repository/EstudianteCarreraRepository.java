package repository;

import entities.Carrera;
import entities.EstudianteCarrera;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.sql.ResultSet;
import java.util.List;

public class EstudianteCarreraRepository implements CrudRepository<EstudianteCarrera> {

    private EntityManagerFactory emf;
    private EntityManager em;
    private static EstudianteCarreraRepository instance;

    private EstudianteCarreraRepository(EntityManagerFactory emf){
        this.emf = emf;
    }
    public static EstudianteCarreraRepository getInstance(EntityManagerFactory emf){
        if(instance==null){
            return new EstudianteCarreraRepository(emf);
        }
        return instance;
    }

    @Override
    public void insert(EstudianteCarrera ec) {
        em = emf.createEntityManager();
        if(em.getTransaction().isActive()){ //chequeo si la transaccion no esta activa (no deberia)
            em.getTransaction().rollback();//tiro abajo transaccion erroneamente abierta
        }
        em.getTransaction().begin(); //inicio transaccion nueva
        em.persist(ec);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(EstudianteCarrera o) {
        em = emf.createEntityManager();
        em.close();
    }

    @Override
    public void update(EstudianteCarrera o) {
        em = emf.createEntityManager();
        em.close();
    }

    public void selectAll() {
        em = emf.createEntityManager();
        em.close();
    }

    public List<ResultSet> selectAllCarrerasConInscriptos() {
        //HAY QUE ARREGLAR
        //devuelve carrera y cantidad de inscriptos
        em = emf.createEntityManager();
        em.getTransaction().begin();
        List<ResultSet> carrerasConInscriptos =
                em.createQuery("SELECT c.nombre, COUNT(ec.estudiante_id) AS cantidadInscriptos\n" +
                "FROM estudiante_carrera ec JOIN ec.id.carrera c ON c.id = ec.carrera_id\n" +
                "GROUP BY c.nombre").getResultList();
        em.getTransaction().commit();
        em.close();
        return carrerasConInscriptos;
    }
}

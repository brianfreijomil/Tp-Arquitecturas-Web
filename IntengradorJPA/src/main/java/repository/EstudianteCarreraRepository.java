package repository;

import dto.CarrerasConInscriptosDTO;
import dto.EstudiantesPorCiudad;
import entities.EstudianteCarrera;
import entities.Carrera;
import entities.Estudiante;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
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

    public List<CarrerasConInscriptosDTO> selectAllCarrerasConInscriptos() {
        //HAY QUE ARREGLAR
        //devuelve carrera y cantidad de inscriptos
        em = emf.createEntityManager();
        em.getTransaction().begin();
        List<CarrerasConInscriptosDTO> carrerasConInscriptos =
                em.createQuery("SELECT new dto.CarrerasConInscriptosDTO(c.name, ec.id.carrera.id, COUNT(ec.id.estudiante.id))\n" +
                "FROM estudiante_carrera ec JOIN ec.id.carrera c GROUP BY ec.id.carrera.id,c.name").getResultList();
        em.getTransaction().commit();
        em.close();
        return carrerasConInscriptos;
    }

    public  List<EstudiantesPorCiudad> selectEstudiantesPorCiudad(String city){
        em = emf.createEntityManager();
        em.getTransaction().begin();
        List<EstudiantesPorCiudad> estudiantes = em.createQuery(
            "select new dto.EstudiantesPorCiudad(ec.id.estudiante.id, e.names, e.lastName, c.name)\n"+
                "from estudiante_carrera ec JOIN ec.id.estudiante e " +
                "JOIN ec.id.carrera c "+
                "where e.city = :city " +
                "GROUP BY ec.id.estudiante.id, e.names, e.lastName, c.name")
                .setParameter("city", city).getResultList();
        em.getTransaction().commit();
        em.close();
        return estudiantes;
    }
}

package repositories;

import Interfaces.InterfaceRepEstudianteCarrera;
import dto.CarrerasConInscriptosDTO;
import dto.EstudiantesPorCarreraPorCiudadDTO;
import entities.EstudianteCarrera;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class EstudianteCarreraRepository implements InterfaceRepEstudianteCarrera<EstudianteCarrera> {

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
    public void createEstudianteCarrera(EstudianteCarrera ec) {
        em = emf.createEntityManager();
        if(em.getTransaction().isActive()){
            em.getTransaction().rollback();
        }
        em.getTransaction().begin();
        em.persist(ec);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void deleteEstudianteCarreraById(long id) {
        em = emf.createEntityManager();
        em.close();
    }

    @Override
    public void updateEstudianteCarrera(EstudianteCarrera o) {
        em = emf.createEntityManager();
        em.close();
    }

    public EstudianteCarrera selectEstudianteCarreraById(long id) {
        return null;
    }

    public EstudianteCarrera selectEstudianteCarreraByInstance(EstudianteCarrera ec) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        EstudianteCarrera result = new EstudianteCarrera();
        if(em.contains(ec)) {
            result = em.find(EstudianteCarrera.class, ec.getId());
        }
        em.getTransaction().commit();
        em.close();
        return result;
    }

    @Override
    public List<EstudianteCarrera> selectAllEstudianteCarrera() {
        em = emf.createEntityManager();
        em.close();
        return null;
    }

    public List<CarrerasConInscriptosDTO> selectAllCarrerasConInscriptos() {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        List<CarrerasConInscriptosDTO> carrerasConInscriptos =
                em.createQuery("SELECT new dto.CarrerasConInscriptosDTO(c.nombre, ec.id.carrera.id, COUNT(ec.id.estudiante.id))\n" +
                "FROM estudiante_carrera ec JOIN ec.id.carrera c GROUP BY ec.id.carrera.id,c.nombre").getResultList();
        em.getTransaction().commit();
        em.close();
        return carrerasConInscriptos;
    }

    public  List<EstudiantesPorCarreraPorCiudadDTO> selectEstudiantesPorCarreraByCiudad(String ciudad){
        em = emf.createEntityManager();
        em.getTransaction().begin();
        List<EstudiantesPorCarreraPorCiudadDTO> estudiantes = em.createQuery(
            "select new dto.EstudiantesPorCarreraPorCiudadDTO(ec.id.estudiante.id, e.nombre, e.apellido, c.nombre)\n"+
                "from estudiante_carrera ec JOIN ec.id.estudiante e " +
                "JOIN ec.id.carrera c "+
                "where e.ciudad = :ciudad "+
                "GROUP BY ec.id.estudiante.id, e.nombre, e.apellido, c.nombre")
                .setParameter("ciudad", ciudad).getResultList();
        em.getTransaction().commit();
        em.close();
        return estudiantes;
    }
}

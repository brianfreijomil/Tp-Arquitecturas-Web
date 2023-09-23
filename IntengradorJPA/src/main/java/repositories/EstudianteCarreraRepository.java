package repositories;

import dto.CarrerasConInscriptosDTO;
import dto.EstudiantesPorCarreraPorCiudadDTO;
import dto.ReporteCarrerasDTO;
import entities.EstudianteCarrera;
import entities.EstudianteCarreraId;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public EstudianteCarrera selectEstudianteCarreraById(EstudianteCarreraId pk) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        EstudianteCarrera result = em.find(EstudianteCarrera.class, pk);
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
                "FROM estudiante_carrera ec JOIN ec.id.carrera c " +
                        "GROUP BY ec.id.carrera.id,c.nombre " +
                        "ORDER BY COUNT(ec.id.estudiante.id) desc").getResultList();
        em.getTransaction().commit();
        em.close();
        return carrerasConInscriptos;
    }

    public  List<EstudiantesPorCarreraPorCiudadDTO> selectEstudiantesPorCarreraByCiudad(String carrera, String ciudad){
        em = emf.createEntityManager();
        em.getTransaction().begin();
        List<EstudiantesPorCarreraPorCiudadDTO> estudiantes = em.createQuery(
            "select new dto.EstudiantesPorCarreraPorCiudadDTO(ec.id.estudiante.id, e.nombre, e.apellido, c.nombre, e.ciudad)\n"+
                "from estudiante_carrera ec JOIN ec.id.estudiante e " +
                "JOIN ec.id.carrera c "+
                "where e.ciudad = :ciudad " +
                    "and c.nombre like :carrera "+
                "GROUP BY ec.id.estudiante.id, e.nombre, e.apellido, c.nombre, e.ciudad")
                .setParameter("ciudad", ciudad)
                .setParameter("carrera", carrera)
                .getResultList();
        em.getTransaction().commit();
        em.close();
        return estudiantes;
    }

    public List<ReporteCarrerasDTO> selectInscriptosYEgresadosPorAnio(){
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query =
                em.createNativeQuery("SELECT carrera, SUM(cant_inscriptos) AS cant_inscriptos, " +
                        "SUM(cant_graduados) cant_graduados, anio FROM (\n" +
                        "SELECT c.nombre AS carrera, COUNT(ec.estudiante_id) AS cant_inscriptos, 0 AS cant_graduados,\n" +
                        "EXTRACT(YEAR FROM ec.inscripcion) AS anio\n" +
                        "FROM estudiante_carrera ec\n" +
                        "JOIN carrera c ON ec.carrera_id = c.id\n" +
                        "GROUP BY c.nombre, ec.carrera_id, anio\n" +
                        "UNION ALL\n" +
                        "SELECT c.nombre AS carrera, 0 AS cant_inscriptos, COUNT(ec.estudiante_id) AS cant_graduados,\n" +
                        "EXTRACT(YEAR FROM ec.graduacion) AS anio\n" +
                        "FROM estudiante_carrera ec\n" +
                        "JOIN carrera c ON ec.carrera_id = c.id\n" +
                        "GROUP BY c.nombre, ec.carrera_id, anio) AS subQuery\n" +
                        "WHERE anio IS NOT NULL\n" +
                        "GROUP BY carrera, anio\n" +
                        "ORDER BY carrera ASC, anio ASC");

        List<Object[]> results = query.getResultList();

        em.getTransaction().commit();
        em.close();
        return results.stream()
                .map(result -> new ReporteCarrerasDTO((String) result[0], ((BigDecimal) result[1]).intValue(), ((BigDecimal) result[2]).intValue(), ((BigDecimal) result[3]).intValue()))
                .collect(Collectors.toList());
    }

}

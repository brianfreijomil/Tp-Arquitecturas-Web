package repositories;

import entities.Estudiante;

import javax.persistence.*;
import java.util.List;

public class EstudianteRepository implements InterfaceRepEstudiante<Estudiante> {
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
    public void createEstudiante(Estudiante e) {
        em = emf.createEntityManager();
        if(em.getTransaction().isActive()){
            em.getTransaction().rollback();
        }
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void deleteEstudianteByDNI(int DNI) {
        em = emf.createEntityManager();
        em.close();

    }

    @Override
    public void updateEstudiante(Estudiante e) {
        em = emf.createEntityManager();
        em.close();
    }

    @Override
    public Estudiante selectEstudianteByDNI(int DNI) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Estudiante e = em.find(Estudiante.class, DNI);
        em.getTransaction().commit();
        em.close();
        return e;
    }

    @Override
    public List<Estudiante> selectAllEstudiante() {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Estudiante> estudiantes = em.createQuery("SELECT e FROM Estudiante e").getResultList();
        em.getTransaction().commit();
        em.close();
        return estudiantes;
    }

    public List<Estudiante> selectAllEstudianteOrdApellido() {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Estudiante> estudiantes = em.createQuery("SELECT e FROM Estudiante e ORDER BY e.apellido ASC")
                .getResultList();
        em.getTransaction().commit();
        em.close();
        return estudiantes;
    }

    public Estudiante selectEstudianteByNroLibreta(int nro_libreta){ //relojear retorno
        em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Estudiante> result = em.createQuery("SELECT e FROM Estudiante e WHERE e.nro_libreta = :nro_libreta")
                .setParameter("nro_libreta", nro_libreta).getResultList();
        em.getTransaction().commit();
        em.close();
        return result.get(0);
    }

    public List<Estudiante> selectAllEstudianteByGenero(String genero){
        em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Estudiante> result = em.createQuery("SELECT e FROM Estudiante e WHERE e.genero = :genero")
        .setParameter("genero", genero).getResultList();
        em.getTransaction().commit();
        em.close();
        return result;
    }
}

package project.tp2;

import project.tp2.entities.Persona;
import project.tp2.entities.Socio;
import project.tp2.entities.Turno;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Select {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PracticoN2-JPA-HIBERNATE-ARQUIWEB");
        EntityManager em = emf.createEntityManager();

        //inicio transaccion para empezar a guardar datos
        em.getTransaction().begin();

        Integer idTurno = 16; // se puede modificar por otro o setearlo en consola

        //recuperar todas las personas asignadas a un turno
        List<Turno> turno =
                em.createQuery("SELECT p FROM Turno p WHERE p.id = :idTurno")
                        .setParameter("idTurno",idTurno)
                        .getResultList();
        for (Turno t : turno) {
            System.out.println("Turno: "+t.getId());
            System.out.println("Todas las personas asignadas al turno");
            for (Persona p : t.getJugadores()) {
                System.out.println(p.getNombre());
            }
        }

        System.out.println("//recuperar todas las personas asignadas a un turno, y marcar cuales son socios");
        //recuperar todas las personas asignadas a un turno, y marcar cuales son socios
        System.out.println("Todas las personas asignadas a un turno, socios y no socios");
        for (Persona p : turno.get(0).getJugadores()) {
            int personaId = p.getId();
            List<Socio> socios = em.createQuery("SELECT s FROM Socio s WHERE s.id = :personaId")
                    .setParameter("personaId",personaId)
                    .getResultList();
            if (!socios.isEmpty()) {
                System.out.println(p.getNombre()+", Es socio");
            }
            else {
                System.out.println(p.getNombre()+", No es socio");
            }
        }

        //recuperar todas las peronas que viven en una ciudad predeterminada

        String ciudadBuscada = "Tandil";

        List<Persona> personas = em.createQuery("SELECT p FROM Persona p " +
                "LEFT JOIN p.domicilio d " +
                "WHERE d.ciudad LIKE:ciudadBuscada")
                .setParameter("ciudadBuscada",ciudadBuscada)
                .getResultList();

        System.out.println("Personas que viven en: "+ciudadBuscada);
        for (Persona p:personas) {
            System.out.println(p.toString());
        }

        //En los casos anteriores, evaluar que sucede al utilizar las
        // opciones FetchType.LAZY o
        //FetchType.EAGER en las anotaciones. ¿Nota alguna diferencia?, ¿a qué se debe?

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}

package project.tp2;

import project.tp2.entities.Direccion;
import project.tp2.entities.Persona;
import project.tp2.entities.Socio;
import project.tp2.entities.Turno;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Insert {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PracticoN2-JPA-HIBERNATE-ARQUIWEB");
        EntityManager em = emf.createEntityManager();

        //inicio transaccion para empezar a guardar datos
        em.getTransaction().begin();

        //area de instanciaciones e inserts

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}

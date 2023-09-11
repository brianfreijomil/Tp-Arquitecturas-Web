package main.practico2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Crud {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PracticoN2-JPA-HIBERNATE-ARQUIWEB");
        EntityManager em = emf.createEntityManager();

        //inicio transaccion para empezar a guardar datos
        em.getTransaction().begin();

        //inserts

        //select

        //delets

        //updates

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}

package org.example;

import org.example.Dao.DaoPostgres;

import java.sql.SQLException;

public class Main {

    public static DaoPostgres daoPostgres = new DaoPostgres();
    public static void main(String[] args) throws SQLException {
        daoPostgres.startConnection();
        System.out.println("Lista de personas: ");
        for (Persona p : daoPostgres.getPersonas()) {
            System.out.println(p.toString());
        }
        daoPostgres.closeConnection();
    }
}
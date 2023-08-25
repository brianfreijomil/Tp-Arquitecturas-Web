package org.example.Dao;

import org.example.DataBasePostgres;
import org.example.Persona;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoPostgres extends Dao {

    private Connection db_Connection;

    @Override
    public void startConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/ArquitecturasWeb";
        db_Connection = DriverManager.getConnection(url, "postgres", "postgres");
    }

    @Override
    public void closeConnection() throws SQLException {
        db_Connection.close();
    }

    @Override
    public ArrayList<Persona> getPersonas() throws SQLException {
        ArrayList<Persona> personas = new ArrayList<>();
        DataBasePostgres postgres = new DataBasePostgres();
        ResultSet rs = postgres.readPersonas(db_Connection);
        while (rs.next()) {
            Persona p = new Persona(""+rs.getString(2)+"",+rs.getInt(3));
            personas.add(p);
        }
        return personas;
    }
}

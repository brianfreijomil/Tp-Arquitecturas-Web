package org.example.Dao;

import org.example.Persona;

import java.sql.SQLException;
import java.util.ArrayList;

public abstract class Dao {

    public abstract void startConnection() throws SQLException;

    public abstract void closeConnection() throws SQLException;

    public abstract ArrayList<Persona> getPersonas() throws SQLException;
}

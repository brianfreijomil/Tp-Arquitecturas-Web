package org.example;

import java.sql.SQLException;

public abstract class CrudDataBases{

    /*esta es una opcion???*/
    /*o cada metodo deberia ser una clase?*/
    public abstract void create() throws SQLException;
    public abstract void update() throws SQLException;
    public abstract void insert() throws SQLException;
    public abstract void delete() throws SQLException;
    public abstract void read() throws SQLException;
}

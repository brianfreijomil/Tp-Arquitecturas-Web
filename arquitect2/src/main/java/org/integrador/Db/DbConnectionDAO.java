package org.integrador.Db;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class DbConnectionDAO {
    protected Connection conn;
    public abstract Connection getConnection() throws SQLException;
    public abstract void closeConnection() throws SQLException;

    public abstract void dropTables() throws SQLException;
    public abstract void createAllTables() throws SQLException;
}

package org.example;
import java.sql.*;

public class DataBasePostgres  {

    /*Mi duda con esta clase es si debe seguir existiendo, en ese caso los metodos los deberia
    * heredar de una clase abstracta que tenga todas las opciones CRUD?,*/

    public void addPersona(Connection db, int id, String name, int years) throws SQLException {
        String insert = "INSERT INTO Persona(id, nombre, edad) VALUES (?,?,?)";
        PreparedStatement ps = db.prepareStatement(insert); /*para prevenir injeccion de codigo*/
        ps.setInt(1, id);
        ps.setString(2, name);
        ps.setInt(3, years);
        ps.executeUpdate();
        ps.close();
    }

    public void createTables(Connection db) throws SQLException {
        String table = "CREATE TABLE Persona(" +
                "id integer NOT NULL, " +
                "nombre varchar(500), " +
                "edad integer, " +
                "PRIMARY KEY(id))";
        db.prepareStatement(table).execute();
    }

    public ResultSet readPersonas(Connection db) throws SQLException {
        String read = "SELECT * FROM Persona";
        ResultSet rs = db.prepareStatement(read).executeQuery();
        return rs;
    }
}

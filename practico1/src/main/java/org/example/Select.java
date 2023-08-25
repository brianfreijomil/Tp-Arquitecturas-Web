package org.example;
import java.sql.*;

public class Select {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/ArquitecturasWeb";
        Connection db;
        /*El driver es el encargado de comunicarse con la DB*/
        {
            try {
                db = DriverManager.getConnection(url, "postgres", "postgres");
                String select = "SELECT * FROM Persona";
                PreparedStatement ps = db.prepareStatement(select);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    System.out.println(rs.getInt(1)+", "+rs.getString(2)+", "+rs.getInt(3));
                }
                db.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

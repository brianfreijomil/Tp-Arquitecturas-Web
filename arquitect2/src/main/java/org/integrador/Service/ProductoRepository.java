package org.integrador.Service;

import org.integrador.Db.DbConnectionDAO;
import org.integrador.Entities.Producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ProductoRepository implements CrudRepository{

    public static ProductoRepository instance;

    private Connection conn;

    private ProductoRepository(Connection conn){
        this.conn = conn;
    }

    public static ProductoRepository getInstance(Connection conn) {
        if (instance == null) {
            return new ProductoRepository(conn);
        }
        return instance;
    }
    @Override
    public void create(Object obj) throws SQLException {
        Producto p = (Producto)obj;
        String sql = "INSERT INTO producto(idProducto, nombre, valor) VALUES(?,?,?)";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, p.getIdProducto());
        ps.setString(2, p.getName());
        ps.setFloat(3, p.getValue());
        ps.execute();
    }

}

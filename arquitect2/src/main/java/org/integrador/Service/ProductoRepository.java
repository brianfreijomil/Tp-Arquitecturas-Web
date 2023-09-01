package org.integrador.Service;

import org.integrador.Entities.Producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ProductoRepository implements CrudRepository{

    private Connection conn;

    public ProductoRepository(Connection conn){
        this.conn = conn;
    }
    @Override
    public void create(Object obj) {
        try{
            Producto p = (Producto)obj;
            String sql = "INSERT INTO producto(idProducto, nombre, valor) VALUES(?,?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, p.getIdProducto());
            ps.setString(2, p.getName());
            ps.setFloat(3, p.getValue());
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

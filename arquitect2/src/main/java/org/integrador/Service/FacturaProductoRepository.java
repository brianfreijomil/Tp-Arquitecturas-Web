package org.integrador.Service;

import org.integrador.Db.DbConnectionDAO;
import org.integrador.Entities.Factura;
import org.integrador.Entities.FacturaProducto;
import org.integrador.Entities.Producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class FacturaProductoRepository implements CrudRepository{

    private static  FacturaProductoRepository instance;
    private Connection conn;

    private FacturaProductoRepository(Connection conn){
        this.conn = conn;
    }

    public static FacturaProductoRepository getInstance(Connection conn) {
        if (instance == null) {
            return new FacturaProductoRepository(conn);
        }
        return instance;
    }

    @Override
    public void create(Object obj) throws SQLException {
        FacturaProducto fp = (FacturaProducto) obj;
        String sql = "INSERT INTO factura_producto(idFactura, idProducto, cantidad) VALUES(?,?,?)";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, fp.getIdFactura());
        ps.setInt(2, fp.getIdProducto());
        ps.setInt(3, fp.getCantidad());
        ps.execute();
    }
    public Producto getMostRecaudationProduct() throws SQLException {
        String sql = "SELECT p.idProducto, p.nombre, SUM(fp.cantidad * p.valor) AS recaudacion " +
                "FROM Factura_Producto fp " +
                "JOIN Producto p ON fp.idProducto = p.idProducto " +
                "GROUP BY p.idProducto, p.nombre " +
                "ORDER BY recaudacion DESC " +
                "LIMIT 1";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            Producto p = new Producto(rs.getInt(1), rs.getString(2), rs.getFloat(3));
            return p;
        }
        return null;
    }
}


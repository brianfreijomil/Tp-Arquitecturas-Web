package org.integrador.Repository;

import org.integrador.Entities.Factura;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FacturaRepository implements CrudRepository{

    private static FacturaRepository instance;
    private Connection conn;

    private FacturaRepository(Connection conn){
        this.conn = conn;
    }

    public static FacturaRepository getInstance(Connection conn) {
        if (instance == null) {
            return new FacturaRepository(conn);
        }
        return instance;
    }
    @Override
    public void create(Object obj) throws SQLException {
        Factura f = (Factura) obj;
        String sql = "INSERT INTO factura(idFactura, idCliente) VALUES(?,?)";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, f.getIdFactura());
        ps.setInt(2, f.getIdCliente());
        ps.execute();
    }
}

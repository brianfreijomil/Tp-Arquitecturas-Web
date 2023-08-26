package org.integrador.Service;

import org.integrador.Entities.Factura;
import org.integrador.Entities.Producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class FacturaService implements CrudService{
    private Connection conn;

    public FacturaService(Connection conn){
        this.conn = conn;
    }
    @Override
    public void create(Object obj) {
        try{
            Factura f = (Factura) obj;
            String sql = "INSERT INTO factura(idFactura, idCliente) VALUES(?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, f.getIdFactura());
            ps.setInt(2, f.getIdCliente());
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

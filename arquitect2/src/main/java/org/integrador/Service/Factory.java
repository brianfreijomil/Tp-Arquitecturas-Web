package org.integrador.Service;
import org.integrador.Entities.Factura;

import java.sql.Connection;
public class Factory {


    public ClienteRepository createClienteRepository(Connection conn){
        return new ClienteRepository(conn);
    }
    public FacturaRepository createFacturaRepository(Connection conn){
        return new FacturaRepository(conn);
    }
    public ProductoRepository createProductoRepository(Connection conn){
        return new ProductoRepository(conn);
    }
    public FacturaProductoRepository createFacturaProductoRepository(Connection conn){
        return new FacturaProductoRepository(conn);
    }
}

package org.integrador.Service;
import org.integrador.Entities.Factura;

import java.sql.Connection;
public class Factory {

    public ClienteService createClienteService(){
        return new ClienteService();
    }
    public FacturaService createFacturaService(){
        return new FacturaService();
    }
    public ProductoService createProductoService(){
        return new ProductoService();
    }
    public FacturaProductoService createFacturaProductoService(){
        return new FacturaProductoService();
    }
}

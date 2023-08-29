package org.integrador.CsvFiles;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.integrador.Entities.Cliente;
import org.integrador.Entities.Factura;
import org.integrador.Entities.FacturaProducto;
import org.integrador.Entities.Producto;
import org.integrador.Service.ClienteService;
import org.integrador.Service.FacturaProductoService;
import org.integrador.Service.FacturaService;
import org.integrador.Service.ProductoService;
import org.integrador.CsvFiles.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CsvReader {
    private ProductoService productoService;
    private ClienteService clienteService;
    private FacturaProductoService facturaProductoService;
    private FacturaService facturaService;
    private static final String userDir = System.getProperty("user.dir")+"/src/main/java/org/integrador/CsvFiles/";

    public CsvReader(ProductoService p, ClienteService c, FacturaProductoService fp, FacturaService f) throws IOException {
        this.productoService = p;
        this.clienteService = c;
        this.facturaProductoService = fp;
        this.facturaService = f;
        this.loadProduct(productoService);
        this.loadCliente(clienteService);
        this.loadFactura(facturaService);
        this.loadFacturaProducto(facturaProductoService);
    }

    private void loadFacturaProducto(FacturaProductoService facturaProductoService) throws IOException {
        CSVParser parser = CSVFormat.DEFAULT.withHeader().parse(new
                FileReader(userDir+"facturas-productos.csv"));
        for(CSVRecord row: parser) {
            Integer idFactura = Integer.valueOf(row.get("idFactura"));
            Integer idProducto = Integer.valueOf(row.get("idProducto"));
            Integer cantidad = Integer.valueOf(row.get("cantidad"));
            FacturaProducto fp = new FacturaProducto(idFactura, idProducto, cantidad);
            facturaProductoService.create(fp);
        }
    }

    private void loadFactura(FacturaService facturaService) throws IOException {
        CSVParser parser = CSVFormat.DEFAULT.withHeader().parse(new
                FileReader(userDir+"facturas.csv"));
        for(CSVRecord row: parser) {
            Integer idFactura = Integer.valueOf(row.get("idFactura"));
            Integer idCliente = Integer.valueOf(row.get("idCliente"));
            Factura f = new Factura(idFactura, idCliente);
            facturaService.create(f);
        }
    }

    private void loadCliente(ClienteService clienteService) throws IOException {
        CSVParser parser = CSVFormat.DEFAULT.withHeader().parse(new
                FileReader(userDir+"clientes.csv"));
        for(CSVRecord row: parser) {
            Integer idCliente = Integer.valueOf(row.get("idCliente"));
            String nombre = row.get("nombre");
            String email = row.get("email");
            Cliente c = new Cliente(idCliente, nombre, email);
            clienteService.create(c);
        }
    }


    private void loadProduct(ProductoService productoService) throws IOException {
        CSVParser parser = CSVFormat.DEFAULT.withHeader().parse(new
                FileReader(userDir+"productos.csv"));
        for(CSVRecord row: parser) {
            Integer idProducto = Integer.valueOf(row.get("idProducto"));
            String name = row.get("nombre");
            Float value = Float.valueOf(row.get("valor"));
            Producto p = new Producto(idProducto, name, value);
            productoService.create(p);
        }
    }
}

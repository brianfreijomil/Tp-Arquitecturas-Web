package org.integrador.CsvFiles;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.integrador.Entities.Cliente;
import org.integrador.Entities.Factura;
import org.integrador.Entities.FacturaProducto;
import org.integrador.Entities.Producto;
import org.integrador.Repository.ClienteRepository;
import org.integrador.Repository.FacturaProductoRepository;
import org.integrador.Repository.FacturaRepository;
import org.integrador.Repository.ProductoRepository;

import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

public class CsvReader {
    private ProductoRepository productoRepository;
    private ClienteRepository clienteRepository;
    private FacturaProductoRepository facturaProductoRepository;
    private FacturaRepository facturaRepository;
    private static final String userDir = System.getProperty("user.dir")+"/src/main/java/org/integrador/CsvFiles/";

    public CsvReader(ProductoRepository p, ClienteRepository c, FacturaProductoRepository fp, FacturaRepository f) throws IOException, SQLException {
        this.productoRepository = p;
        this.clienteRepository = c;
        this.facturaProductoRepository = fp;
        this.facturaRepository = f;
        this.loadProduct(productoRepository);
        this.loadCliente(clienteRepository);
        this.loadFactura(facturaRepository);
        this.loadFacturaProducto(facturaProductoRepository);
    }

    private void loadFacturaProducto(FacturaProductoRepository facturaProductoRepository) throws IOException, SQLException {
        CSVParser parser = CSVFormat.DEFAULT.withHeader().parse(new
                FileReader(userDir+"facturas-productos.csv"));
        for(CSVRecord row: parser) {
            Integer idFactura = Integer.valueOf(row.get("idFactura"));
            Integer idProducto = Integer.valueOf(row.get("idProducto"));
            Integer cantidad = Integer.valueOf(row.get("cantidad"));
            FacturaProducto fp = new FacturaProducto(idFactura, idProducto, cantidad);
            facturaProductoRepository.create(fp);
        }
    }

    private void loadFactura(FacturaRepository facturaRepository) throws IOException, SQLException {
        CSVParser parser = CSVFormat.DEFAULT.withHeader().parse(new
                FileReader(userDir+"facturas.csv"));
        for(CSVRecord row: parser) {
            Integer idFactura = Integer.valueOf(row.get("idFactura"));
            Integer idCliente = Integer.valueOf(row.get("idCliente"));
            Factura f = new Factura(idFactura, idCliente);
            facturaRepository.create(f);
        }
    }

    private void loadCliente(ClienteRepository clienteRepository) throws IOException, SQLException {
        CSVParser parser = CSVFormat.DEFAULT.withHeader().parse(new
                FileReader(userDir+"clientes.csv"));
        for(CSVRecord row: parser) {
            Integer idCliente = Integer.valueOf(row.get("idCliente"));
            String nombre = row.get("nombre");
            String email = row.get("email");
            Cliente c = new Cliente(idCliente, nombre, email);
            clienteRepository.create(c);
        }
    }


    private void loadProduct(ProductoRepository productoRepository) throws IOException, SQLException {
        CSVParser parser = CSVFormat.DEFAULT.withHeader().parse(new
                FileReader(userDir+"productos.csv"));
        for(CSVRecord row: parser) {
            Integer idProducto = Integer.valueOf(row.get("idProducto"));
            String name = row.get("nombre");
            Float value = Float.valueOf(row.get("valor"));
            Producto p = new Producto(idProducto, name, value);
            productoRepository.create(p);
        }
    }
}

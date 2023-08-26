package org.integrador;

import org.integrador.CsvFiles.CsvReader;
import org.integrador.Db.DbConnectionDAO;
import org.integrador.Db.PostgresConnectionDAO;
import org.integrador.Entities.Cliente;
import org.integrador.Entities.Producto;
import org.integrador.Service.ClienteService;
import org.integrador.Service.FacturaProductoService;
import org.integrador.Service.FacturaService;
import org.integrador.Service.ProductoService;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        DbConnectionDAO db = new PostgresConnectionDAO();
        Connection conn = db.getConnection();
        //borro todas las tablas
        db.dropTables();
        //creo todas las tablas de cada entidad
        db.createAllTables();
        System.out.println("Tablas creadas");
        ProductoService productoService = new ProductoService(conn);
        ClienteService clienteService = new ClienteService(conn);
        FacturaProductoService facturaProductoService = new FacturaProductoService(conn);
        FacturaService facturaService = new FacturaService(conn);
        //lee todos los archivos y hace los insert de todo
        CsvReader csv = new CsvReader(productoService, clienteService, facturaProductoService, facturaService);
        System.out.println("Inserts de todas las tablas listas");
        //punto3
        System.out.println("PUNTO 3");
        Producto p = facturaProductoService.getMostRecaudationProduct();
        System.out.println(p);
        System.out.println("---------------------------------------------");
        ArrayList<Cliente> arr = (ArrayList<Cliente>) clienteService.getAllClientByMostRecepte();
        System.out.println("PUNTO 4");
        for (Cliente c: arr){
            System.out.println(c);
            System.out.println("-----------------------------------------");
        }
        db.closeConnection();
        System.out.println("Cierro db");
    }
}
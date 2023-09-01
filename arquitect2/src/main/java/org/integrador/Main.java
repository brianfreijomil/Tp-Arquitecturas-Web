package org.integrador;

import org.integrador.CsvFiles.CsvReader;
import org.integrador.Db.DbConnectionDAO;
import org.integrador.Db.PostgresConnectionDAO;
import org.integrador.Entities.Cliente;
import org.integrador.Entities.Producto;
import org.integrador.Service.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        Scanner lectura = new Scanner (System.in);
        System.out.println("Ingresar puerto de Base de Datos");
        String dbPort = lectura.next();
        System.out.println("Ingresar nombre de Base de Datos");
        String dbName = lectura.next();
        System.out.println("Ingresar nombre de usuario");
        String dbUser = lectura.next();
        System.out.println("Ingresar contraseña");
        String dbPassword = lectura.next();
        DbConnectionDAO db = new PostgresConnectionDAO(dbPort,dbName,dbUser,dbPassword);
        Connection conn = db.getConnection();
        //borro todas las tablas
        db.dropTables();
        //creo todas las tablas de cada entidad
        db.createAllTables();
        System.out.println("Tablas creadas");
        Factory factory = new Factory();
        ProductoRepository productoRepository = factory.createProductoRepository(conn);
        ClienteRepository clienteRepository = factory.createClienteRepository(conn);
        FacturaProductoRepository facturaProductoRepository = factory.createFacturaProductoRepository(conn);
        FacturaRepository facturaRepository = factory.createFacturaRepository(conn);
        //lee todos los archivos y hace los insert de todo
        CsvReader csv = new CsvReader(productoRepository, clienteRepository, facturaProductoRepository, facturaRepository);
        System.out.println("Inserts de todas las tablas listas");
        //punto3
        System.out.println("PUNTO 3");
        Producto p = facturaProductoRepository.getMostRecaudationProduct();
        System.out.println(p);
        System.out.println("---------------------------------------------");
        ArrayList<Cliente> arr = (ArrayList<Cliente>) clienteRepository.getAllClientByMostRecepte();
        System.out.println("PUNTO 4");
        for (Cliente c: arr){
            System.out.println(c);
            System.out.println("-----------------------------------------");
        }
        db.closeConnection();
        System.out.println("Cierro db");
    }
}
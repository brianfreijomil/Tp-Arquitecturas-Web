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
        ProductoService productoService = factory.createProductoService();
        ClienteService clienteService = factory.createClienteService();
        FacturaProductoService facturaProductoService = factory.createFacturaProductoService();
        FacturaService facturaService = factory.createFacturaService();
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
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

    public static ProductoRepository productoRepository;
    public static ClienteRepository clienteRepository;
    public static FacturaRepository facturaRepository;
    public static FacturaProductoRepository facturaProductoRepository;
    public static void main(String[] args) throws SQLException, IOException {

        //Solicito datos para ingresar a la Base de Datos (PostgreSQL)
        Scanner lectura = new Scanner (System.in);
        System.out.println("Ingresar puerto de Base de Datos");
        String dbPort = lectura.next();
        System.out.println("Ingresar nombre de Base de Datos");
        String dbName = lectura.next();
        System.out.println("Ingresar nombre de usuario");
        String dbUser = lectura.next();
        System.out.println("Ingresar contraseña");
        String dbPassword = lectura.next();

        //creo factory y sus repositories
        Factory factory = new Factory("5432","ArquitecturasWeb","postgres","postgres");
        factory.initDB();
        productoRepository = factory.createProductoRepository();
        clienteRepository = factory.createClienteRepository();
        facturaProductoRepository = factory.createFacturaProductoRepository();
        facturaRepository = factory.createFacturaRepository();

        //lee todos los archivos y puebla todas las tablas
        CsvReader csv = new CsvReader(productoRepository, clienteRepository, facturaProductoRepository, facturaRepository);
        System.out.println("Inserts de todas las tablas listas");

        //punto 3 Tp
        System.out.println("PUNTO 3");
        Producto p = facturaProductoRepository.getMostRecaudationProduct();
        System.out.println(p);
        System.out.println("---------------------------------------------");
        ArrayList<Cliente> arr = (ArrayList<Cliente>) clienteRepository.getAllClientByMostRecepte();

        //Punto 4 Tp
        System.out.println("PUNTO 4");
        for (Cliente c: arr){
            System.out.println(c);
            System.out.println("-----------------------------------------");
        }

        //cerrar Conexion a la DB
        factory.closeDB();
    }
}
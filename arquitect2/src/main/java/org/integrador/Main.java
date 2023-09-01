package org.integrador;

import org.integrador.CsvFiles.CsvReader;
import org.integrador.Entities.Cliente;
import org.integrador.Entities.Producto;
import org.integrador.Repository.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException, IOException {

        //creo factory y sus repositories
        Factory factory = Factory.getInstance();
        factory.initDB();
        ProductoRepository productoRepository = factory.createProductoRepository();
        ClienteRepository clienteRepository = factory.createClienteRepository();
        FacturaProductoRepository facturaProductoRepository = factory.createFacturaProductoRepository();
        FacturaRepository facturaRepository = factory.createFacturaRepository();

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
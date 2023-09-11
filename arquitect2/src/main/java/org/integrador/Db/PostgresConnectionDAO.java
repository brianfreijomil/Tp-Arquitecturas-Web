package org.integrador.Db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class PostgresConnectionDAO extends DbConnectionDAO{
    public PostgresConnectionDAO(){
    }

    @Override
    public Connection getConnection() throws SQLException {
        if(this.conn == null){
            this.conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/?user=postgres&&password=postgres");
            return this.conn;
        }

        return this.conn;
    }

    @Override
    public void closeConnection() throws SQLException {
        if(this.conn != null){
            this.conn.close();
        }
    }

    @Override
    public void dropTables() throws SQLException {
        String sql = "DROP TABLE IF EXISTS Cliente, Factura, Factura_Producto, Producto, Factura";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.execute();
    }

    @Override
    public void createAllTables() throws SQLException {
        ArrayList<String> arr = new ArrayList<>();
        String create1 = "CREATE TABLE IF NOT EXISTS Cliente (" +
                "idCliente int  NOT NULL, " +
                "nombre varchar(500)  NOT NULL, " +
                "email varchar(150)  NOT NULL, " +
                "CONSTRAINT Cliente_pk PRIMARY KEY (idCliente))";
        arr.add(create1);
        String create2 = "CREATE TABLE IF NOT EXISTS Factura (" +
                "idFactura int  NOT NULL, " +
                "idCliente int  NOT NULL, " +
                "CONSTRAINT Factura_pk PRIMARY KEY (idFactura))";
        arr.add(create2);
        String create4 = "CREATE TABLE IF NOT EXISTS Producto (" +
                "idProducto int  NOT NULL, " +
                "nombre varchar(45)  NOT NULL, " +
                "valor real  NOT NULL, " +
                "CONSTRAINT Producto_pk PRIMARY KEY (idProducto))";
        arr.add(create4);
        String create3 = "CREATE TABLE IF NOT EXISTS Factura_Producto (" +
                "cantidad int  NOT NULL, " +
                "idFactura int  NOT NULL, " +
                "idProducto int  NOT NULL, " +
                "CONSTRAINT Factura_Producto_pk PRIMARY KEY (idFactura,idProducto))";
        arr.add(create3);
        String create5 = "ALTER TABLE Factura ADD CONSTRAINT Factura_Cliente " +
                "FOREIGN KEY (idCliente) REFERENCES Cliente (idCliente) " +
                "NOT DEFERRABLE INITIALLY IMMEDIATE";
        arr.add(create5);
        String create6 = "ALTER TABLE Factura_Producto ADD CONSTRAINT Factura_Producto_Factura " +
                "FOREIGN KEY (idFactura) REFERENCES Factura (idFactura) " +
                "NOT DEFERRABLE INITIALLY IMMEDIATE";
        arr.add(create6);
        String create7 = "ALTER TABLE Factura_Producto ADD CONSTRAINT Factura_Producto_Producto " +
                "FOREIGN KEY (idProducto) REFERENCES Producto (idProducto) " +
                "NOT DEFERRABLE INITIALLY IMMEDIATE";
        arr.add(create7);
        for (String s : arr) {
            PreparedStatement ps = this.conn.prepareStatement(s);
            ps.execute();
        }
    }
}

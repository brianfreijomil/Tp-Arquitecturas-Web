package org.integrador;
import org.integrador.Db.DbConnectionDAO;
import org.integrador.Db.PostgresConnectionDAO;
import org.integrador.Repository.ClienteRepository;
import org.integrador.Repository.FacturaProductoRepository;
import org.integrador.Repository.FacturaRepository;
import org.integrador.Repository.ProductoRepository;

import java.sql.Connection;
import java.sql.SQLException;

public class Factory {
    private DbConnectionDAO db;
    private Connection conn;

    private static Factory instance;

    public static Factory getInstance() throws SQLException {
        if(instance == null){
            instance = new Factory();
        }

        return instance;
    }

    private Factory(){
        this.db = new PostgresConnectionDAO();
    }

    public void initDB() throws SQLException {
        if(this.conn == null && this.db != null){
            this.conn = this.db.getConnection();
            this.db.dropTables();
            this.db.createAllTables();
        }
    }

    public void closeDB() throws SQLException {
        if(this.conn != null){
            this.db.closeConnection();
            this.db = null;
        }
    }
    public ClienteRepository createClienteRepository() {
        return ClienteRepository.getInstance(conn);
    }
    public FacturaRepository createFacturaRepository() {
        return FacturaRepository.getInstance(conn);
    }
    public ProductoRepository createProductoRepository() {
        return ProductoRepository.getInstance(conn);
    }
    public FacturaProductoRepository createFacturaProductoRepository() {
        return FacturaProductoRepository.getInstance(conn);
    }
}

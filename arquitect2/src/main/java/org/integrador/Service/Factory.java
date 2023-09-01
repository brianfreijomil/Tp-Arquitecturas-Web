package org.integrador.Service;
import org.integrador.Db.DbConnectionDAO;
import org.integrador.Db.PostgresConnectionDAO;
import org.integrador.Entities.Factura;

import java.sql.Connection;
import java.sql.SQLException;

public class Factory {
    private DbConnectionDAO db;
    private Connection conn;

    public Factory(String portDB, String nameDB, String userDB, String passwordDB) throws SQLException {
        this.db = new PostgresConnectionDAO(portDB,nameDB,userDB,passwordDB);
    }

    public void initDB() throws SQLException {
        this.conn = this.db.getConnection();
        this.db.dropTables();
        this.db.createAllTables();
    }

    public void closeDB() throws SQLException {
        this.db.closeConnection();
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

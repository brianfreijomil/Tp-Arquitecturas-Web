package org.integrador.Service;
import org.integrador.Db.DbConnectionDAO;
import org.integrador.Db.PostgresConnectionDAO;
import org.integrador.Entities.Cliente;
import org.integrador.Service.CrudRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepository implements CrudRepository {

    private static ClienteRepository instance;
    private Connection conn;

    private ClienteRepository(Connection conn){
        this.conn = conn;
    }

    public static ClienteRepository getInstance(Connection conn) {
        if (instance == null) {
            instance = new ClienteRepository(conn);
        }
        return instance;
    }

    @Override
    public void create(Object obj) throws SQLException {
        Cliente c = (Cliente) obj;
        String sql = "INSERT INTO cliente(idCliente, nombre, email) VALUES(?,?,?)";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, c.getIdCliente());
        ps.setString(2, c.getName());
        ps.setString(3, c.getName());
        ps.execute();
    }


    public List<Cliente> getAllClientByMostRecepte() throws SQLException {
        String sql  = "Select c.idCLiente, c.nombre, c.email, count(f.idFactura) as cant " +
                "from cliente c " +
                "join factura f on c.idCliente = f.idCliente " +
                "group by c.idCliente " +
                "order by cant desc";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        ArrayList<Cliente> arr  = new ArrayList<>();
        while(rs.next()){
            Cliente c = new Cliente(rs.getInt(1), rs.getString(2), rs.getString(3));
            arr.add(c);
        }
        return  arr;
    }
}


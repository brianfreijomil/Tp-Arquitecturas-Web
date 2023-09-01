package org.integrador.Service;

import java.sql.SQLException;
import java.util.List;

public interface CrudRepository {
    public void create(Object obj) throws SQLException;
}

package org.integrador.Repository;

import java.sql.SQLException;

public interface CrudRepository {
    public void create(Object obj) throws SQLException;
}

package factory;

import repositories.CarreraRepository;
import repositories.EstudianteCarreraRepository;
import repositories.EstudianteRepository;

import java.sql.SQLException;

public abstract class AbstractFactory {

    public static final int POSTGRESQL_DB = 1; //persitence-unit postgres

    public abstract CarreraRepository createCarreraRepository();
    public abstract EstudianteRepository createEstudianteRepository();
    public abstract EstudianteCarreraRepository createEstudianteCarreraRepository();
    public abstract void closeEntityManagerFactory();

    public static AbstractFactory getDAOFactory(int persistence) throws SQLException {
        switch (persistence) {
            case POSTGRESQL_DB : return PostgreSQLFactory.getInstance();
            default: return null;
        }
    }
}

package repository;

public interface CrudRepository {
    void insert(Object o);
    void delete(Object o);
    void update (Object o);
    void selectAll();
}


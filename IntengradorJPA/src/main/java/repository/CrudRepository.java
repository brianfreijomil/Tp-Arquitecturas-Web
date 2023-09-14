package repository;

import entities.Estudiante;

public interface CrudRepository<T> {
    void insert(T o);

    void delete(T o);
    void update (T o);
    void selectAll();
}


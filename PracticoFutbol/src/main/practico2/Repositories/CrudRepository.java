package main.practico2.Repositories;

import main.practico2.entities.Jugador;

import java.util.List;

public interface CrudRepository<T> {

    public void remove(T o);
    public void persist(T o);
    public void update(T o);
    public T find(int o);
    public List<T> findAll();
}

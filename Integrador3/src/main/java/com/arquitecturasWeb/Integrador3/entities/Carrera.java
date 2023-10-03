package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Carrera {

    @Id
    private long id;
    @Column(nullable = false)
    private String nombre;
    @Column(name = "duracion_anios")
    private int duracion;

    public Carrera() {
        super();
    }
    public Carrera(long id, String nombre, int duracion) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.duracion = duracion;
    }

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String name) {
        this.nombre = name;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "Carrera{" +
                "id=" + id +
                ", name='" + nombre + '\'' +
                ", duracion=" + duracion +
                '}';
    }
}

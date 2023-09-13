package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Carrera {

    /*
    * Nombre
    * duracion en años
    * */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "nombre", nullable = false)
    private String name;
    @Column(name = "duracion_anios")
    private int duracion;

    public Carrera() {
        super();
    }
    public Carrera(String name, int duracion) {
        super();
        this.name = name;
        this.duracion = duracion;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                ", name='" + name + '\'' +
                ", duracion=" + duracion +
                '}';
    }
}

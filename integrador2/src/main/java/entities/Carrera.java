package entities;

import javax.persistence.*;

@Entity
public class Carrera {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(name = "duracion")
    private int duracion;

    public Carrera() {
    }
    public Carrera(String name, int duracion) {
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

package main.practico2.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Torneo {

    @Id
    private int id;
    @Column(nullable = false)
    private String nombre;
    @ManyToOne
    private List<Equipo> equipos; //predefinida

    public Torneo() {
        super();
    }

    public Torneo(int id,String nombre) {
        super();
        this.id=id;
        this.nombre=nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }
}

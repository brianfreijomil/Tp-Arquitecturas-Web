package main.practico2.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Torneo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    private String nombre;
    @OneToMany
    private List<Equipo> equipos; //predefinida
    @OneToMany
    private List<Partido> partidos;

    public Torneo() {
        super();
    }

    public Torneo(String nombre) {
        super();
        this.id=id;
        this.nombre=nombre;
        this.equipos=new ArrayList<>();
        this.partidos=new ArrayList<>();
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

    public List<Partido> getPartidos() {
        return partidos;
    }

    public void addEquipo(Equipo e) {
        equipos.add(e);
    }

    public void addPartido(Partido p) {
        partidos.add(p);
    }
}

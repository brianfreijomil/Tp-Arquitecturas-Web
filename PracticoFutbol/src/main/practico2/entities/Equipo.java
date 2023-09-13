package main.practico2.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    private String nombre;
    @Column
    private String tecnico;
    @OneToMany
    private List<Jugador> jugadores; //7 titulares, 3 suplentes
    @ManyToOne
    private Torneo torneo;

    public Equipo() {
        super();
    }

    public Equipo(String nombre,String tecnico) {
        super();
        this.id=id;
        this.nombre=nombre;
        this.tecnico=tecnico;
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

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
}

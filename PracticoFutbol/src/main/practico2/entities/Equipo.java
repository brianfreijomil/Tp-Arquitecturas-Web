package main.practico2.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Equipo {

    @Id
    private int id;
    @Column(nullable = false)
    private String nombre;
    @Column
    private String tecnico;
    @OneToMany(mappedBy = "equipo", fetch = FetchType.EAGER)
    private List<Jugador> jugador;
    @ManyToOne
    private Torneo torneo;

    public Equipo() {
        super();
    }

    public Equipo(int id,String nombre,String tecnico,Torneo torneo) {
        super();
        this.id=id;
        this.torneo=torneo;
        this.nombre=nombre;
        this.tecnico=tecnico;
        this.jugador=new ArrayList<Jugador>();
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
        return jugador;
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

    public Torneo getTorneo() {
        return torneo;
    }

    public void setTorneo(Torneo torneo) {
        this.torneo = torneo;
    }

    public void addJugador(Jugador j) {
        if(j != null) {
            jugador.add(j);
        }
    }
}

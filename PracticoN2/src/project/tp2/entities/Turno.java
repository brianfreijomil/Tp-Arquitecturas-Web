package project.tp2.entities;

import project.tp2.entities.Persona;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Turno {

    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private Timestamp fecha;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Persona> jugadores;

    public Turno() {
        super();
    }

    public Turno(Timestamp fecha) {
        this.fecha=fecha;
        this.jugadores=new ArrayList<>();
    }

    public int getId() {
        return this.id;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public List<Persona> getJugadores() {
        return jugadores;
    }

    @Override
    public String toString() {
        return "Turno{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", jugadores=" + jugadores +
                '}';
    }
}

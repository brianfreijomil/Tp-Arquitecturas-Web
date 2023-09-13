package main.practico2.entities;

import javax.persistence.*;

@Entity
public class Jugador {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String posicion;
    @ManyToOne
    private Equipo equipo;
    public Jugador() {
        super();
    }

    public Jugador(String nombre,String posicion,Equipo equipo) {
        super();
        this.id=id;
        this.posicion=posicion;
        this.equipo=equipo;
    }

    public int getId() {
        return id;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }
}

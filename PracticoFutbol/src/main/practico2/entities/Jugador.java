package main.practico2.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Jugador {
    
    @Id
    private int id;
    @Column(nullable = false)
    private String posicion;
    @ManyToOne
    private Equipo equipo;

    //posicion(arquero, defensa, mediocampo, delantera)
    //equipo
    public Jugador() {
        super();
    }

    public Jugador(int id,String posicion,Equipo equipo) {
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

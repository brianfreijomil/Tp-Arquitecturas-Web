package main.practico2.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Jugador {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String posicion; //delantero,arquero,volante,defensor
    @Column(nullable = false)
    private String estado;//lesionado,echado,disponible //puede ser boolean tamb
    @ManyToOne
    private Equipo equipo_id;
    @ManyToMany
    private List<Partido> partidos;

    public Jugador() {
        super();
    }

    public Jugador(String nombre,String posicion,Equipo equipo,String estado) {
        super();
        this.id=id;
        this.equipo_id=equipo;
        this.posicion=posicion;
        this.estado=estado;
    }

    public int getId() {
        return id;
    }

    public Equipo getEquipo() {
        return equipo_id;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo_id = equipo;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}

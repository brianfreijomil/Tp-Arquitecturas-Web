package main.practico2.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Jugador {
    
    @Id
    private int id;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String posicion; //delantero,arquero,volante,defensor
    @Column(nullable = false)
    private String estado;//lesionado,echado,disponible //puede ser boolean tamb
    @ManyToOne()
    private Equipo equipo;
    @ManyToMany
    private List<Partido> partidos;

    public Jugador() {
        super();
    }

    public Jugador(int id,String nombre,String posicion,String estado) {
        super();
        this.id=id;
        this.nombre=nombre;
        this.posicion=posicion;
        this.estado=estado;
        this.partidos=new ArrayList<>();
    }

    public int getId() {
        return id;
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

    @Override
    public String toString() {
        return nombre;
    }
}

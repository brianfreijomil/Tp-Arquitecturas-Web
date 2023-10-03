package project.tp2.entities;

import project.tp2.entities.Direccion;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Persona {

    @Id
    private int id;
    @Column(nullable = false)
    private String nombre;
    @Column(name = "anios")
    private int edad;
    @ManyToOne()
    private Direccion domicilio;

    public Persona() {
        super();
    }

    public Persona(int id,String nombre,int edad,Direccion domicilio) {
        super();
        this.id=id;
        this.nombre=nombre;
        this.edad=edad;
        this.domicilio=domicilio;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Direccion getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Direccion domicilio) {
        this.domicilio = domicilio;
    }

    @Override
    public String toString() {
        return this.nombre+", "+this.edad+" ("+this.id+")";
    }
}
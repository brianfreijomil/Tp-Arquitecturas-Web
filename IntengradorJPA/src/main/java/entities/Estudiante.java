package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private int dni;
    @Column(nullable = false)
    private String names;
    @Column(nullable = false, name = "lastName")
    private String lastName;
    @Column(name = "edad")
    private int age;
    @Column(name = "genero", nullable = true)
    private String genre;
    @Column
    private int nro_libreta;
    @Column(name = "ciudad")
    private String city;

    public Estudiante() {
        super();
    }

    public Estudiante(int dni, String names, String lastName, int age,String genre, int nro_libreta, String city) {
        super();
        this.dni = dni;
        this.names = names;
        this.lastName = lastName;
        this.age = age;
        this.genre = genre;
        this.nro_libreta = nro_libreta;
        this.city = city;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getId() {
        return id;
    }
    public int getDni() {
        return dni;
    }

    public String getName() {
        return names;
    }

    public void setName(String name) {
        this.names = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNro_libreta() {
        return nro_libreta;
    }

    public void setNro_libreta(int nro_libreta) {
        this.nro_libreta = nro_libreta;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    @Override
    public String toString() {
        return "Estudiante: "+names+", "+lastName+". "+city;
    }
}

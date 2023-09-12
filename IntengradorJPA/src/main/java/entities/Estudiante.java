package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "dni")
    private int dni;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, name = "lastName")
    private String lastName;
    @Column(name = "age")
    private int age;
    @Column(name = "genre", nullable = true)
    private String genre;
    @Column(name = "nro_libreta")
    private int nro_libreta;
    @Column(name = "ciudad")
    private String city;
    @ManyToMany (mappedBy = "estudiantes")
    private List<Carrera> carreras;

    public Estudiante(int dni, String name, String lastName, int age,String genre, int nro_libreta, String city, Carrera c) {
        this.dni = dni;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.genre = genre;
        this.nro_libreta = nro_libreta;
        this.city = city;
        this.carreras = new ArrayList<>();
        carreras.add(c);
    }

    public Estudiante() {

    }

    public void addCarrera(Object o){
        Carrera c = (Carrera) o;
        this.carreras.add(c);
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
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<Carrera> getCarrera() {
        return this.carreras;
    }


    @Override
    public String toString() {
        return "Estudiante{" +
                "dni=" + dni +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", genre="+ genre+
                ", nro_libreta=" + nro_libreta +
                ", city=" + city +
                '}';
    }
}

package entities;

import javax.persistence.*;
import java.util.ArrayList;
@Entity
public class Estudiante {
    @Id
    private int dni;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String lastName;
    @Column(name = "age")
    private int age;
    @Id
    @Column(name = "nro_libreta")
    private int nro_libreta;
    @ManyToOne
    private Ciudad city;
    @OneToMany
    private ArrayList<Carrera> carreras;

    public Estudiante() {
    }

    public Estudiante(int dni, String name, String lastName, int age, int nro_libreta, Ciudad city) {
        this.dni = dni;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.nro_libreta = nro_libreta;
        this.city = city;
        this.carreras = new ArrayList<>();
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

    public Ciudad getCity() {
        return city;
    }

    public void setCity(Ciudad city) {
        this.city = city;
    }

    public ArrayList<Carrera> getCarreras() {
        return carreras;
    }

    public void setCarreras(ArrayList<Carrera> carreras) {
        this.carreras = carreras;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "dni=" + dni +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", nro_libreta=" + nro_libreta +
                ", city=" + city +
                ", carreras=" + carreras +
                '}';
    }
}

package project.tp2.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Direccion {

    @Id()
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    @Column
    private String ciudad;
    @Column
    private String calle;
    @OneToMany(mappedBy = "domicilio", fetch = FetchType.LAZY)
    private List<Persona> habitante;

    public Direccion() {
        super();
        this.habitante = new ArrayList<Persona>();
    }

    public int getId() {
        return id;
    }

    public Direccion(String ciudad, String calle) {
        super();
        this.ciudad=ciudad;
        this.calle=calle;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public List<Persona> getHabitante() {
        return habitante;
    }

    public void setHabitante(List<Persona> habitante) {
        this.habitante = habitante;
    }

    @Override
    public String toString() {
        return "Direccion: "+this.ciudad+", "+this.calle;
    }
}

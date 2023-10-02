package project.tp2.entities;

import org.jetbrains.annotations.NotNull;
import project.tp2.entities.Persona;

import javax.persistence.*;

@Entity
public class Socio {

    @Id
    private Integer id;
    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    private Persona persona;
    @Column
    private String tipo;

    public Socio() {
        super();
    }

    public Socio(@NotNull Persona persona, String tipo) {
        super();
        this.persona = persona;
        this.id = persona.getId();
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}

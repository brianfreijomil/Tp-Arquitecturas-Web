package main.practico2.entities.pks;

import main.practico2.entities.Equipo;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class PartidoId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "equipo_local")
    private Equipo local;
    @ManyToOne
    @JoinColumn(name = "equipo_visitante")
    private Equipo visitante;

    public PartidoId() {
        super();
    }
    public PartidoId(Equipo local,Equipo visitante) {
        super();
        this.local=local;
        this.visitante=visitante;
    }
}

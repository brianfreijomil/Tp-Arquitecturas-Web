package main.practico2.entities;

import main.practico2.entities.pks.PartidoId;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Partido {

    @EmbeddedId
    private PartidoId id;
    @Column
    private Timestamp fecha;
    @Column
    private String resultado;
    @Column
    private int ptsParaLocal;
    @Column
    private int ptsParaVisitante;
    @OneToMany
    private List<Jugador> bajas;
    @ManyToMany(mappedBy = "partidos")
    private List<Jugador> goles;

    public Partido() {
        super();
    }

    public Partido(PartidoId pk, Timestamp fecha, String resultado, int ptsL, int ptsV) {
        super();
        this.id = pk;
        this.fecha = fecha;
        this.resultado = resultado;
        this.ptsParaLocal = ptsL;
        this.ptsParaVisitante = ptsV;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public int getPtsParaLocal() {
        return ptsParaLocal;
    }

    public void setPtsParaLocal(int ptsParaLocal) {
        this.ptsParaLocal = ptsParaLocal;
    }

    public int getPtsParaVisitante() {
        return ptsParaVisitante;
    }

    public void setPtsParaVisitante(int ptsParaVisitante) {
        this.ptsParaVisitante = ptsParaVisitante;
    }

    public List<Jugador> getBajas() {
        return bajas;
    }

    public PartidoId getId() {
        return id;
    }
}

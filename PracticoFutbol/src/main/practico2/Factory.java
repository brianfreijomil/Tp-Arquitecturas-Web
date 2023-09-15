package main.practico2;

import main.practico2.Repositories.EquipoRepository;
import main.practico2.Repositories.JugadorRepository;
import main.practico2.Repositories.PartidoRepository;
import main.practico2.Repositories.TorneoRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Factory {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("PracticoN2-JPA-HIBERNATE-ARQUIWEB");

    public void closeEMF() {
        emf.close();
    }
    public EquipoRepository createEquipoRepository() {
        return EquipoRepository.getInstance(emf);
    }
    public TorneoRepository createTorneoRepository() {
        return TorneoRepository.getInstance(emf);
    }
    public JugadorRepository createJugadorRepository() {
        return JugadorRepository.getInstance(emf);
    }

    public PartidoRepository cretePartidoRepository() {
        return PartidoRepository.getInstance(emf);
    }
}

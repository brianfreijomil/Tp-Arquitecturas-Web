package main.practico2;

import main.practico2.Repositories.EquipoRepository;
import main.practico2.Repositories.JugadorRepository;
import main.practico2.Repositories.PartidoRepository;
import main.practico2.Repositories.TorneoRepository;
import main.practico2.entities.Equipo;
import main.practico2.entities.Torneo;

public class TorneoFutbol7 {
    public static void main(String[] args) {
        Factory factory = new Factory();

        //repos
        TorneoRepository torneoService = factory.createTorneoRepository();
        EquipoRepository equipoService = factory.createEquipoRepository();
        JugadorRepository jugadorService = factory.createJugadorRepository();
        PartidoRepository partidoService = factory.cretePartidoRepository();

        /*agrear torneo
        Torneo t = new Torneo("mls");
        torneoService.persist(t);
        se probo y funciono*/

        //agregar equipo
        Torneo tt = torneoService.find(1);
        Equipo e = new Equipo("inter miami","tata martino",tt);
        equipoService.persist(e);
        //se probo y funciono








        factory.closeEMF();
    }
}

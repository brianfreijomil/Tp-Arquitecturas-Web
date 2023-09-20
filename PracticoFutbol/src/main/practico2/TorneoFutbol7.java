package main.practico2;

import main.practico2.Repositories.EquipoRepository;
import main.practico2.Repositories.JugadorRepository;
import main.practico2.Repositories.PartidoRepository;
import main.practico2.Repositories.TorneoRepository;
import main.practico2.entities.Equipo;
import main.practico2.entities.Jugador;
import main.practico2.entities.Torneo;

public class TorneoFutbol7 {
    public static void main(String[] args) {
        Factory factory = new Factory();

        //repos
        TorneoRepository torneoService = factory.createTorneoRepository();
        EquipoRepository equipoService = factory.createEquipoRepository();
        JugadorRepository jugadorService = factory.createJugadorRepository();
        PartidoRepository partidoService = factory.cretePartidoRepository();

        Equipo e = equipoService.find(100);
        Jugador j = jugadorService.find(10);
        e.addJugador(j);










        factory.closeEMF();
    }
}

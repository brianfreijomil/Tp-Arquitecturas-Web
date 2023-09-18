package org.example;

import dto.CarrerasConInscriptosDTO;
import dto.EstudiantesPorCiudad;
import entities.Carrera;
import entities.Estudiante;
import entities.EstudianteCarrera;
import entities.EstudianteCarreraId;
import org.hibernate.type.CharacterArrayClobType;
import repository.CarreraRepository;
import repository.EstudianteCarreraRepository;
import repository.EstudianteRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {

        //factory
        Factory factory = Factory.getInstance();

        //repositories
        CarreraRepository carreraRepository = factory.createCarreraRepository();
        EstudianteRepository estudianteRepository = factory.createEstudianteRepository();
        EstudianteCarreraRepository estudianteCarreraRepository = factory.createEstudianteCarreraRepository();





        //a) dar de alta un estudiante
        //Estudiante estudiante = new Estudiante(43508754,"roberto","baggio",45,"masculino",234567,"Tandil");
        //estudianteRepository.insert(estudiante);

        //b) matricular un estudiante en una carrera
        String carreraBuscada = "tudai";
        Carrera carrera = carreraRepository.selectByName(carreraBuscada);
        Estudiante estudiante = estudianteRepository.selectByNroLibreta(234567);
        EstudianteCarreraId pkEstudianteCarrera = new EstudianteCarreraId(estudiante,carrera);
        EstudianteCarrera matriculacion = new EstudianteCarrera(pkEstudianteCarrera,Timestamp.valueOf(LocalDateTime.now()),false);
        //estudianteCarreraRepository.insert(matriculacion);

        //List<CarrerasConInscriptosDTO> carreras = estudianteCarreraRepository.selectAllCarrerasConInscriptos();

        //for (CarrerasConInscriptosDTO ci: carreras) {
        //        System.out.println(ci.getNombreCarrera()+", "+ci.getId_carrera()+", cant. inscriptos: "+ci.getCount());
        //}

        List<EstudiantesPorCiudad> estudiantes = estudianteCarreraRepository.selectEstudiantesPorCiudad("tandil");

        for (EstudiantesPorCiudad epc: estudiantes) {
                System.out.println("Ciudad: "+ epc.getCiudad());
                System.out.println("Id_estudiante: "+epc.getId_estudiante()+", Nombre: "+
                                    epc.getEstudiante_nombre()+", Apellido: "+epc.getEstudiante_apellido()
                                    +", Carrera"+epc.getCarrera());
        }

        /*c) recuperar todos los estudiantes, y especificar algún criterio de ordenamiento simple.
        //por ahora le pido que venga ordenado por apellido ascendente
        List<Estudiante> estudiantes = estudianteRepository.selectAll();

        //d) recuperar un estudiante, en base a su número de libreta universitaria.
        int legajoBuscado = 123456;
        Estudiante estduantePorLegajo = estudianteRepository.selectByNroLibreta(legajoBuscado);

        //e) recuperar todos los estudiantes, en base a su género.
        String genero = "masculino";
        List<Estudiante> estudiantesXgenero = estudianteRepository.selectByGenre(genero);

        //f) recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos.
        //AVISO ESTO ESTA MAL
        List<ResultSet> carrerasConInscriptos = estudianteCarreraRepository.selectAllCarrerasConInscriptos();
        //El query ya esta hecho pero hay que ver como manejar los datos
        //puede ser con una clase que maneje las dos columnas
        //o talvez hay alguna propiedad de JPQL pra manejarlo


        //g) recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia.
        */
        factory.closeEntityManagerFactory();

    }
}
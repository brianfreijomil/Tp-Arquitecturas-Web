package org.example;

import entities.Carrera;
import entities.Estudiante;
import entities.EstudianteCarrera;
import entities.EstudianteCarreraId;
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
        Estudiante estudiante = new Estudiante(43508754,"Roberto","Baggio",45,"Macho",234567,"Tanndil");
        estudianteRepository.insert(estudiante);

        //b) matricular un estudiante en una carrera
        String carreraBuscada = "Tudai";
        Carrera carrera = carreraRepository.selectByName(carreraBuscada);
        EstudianteCarreraId pkEstudianteCarrera = new EstudianteCarreraId(estudiante,carrera);
        EstudianteCarrera matriculacion = new EstudianteCarrera(pkEstudianteCarrera,Timestamp.valueOf(LocalDateTime.now()),false);

        //c) recuperar todos los estudiantes, y especificar algún criterio de ordenamiento simple.
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
    }
}
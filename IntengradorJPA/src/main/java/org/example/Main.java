package org.example;

import CsvFiles.CsvReader;
import repositories.CarreraRepository;
import repositories.EstudianteCarreraRepository;
import repositories.EstudianteRepository;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {

        //factory
        Factory factory = Factory.getInstance();

        //repositories
        CarreraRepository carreraRepository = factory.createCarreraRepository();
        EstudianteRepository estudianteRepository = factory.createEstudianteRepository();
        EstudianteCarreraRepository estudianteCarreraRepository = factory.createEstudianteCarreraRepository();

        CsvReader csvReader = new CsvReader(carreraRepository,estudianteRepository,estudianteCarreraRepository);







        //a) dar de alta un estudiante
        //Estudiante estudiante = new Estudiante(43508754,"roberto","baggio",45,"masculino",234567,"Tandil");
        //estudianteRepository.insert(estudiante);

        //b) matricular un estudiante en una carrera

        //List<CarrerasConInscriptosDTO> carreras = estudianteCarreraRepository.selectAllCarrerasConInscriptos();

        //for (CarrerasConInscriptosDTO ci: carreras) {
        //        System.out.println(ci.getNombreCarrera()+", "+ci.getId_carrera()+", cant. inscriptos: "+ci.getCount());
        //}

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
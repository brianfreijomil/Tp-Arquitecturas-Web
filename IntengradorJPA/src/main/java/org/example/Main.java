package org.example;

import CsvFiles.CsvReader;
import dto.CarrerasConInscriptosDTO;
import dto.EstudiantesPorCarreraPorCiudadDTO;
import dto.ReporteCarrerasDTO;
import entities.Carrera;
import entities.Estudiante;
import entities.EstudianteCarrera;
import entities.EstudianteCarreraId;
import factory.AbstractFactory;
import repositories.CarreraRepository;
import repositories.EstudianteCarreraRepository;
import repositories.EstudianteRepository;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class Main {

    private static CarreraRepository carreraRepository;
    private static EstudianteRepository estudianteRepository;
    private static EstudianteCarreraRepository estudianteCarreraRepository;

    public static void main(String[] args) throws SQLException, IOException {

        //factory
        //Factory factory = Factory.getInstance();
        AbstractFactory postgresFactory = AbstractFactory.getDAOFactory(AbstractFactory.POSTGRESQL_DB);

        carreraRepository = postgresFactory.createCarreraRepository();
        estudianteRepository = postgresFactory.createEstudianteRepository();
        estudianteCarreraRepository = postgresFactory.createEstudianteCarreraRepository();
        //repositories
        //actory.createCarreraRepository();
        //EstudianteRepository estudianteRepository = factory.createEstudianteRepository();
        //EstudianteCarreraRepository estudianteCarreraRepository = factory.createEstudianteCarreraRepository();



        //poblando tablas
        CsvReader csvReader = new CsvReader(carreraRepository,estudianteRepository,estudianteCarreraRepository);


        //Ejercicios
        /*------------------------------------------------------------------------------------------------------*/
        //a) dar de alta un estudiante
        Estudiante e = new Estudiante(42708154,"Brian alex","Freijomil",23,"Male",250441,"tandil");
        estudianteRepository.createEstudiante(e);
        //show
        System.out.println("a) dar de alta un estudiante");
        System.out.println(estudianteRepository.selectEstudianteByDNI(42708154));

        /*------------------------------------------------------------------------------------------------------*/
        //b) matricular un estudiante en una carrera
        //por ejemplo quiero matricular a brian en TUDAI
        //busco carrera
        Carrera c = carreraRepository.selectCarreraByName("TUDAI");
        EstudianteCarreraId pkMatricula = new EstudianteCarreraId(e,c); //pk de matriculacion
        Timestamp inscripcion = Timestamp.valueOf(LocalDateTime.now()); //fecha inscripcion
        EstudianteCarrera matricula = new EstudianteCarrera(pkMatricula,inscripcion,null,1);
        estudianteCarreraRepository.createEstudianteCarrera(matricula);
        //show
        System.out.println("-----------------------------------------------------------------------------------------------");
        System.out.println("b) matricular un estudiante en una carrera");
        System.out.println(estudianteCarreraRepository.selectEstudianteCarreraById(matricula.getId()));

        /*------------------------------------------------------------------------------------------------------*/
        //c) recuperar todos los estudiantes, y especificar algún criterio de ordenamiento simple.
        //el criterio de ord en este ejemplo es por apellido ASCENDENTE
        List<Estudiante> estudiantesPorApll = estudianteRepository.selectAllEstudianteOrdApellido();
        //show
        System.out.println("-----------------------------------------------------------------------------------------------");
        System.out.println("c) recuperar todos los estudiantes, y especificar algún criterio de ordenamiento simple.");
        System.out.println("Criterio de Ord: Apellido DESC");
        for (Estudiante ePorApll : estudiantesPorApll) {
            System.out.println(ePorApll);
        }

        /*------------------------------------------------------------------------------------------------------*/
        //d) recuperar un estudiante, en base a su número de libreta universitaria.
        //ejemplo
        int LU = 250441;
        Estudiante ePorLegajo = estudianteRepository.selectEstudianteByNroLibreta(LU);
        //show
        System.out.println("-----------------------------------------------------------------------------------------------");
        System.out.println("d) recuperar un estudiante, en base a su número de libreta universitaria.");
        System.out.println(ePorLegajo);

        /*------------------------------------------------------------------------------------------------------*/
        //e) recuperar todos los estudiantes, en base a su género.
        String genero = "Female"; //ejemplo
        List<Estudiante> estudiantesXgenero = estudianteRepository.selectAllEstudianteByGenero(genero);
        //show
        System.out.println("-----------------------------------------------------------------------------------------------");
        System.out.println("e) recuperar todos los estudiantes, en base a su género.");
        System.out.println("Genero: "+genero);
        for (Estudiante ePorGenero : estudiantesXgenero) {
            System.out.println(ePorGenero);
        }

        /*------------------------------------------------------------------------------------------------------*/
        //f) recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos.
        List<CarrerasConInscriptosDTO> carrerasInscriptos = estudianteCarreraRepository.selectAllCarrerasConInscriptos();
        //show
        System.out.println("-----------------------------------------------------------------------------------------------");
        System.out.println("f) recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos.");
        for (CarrerasConInscriptosDTO ci: carrerasInscriptos) {
            System.out.println(ci);
        }

        /*------------------------------------------------------------------------------------------------------*/
        //g) recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia.
        String ciudadFiltro = "Rauch";
        String carreraDeterminada = "TUDAI";
        List<EstudiantesPorCarreraPorCiudadDTO> estudiantesFiltrados =
                estudianteCarreraRepository.selectEstudiantesPorCarreraByCiudad(carreraDeterminada,ciudadFiltro);
        //show
        System.out.println("-----------------------------------------------------------------------------------------------");
        System.out.println("g) recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia.");
        System.out.println("Carrera Determinada: "+carreraDeterminada+", ciudad de residencia: "+ciudadFiltro);
        for (EstudiantesPorCarreraPorCiudadDTO ecc: estudiantesFiltrados) {
            System.out.println(ecc.getId_estudiante()+", "+ecc.getEstudiante_nombre()+", "+ecc.getEstudiante_apellido()+", "+ecc.getCarrera()+", "+ecc.getCiudad());
        }

        /*------------------------------------------------------------------------------------------------------*/
        //3) Generar un reporte de las carreras, que para cada carrera incluya información de los
        //inscriptos y egresados por año. Se deben ordenar las carreras alfabéticamente, y presentar
        //los años de manera cronológica.*/

        List<ReporteCarrerasDTO> reporteCarreras = estudianteCarreraRepository.selectInscriptosYEgresadosPorAnio();
        System.out.println("-----------------------------------------------------------------------------------------------");
        System.out.println("3) Generar un reporte de las carreras, que para cada carrera incluya información de los\n" +
                " inscriptos y egresados por año. Se deben ordenar las carreras alfabéticamente, y presentar\n" +
                " los años de manera cronológica.");
        for (ReporteCarrerasDTO reporte: reporteCarreras) {
            System.out.println(reporte);
        }

        //Cierro Entity Manager Factory
        postgresFactory.closeEntityManagerFactory();
    }
}
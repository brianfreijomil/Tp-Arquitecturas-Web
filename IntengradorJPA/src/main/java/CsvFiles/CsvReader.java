package CsvFiles;

import entities.Carrera;
import entities.Estudiante;
import entities.EstudianteCarrera;
import entities.EstudianteCarreraId;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import repositories.CarreraRepository;
import repositories.EstudianteCarreraRepository;
import repositories.EstudianteRepository;

import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;

public class CsvReader {
    private CarreraRepository carreraRepository;
    private EstudianteRepository estudianteRepository;
    private EstudianteCarreraRepository estudianteCarreraRepository;
    private static final String userDir = System.getProperty("user.dir") + "/src/main/java/CsvFiles/";

    public CsvReader(CarreraRepository cr, EstudianteRepository er, EstudianteCarreraRepository ecr) throws IOException, SQLException {
        this.carreraRepository=cr;
        this.estudianteRepository=er;
        this.estudianteCarreraRepository=ecr;
        this.loadCarrera();
        this.loadEstudiante();
        this.loadEstudianteCarreraRepository();
    }

    private void loadCarrera() throws IOException, SQLException {
        CSVParser parser = CSVFormat.DEFAULT.withHeader().parse(new
                FileReader(userDir + "carreras.csv"));
        for (CSVRecord row : parser) {
            long id = Long.parseLong(row.get("id_carrera"));
            String nombre = String.valueOf(row.get("carrera"));
            Integer duracion = Integer.valueOf(row.get("duracion"));
            Carrera c = new Carrera(id,nombre,duracion);
            carreraRepository.createCarrera(c);
        }
    }

    private void loadEstudiante() throws IOException, SQLException {
        CSVParser parser = CSVFormat.DEFAULT.withHeader().parse(new
                FileReader(userDir + "estudiantes.csv"));
        for (CSVRecord row : parser) {
            int dni = Integer.valueOf(row.get("DNI"));
            String nombre = row.get("nombre");
            String apellido = row.get("apellido");
            int edad = Integer.valueOf(row.get("edad"));
            String genero = row.get("genero");
            String ciudad = row.get("ciudad");
            int lu = Integer.valueOf(row.get("LU"));
            Estudiante e = new Estudiante(dni,nombre,apellido,edad,genero,lu,ciudad);
            estudianteRepository.createEstudiante(e);
        }
    }


    private void loadEstudianteCarreraRepository() throws IOException, SQLException {
        CSVParser parser = CSVFormat.DEFAULT.withHeader().parse(new
                FileReader(userDir + "estudianteCarrera.csv"));
        for (CSVRecord row : parser) {
            Integer idEstudiante = Integer.valueOf(row.get("id_estudiante"));
            Integer idCarrera = Integer.valueOf(row.get("id_carrera"));
            String inscripcion = row.get("inscripcion");
            String graduacion = row.get("graduacion");
            Integer antiguedad = Integer.valueOf(row.get("antiguedad"));
            //busco el estudiante y la carrera por sus id
            Estudiante e = estudianteRepository.selectEstudianteById(idEstudiante);
            Carrera c = carreraRepository.selectCarreraById(idCarrera);
            //creo la pk para EstudianteCarrera
            EstudianteCarreraId pk = new EstudianteCarreraId(e,c);
            //instancia

            String fechaInscripcion = inscripcion+"-12-31 23:59:59";
            String fechagraduacion = graduacion+"-12-31 00:00:00";
            EstudianteCarrera ec = new EstudianteCarrera(pk,Timestamp.valueOf(fechaInscripcion),Timestamp.valueOf(fechagraduacion),antiguedad);
            estudianteCarreraRepository.createEstudianteCarrera(ec);
        }

    }
}

package CsvFiles;

import entities.Carrera;
import entities.Estudiante;
import entities.EstudianteCarrera;
import entities.EstudianteCarreraId;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import repository.CarreraRepository;
import repository.EstudianteCarreraRepository;
import repository.EstudianteRepository;

import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

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
            String nombre = String.valueOf(row.get("carrera"));
            Integer duracion = Integer.valueOf(row.get("duracion"));
            Carrera c = new Carrera(nombre,duracion);
            carreraRepository.insert(c);
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
            estudianteRepository.insert(e);
        }
    }


    private void loadEstudianteCarreraRepository() throws IOException, SQLException {
        /*CSVParser parser = CSVFormat.DEFAULT.withHeader().parse(new
                FileReader(userDir + "productos.csv"));
        for (CSVRecord row : parser) {
            Integer idEstudiante = Integer.valueOf(row.get("id_estudiante"));
            Integer idCarrera = Integer.valueOf(row.get("id_carrera"));
            String inscripcion = row.get("inscripcion");
            String graduacion = row.get("graduacion");
            Integer antiguedad = Integer.valueOf(row.get("antiguedad"));
            EstudianteCarreraId pk = new EstudianteCarreraId();
            EstudianteCarrera ec = new EstudianteCarrera();
            estudianteCarreraRepository.insert(ec);
        }*/

    }
}

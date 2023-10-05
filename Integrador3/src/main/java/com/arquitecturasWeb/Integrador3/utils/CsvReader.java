package com.arquitecturasWeb.Integrador3.utils;

import com.arquitecturasWeb.Integrador3.domain.Career;
import com.arquitecturasWeb.Integrador3.domain.Student;
import com.arquitecturasWeb.Integrador3.domain.StudentCareer;
import com.arquitecturasWeb.Integrador3.domain.StudentCareerId;
import com.arquitecturasWeb.Integrador3.repositories.CareerRepository;
import com.arquitecturasWeb.Integrador3.repositories.StudentCareerRepository;
import com.arquitecturasWeb.Integrador3.repositories.StudentRepository;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;

@Component
public class CsvReader {
    private CareerRepository carrerRepository;
    private StudentRepository studentRepository;
    private StudentCareerRepository studentCareerRepository;
    private static final String userDir = System.getProperty("user.dir") + "/src/main/java/com/arquitecturasWeb/integrador3/utils/";

    public CsvReader(CareerRepository cr, StudentRepository er, StudentCareerRepository ecr){
        this.carrerRepository=cr;
        this.studentRepository=er;
        this.studentCareerRepository=ecr;
    }

    public void load() throws SQLException, IOException {
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
            Career c = new Career(id,nombre,duracion);
            carrerRepository.save(c);
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
            Student e = new Student(dni, lu, apellido, nombre, edad, genero, ciudad);
            studentRepository.save(e);
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
            Student e = studentRepository.findByDNI(idEstudiante).get();
            Career c = carrerRepository.findById(idCarrera.longValue()).get();
            //creo la pk para EstudianteCarrera
            StudentCareerId pk = new StudentCareerId(c,e);
            //instancia
            String fechaInscripcion = inscripcion+"-01-01 00:00:00";
            StudentCareer ec;
            if(graduacion.equals("0000")){ //no se graduo
                ec = new StudentCareer(pk, Timestamp.valueOf(fechaInscripcion),null,antiguedad);
            }
            else {
                String fechagraduacion = graduacion+"-01-01 00:00:00";
                ec = new StudentCareer(pk,Timestamp.valueOf(fechaInscripcion),Timestamp.valueOf(fechagraduacion),antiguedad);
            }
            studentCareerRepository.save(ec);
        }

    }
}
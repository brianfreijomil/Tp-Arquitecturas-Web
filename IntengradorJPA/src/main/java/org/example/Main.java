package org.example;

import entities.Carrera;
import entities.Estudiante;
import entities.EstudianteCarrera;
import entities.EstudianteCarreraId;
import repository.CarreraRepository;
import repository.EstudianteCarreraRepository;
import repository.EstudianteRepository;

import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws SQLException {

        //factory
        Factory factory = Factory.getInstance();

        //repositories
        CarreraRepository carreraRepository = factory.createCarreraRepository();
        EstudianteRepository estudianteRepository = factory.createEstudianteRepository();
        EstudianteCarreraRepository estudianteCarreraRepository = factory.createEstudianteCarreraRepository();

        //FALTARIA INSERTAR TODOS LOS DATOS DE LA TABLA ESTUDIANTE_CARRERA EN BASE A
        //LOS ESTUDIANTES QUE HAY CARGADOS
        //HAY QUE TRAER TODOS LOS ESTUDIANTES , TRAER LAS CARRERAS A LOS QUE LAS QUERES MATRICULAR ETC ETC

    }
}
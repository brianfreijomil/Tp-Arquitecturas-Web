package org.example;

import entities.Carrera;
import entities.Estudiante;
import entities.EstudianteCarrera;
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

        //Carreras
        ArrayList<Carrera> carreras = new ArrayList<>();
        Carrera c1 = new Carrera("Tudai", 3);
        Carrera c2 = new Carrera("Ingeniería en sistemas", 5);
        Carrera c3 = new Carrera("Historia", 5);
        Carrera c4 = new Carrera("Contador público", 4);
        Carrera c5 = new Carrera("Admin. de empresas", 4);
        Carrera c6 = new Carrera("Veterinaria", 5);
        Carrera c7 = new Carrera("Relacion internacionales", 4);
        Carrera c8 = new Carrera("Geografía", 4);
        Carrera c9 = new Carrera("Profesorado de matematica",5);
        Carrera c10 = new Carrera("Profesorado de fisica", 5);
        Carrera c11 = new Carrera("Profesorado de Ed. Fisica", 4);
        Carrera c12 = new Carrera("Medicina", 6);
        Carrera c13 = new Carrera("Diplomatura en UX/UI", 1);
        carreras.add(c1);carreras.add(c5);carreras.add(c6);carreras.add(c4);
        carreras.add(c2);carreras.add(c4);carreras.add(c7);carreras.add(c8);
        carreras.add(c12);carreras.add(c11);carreras.add(c10);carreras.add(c13);

        //Estudiantes
        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        Estudiante e1 = new Estudiante(43511155,"Lucas Roman", "Amendola", 22, "no binarie", 251157, "tandil");
        Estudiante e2 = new Estudiante(43123654,"Jose", "Lopez", 22, "masculino", 251156, "tandil");
        Estudiante e3 = new Estudiante(43098567,"Bruno", "Montero", 22, "masculino", 251155, "tandil");
        Estudiante e4 = new Estudiante(43345910,"Micaela", "Espindola", 22, "femenino", 251154, "tandil");
        Estudiante e5 = new Estudiante(43346971,"Martina", "Acevedo", 22, "femenino", 251153, "tandil");
        Estudiante e6 = new Estudiante(43009345,"Camila", "Jauregui", 22, "femenino", 251152, "tandil");
        Estudiante e7 = new Estudiante(43561309,"Alberto", "Fernandez", 22, "masculino", 251151, "tandil");
        Estudiante e8 = new Estudiante(42567001,"Tobias", "Palacios", 22, "masculino", 251159, "tandil");
        estudiantes.add(e1);estudiantes.add(e2);estudiantes.add(e3);estudiantes.add(e4);
        estudiantes.add(e5);estudiantes.add(e6);estudiantes.add(e7);estudiantes.add(e8);
        //Insercion de estudiantes
        //Lucas Amendola, fecha Ahora mismo, Tudai, no graduado
        EstudianteCarrera m1 = new EstudianteCarrera(Timestamp.valueOf(LocalDateTime.now()), c1, e1, false);
        EstudianteCarrera m2 = new EstudianteCarrera(Timestamp.valueOf(LocalDateTime.now()), c2, e2, false);
        EstudianteCarrera m3 = new EstudianteCarrera(Timestamp.valueOf(LocalDateTime.now()), c3, e3, false);
        EstudianteCarrera m4 = new EstudianteCarrera(Timestamp.valueOf(LocalDateTime.now()), c4, e4, false);
        EstudianteCarrera m5 = new EstudianteCarrera(Timestamp.valueOf(LocalDateTime.now()), c5, e5, false);
        EstudianteCarrera m6 = new EstudianteCarrera(Timestamp.valueOf(LocalDateTime.now()), c6, e6, false);
        EstudianteCarrera m7 = new EstudianteCarrera(Timestamp.valueOf(LocalDateTime.now()), c7, e7, false);
        EstudianteCarrera m8 = new EstudianteCarrera(Timestamp.valueOf(LocalDateTime.now()), c8, e8, false);

        //pruebas

        //agrego carreras
        for (Carrera carr : carreras) {
            carreraRepository.insert(carr);
        }
        //agreo estudiantes
        for (Estudiante estud : estudiantes) {
            estudianteRepository.insert(estud);
        }
        //los matriculo
        estudianteCarreraRepository.insert(m1);
        estudianteCarreraRepository.insert(m2);
        estudianteCarreraRepository.insert(m3);
        estudianteCarreraRepository.insert(m4);
        estudianteCarreraRepository.insert(m5);
        estudianteCarreraRepository.insert(m6);
        estudianteCarreraRepository.insert(m7);
        estudianteCarreraRepository.insert(m8);




    }
}
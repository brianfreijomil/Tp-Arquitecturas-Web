package org.example;

import entities.Carrera;
import entities.Estudiante;
import repository.CarreraRepository;
import repository.EstudianteRepository;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

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

        Factory factory = Factory.getInstance();

        CarreraRepository carreraRepository = factory.createCarreraRepository();
        EstudianteRepository estudianteRepository = factory.createEstudianteRepository();

        Estudiante e1 = new Estudiante(43511155,"Lucas Roman", "Amendola", 22, "masculino", 251157, "tandil", c1);
        //e1.addCarrera(c1);

        //carreraRepository.selectAll();
        estudianteRepository.selectAll();
    }
}
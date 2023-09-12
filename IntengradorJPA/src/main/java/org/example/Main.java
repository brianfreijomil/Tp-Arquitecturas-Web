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
        Estudiante e2 = new Estudiante(43123654,"Jose", "Lopez", 22, "masculino", 251156, "tandil", c1);
        Estudiante e3 = new Estudiante(43098567,"Bruno", "Montero", 22, "masculino", 251155, "tandil", c1);
        Estudiante e4 = new Estudiante(43345910,"Micaela", "Espindola", 22, "femenino", 251154, "tandil", c1);
        Estudiante e5 = new Estudiante(43346971,"Martina", "Acevedo", 22, "femenino", 251153, "tandil", c1);
        Estudiante e6 = new Estudiante(43009345,"Camila", "Jauregui", 22, "femenino", 251152, "tandil", c1);
        Estudiante e7 = new Estudiante(43561309,"Alberto", "Fernandez", 22, "masculino", 251151, "tandil", c1);
        Estudiante e8 = new Estudiante(42567001,"Tobias", "Palacios", 22, "masculino", 251159, "tandil", c1);

        estudianteRepository.selectByGenre("masculino");
    }
}
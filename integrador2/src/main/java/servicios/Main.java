package servicios;

import entities.Ciudad;
import entities.Estudiante;

public class Main {
    public static void main(String[]args){

        Ciudad tandil = new Ciudad(7000,"Tandil");
        Estudiante e1 = new Estudiante(43511155,"Lucas","Amendola",22,125670, tandil);

        EstudianteSV es = new EstudianteSV();

        es.insert(e1);
    }
}
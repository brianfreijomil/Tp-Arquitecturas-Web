package com.arquitecturasWeb.Integrador3.service.DTOs.Student.Response;

import com.arquitecturasWeb.Integrador3.domain.Student;

public class StudentResponseDTO {
    private final int dni;
    private final int lu;
    private final String lastName;
    private final String name;
    private final int age;
    private final String genre;
    private final String city;

    public StudentResponseDTO(Student s){
        this.dni = s.getDNI();
        this.lu = s.getLu();
        this.lastName = s.getLastName();
        this.name = s.getName();
        this.age = s.getAge();
        this.genre = s.getGenre();
        this.city = s.getCity();
    }

}

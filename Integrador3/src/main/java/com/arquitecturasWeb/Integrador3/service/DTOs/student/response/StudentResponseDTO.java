package com.arquitecturasWeb.Integrador3.service.DTOs.student.response;

import com.arquitecturasWeb.Integrador3.domain.Student;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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

package com.arquitecturasWeb.Integrador3.domain;

import com.arquitecturasWeb.Integrador3.service.DTOs.Student.Request.StudentRequestDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Student {

    @Id
    private int DNI;
    @Column
    private int lu;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String name;
    @Column
    private int age;
    @Column(nullable = true)
    private String genre;
    @Column(nullable = false)
    private String city;

    public Student(StudentRequestDTO request) {
        super();
        this.DNI = request.getDNI();
        this.name = request.getName();
        this.lastName = request.getLastName();
        this.age = request.getAge();
        this.genre = request.getGenre();
        this.lu = request.getLu();
        this.city = request.getCity();
    }
}

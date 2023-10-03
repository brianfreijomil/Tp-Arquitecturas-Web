package com.arquitecturasWeb.Integrador3.service.DTOs.Student.Response;

import lombok.NoArgsConstructor;
public class StudenResponseDTO {
    private final int dni;
    private final int book_number;
    private final String surname;
    private final String name;
    private final int age;
    private final String gender;
    private final String city;

    public StudenResponseDTO(Student s){
        this.dni = s.getDNI();
        this.book_number = s.getBook_number();
        this.surname = s.getSurname();
        this.name = s.getName();
        this.age = s.getAge();
        this.gender = s.getGender();
        this.city = s.getCity();
    }

}

package com.arquitecturasWeb.Integrador3.service.DTOs.studentCareer.response;

import lombok.Data;

import java.math.BigInteger;

@Data
public class CareerWithStudentsResponseDTO {

    private final String name;
    private final Long cantStudents;
    private final Long id;

    public CareerWithStudentsResponseDTO(String name, Long id, Long cantStudents) {
        this.name = name;
        this.cantStudents = cantStudents;
        this.id = id;
    }
}

package com.arquitecturasWeb.Integrador3.service.DTOs.studentCareer.response;

import lombok.Data;

@Data
public class StudentsOfCareerByCityResponseDTO {
    private final String city;
    private final int studentId;
    private final String studentName;
    private final String studentSurname;
    private final String career;

    public StudentsOfCareerByCityResponseDTO(int studentId, String studentName, String studentSurname, String career, String city) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentSurname = studentSurname;
        this.career = career;
        this.city = city;
    }
}

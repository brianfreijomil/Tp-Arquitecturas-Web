package com.arquitecturasWeb.Integrador3.service.DTOs.studentCareer.response;

import com.arquitecturasWeb.Integrador3.domain.StudentCareer;
import com.arquitecturasWeb.Integrador3.service.DTOs.studentCareerId.response.StudentCareerIdResponseDTO;

import java.sql.Timestamp;

public class StudentCareerResponseDTO {
    private final StudentCareerIdResponseDTO id;
    private final Timestamp inscription;
    private final Timestamp graduation;
    private final int antiquity;

    public StudentCareerResponseDTO(StudentCareer s) {
        this.id = new StudentCareerIdResponseDTO(s.getId());
        this.inscription = s.getInscription();
        this.graduation = s.getGraduation();
        this.antiquity = s.getAntiquity();
    }
}

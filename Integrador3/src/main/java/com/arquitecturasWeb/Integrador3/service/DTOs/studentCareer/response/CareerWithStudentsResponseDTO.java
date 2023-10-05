package com.arquitecturasWeb.Integrador3.service.DTOs.studentCareer.response;

import lombok.Data;

@Data
public class CareerWithStudentsResponseDTO {
    private final String careerName;
    private final long studentsCount;
    private final long careerId;

    public CareerWithStudentsResponseDTO(String careerName, long careerId, long studentsCount) {
        this.careerName = careerName;
        this.studentsCount = studentsCount;
        this.careerId = careerId;
    }
}

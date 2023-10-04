package com.arquitecturasWeb.Integrador3.service.DTOs.studentCareer.response;

import com.arquitecturasWeb.Integrador3.service.DTOs.studentCareer.request.CareerWithStudentsRequestDTO;

public class CareerWithStudentsResponseDTO {
    private final CareerWithStudentsRequestDTO crpDTO;
    private final String careerName;
    private final long studentsCount;
    private final long careerId;

    public CareerWithStudentsResponseDTO(String careerName, long careerId, long studentsCount, CareerWithStudentsRequestDTO crpDTO) {
        this.careerName = careerName;
        this.studentsCount = studentsCount;
        this.careerId = careerId;
        this.crpDTO = crpDTO;
    }
}

package com.arquitecturasWeb.Integrador3.service.DTOs.studentCareer.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class StudentsOfCareerByCityRequestDTO {
    @NotNull(message = "The id cannot be null")
    private final StudentsOfCareerByCityRequestDTO socbcRqDTO;
    @NotNull(message = "The id cannot be null")
    private final String city;
    @NotNull(message = "The id cannot be null")
    private final int studentId;
    @NotNull(message = "The id cannot be null")
    private final String studentName;
    @NotNull(message = "The id cannot be null")
    private final String studentSurname;
    @NotNull(message = "The id cannot be null")
    private final String career;
}

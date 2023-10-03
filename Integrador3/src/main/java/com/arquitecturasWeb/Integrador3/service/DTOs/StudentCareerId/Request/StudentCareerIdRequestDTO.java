package com.arquitecturasWeb.Integrador3.service.DTOs.StudentCareerId.Request;

import com.arquitecturasWeb.Integrador3.service.DTOs.Career.Request.CareerRequestDTO;
import com.arquitecturasWeb.Integrador3.service.DTOs.Student.Request.StudentRequestDTO;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class StudentCareerIdRequestDTO {
    @NotNull(message = "The career cannot be null")
    private final CareerRequestDTO career;
    @NotNull(message = "The student cannot be null")
    private final StudentRequestDTO student;
}

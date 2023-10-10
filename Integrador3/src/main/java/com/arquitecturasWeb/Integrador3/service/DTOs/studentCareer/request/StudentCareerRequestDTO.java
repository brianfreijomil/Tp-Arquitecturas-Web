package com.arquitecturasWeb.Integrador3.service.DTOs.studentCareer.request;

import com.arquitecturasWeb.Integrador3.service.DTOs.studentCareerId.request.StudentCareerIdRequestDTO;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;

@Data
@RequiredArgsConstructor
public class StudentCareerRequestDTO {
    @NotNull(message = "The id cannot be null")
    private final Long career_id;
    @NotNull(message = "The inscription cannot be null")
    private final Long inscription;
    private final Long graduation;
    @NotNull(message = "The antiquity cannot be null")
    private final Integer antiquity;
}

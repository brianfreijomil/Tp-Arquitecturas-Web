package com.arquitecturasWeb.Integrador3.service.DTOs.StudentCareer.Request;

import com.arquitecturasWeb.Integrador3.service.DTOs.StudentCareerId.Request.StudentCareerIdRequestDTO;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;

@Data
@RequiredArgsConstructor
public class StudentCareerRequestDTO {
    @NotNull(message = "The id cannot be null")
    private final StudentCareerIdRequestDTO id;
    @NotNull(message = "The inscription cannot be null")
    private final Timestamp inscription;
    @NotNull(message = "The graduation cannot be null")
    private final Timestamp graduation;
    @NotNull(message = "The antiquity cannot be null")
    private final int antiquity;
}

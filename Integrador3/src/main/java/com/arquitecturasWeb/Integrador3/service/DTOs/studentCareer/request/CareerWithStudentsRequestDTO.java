package com.arquitecturasWeb.Integrador3.service.DTOs.studentCareer.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CareerWithStudentsRequestDTO {
    @NotNull(message = "The id cannot be null")
    private final CareerWithStudentsRequestDTO crpDTO;
    @NotNull(message = "The id cannot be null")
    private final String careerName;
    @NotNull(message = "The id cannot be null")
    private final long studentsCount;
    @NotNull(message = "The id cannot be null")
    private final long careerId;
}

package com.arquitecturasWeb.Integrador3.service.DTOs.career.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class CareerRequestDTO {
    @Min(value = 0, message = "ID must be greater than 0")
    @NotNull(message = "ID cannot be null")
    private final Long id;
    @NotNull(message = "the name cannot be null")
    @NotEmpty(message = "the name cannot be empty")
    private final String name;
    @Min(value = 0, message = "Duration must be greater than 0")
    @NotNull(message = "Duration cannot be null")
    private final Integer duration;
}

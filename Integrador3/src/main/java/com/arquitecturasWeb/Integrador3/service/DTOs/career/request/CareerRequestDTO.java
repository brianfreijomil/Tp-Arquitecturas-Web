package com.arquitecturasWeb.Integrador3.service.DTOs.career.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class CareerRequestDTO {
    @NotNull(message = "the id cannot be null")
    private final Long id;
    @NotNull(message = "the name cannot be null")
    @NotEmpty(message = "the name cannot be empty")
    private final String name;
    @NotNull(message = "the name cannot be null")
    private final int duration;
}

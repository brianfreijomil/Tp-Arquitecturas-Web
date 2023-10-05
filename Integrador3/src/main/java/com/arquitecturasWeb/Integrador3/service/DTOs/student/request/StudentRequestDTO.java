package com.arquitecturasWeb.Integrador3.service.DTOs.student.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class StudentRequestDTO {
    @Min(value = 1, message ="DNI should not be less than 1")
    private final int DNI;
    @Min(value = 1, message ="lu should not be less than 1")
    private final int lu;
    @NotNull(message = "the lastName cannot be null")
    @NotEmpty(message = "the lastName cannot be empty")
    private final String lastName;
    @NotNull(message = "the name cannot be null")
    @NotEmpty(message = "the name cannot be empty")
    private final String name;
    @NotNull(message = "the age cannot be null")
    @Min(value = 16, message ="Age should not be less than 16")
    @Max(value = 99, message ="Age should not be greater than 99")
    private final int age;
    @NotNull(message = "the genre cannot be null")
    @NotEmpty(message = "the genre cannot be empty")
    private final String genre;
    @NotNull(message = "the city cannot be null")
    @NotEmpty(message = "the city cannot be empty")
    private final String city;
}

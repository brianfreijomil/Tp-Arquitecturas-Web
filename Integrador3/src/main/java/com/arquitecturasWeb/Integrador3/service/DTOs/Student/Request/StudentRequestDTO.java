package com.arquitecturasWeb.Integrador3.service.DTOs.Student.Request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class StudentRequestDTO {
    @NotNull(message = "the DNI cannot be null")
    private final int DNI;
    @NotNull(message = "the lu cannot be null")
    private final int lu;
    @NotNull(message = "the lastName cannot be null")
    @NotEmpty(message = "the lastName cannot be empty")
    private final String lastName;
    @NotNull(message = "the name cannot be null")
    @NotEmpty(message = "the name cannot be empty")
    private final String name;
    @NotNull(message = "the age cannot be null")
    private final int age;
    @NotNull(message = "the genre cannot be null")
    @NotEmpty(message = "the genre cannot be empty")
    private final String genre;
    @NotNull(message = "the city cannot be null")
    @NotEmpty(message = "the city cannot be empty")
    private final String city;
}

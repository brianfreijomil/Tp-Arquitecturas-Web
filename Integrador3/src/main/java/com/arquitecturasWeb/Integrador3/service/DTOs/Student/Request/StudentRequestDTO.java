package com.arquitecturasWeb.Integrador3.service.DTOs.Student.Request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class StudentRequestDTO {
    @NotNull(message = "the dni cannot be null")
    private final int dni;
    @NotNull(message = "the book_number cannot be null")
    private final int book_number;
    @NotNull(message = "the surname cannot be null")
    @NotEmpty(message = "the surname cannot be empty")
    private final String surname;
    @NotNull(message = "the name cannot be null")
    @NotEmpty(message = "the name cannot be empty")
    private final String name;
    @NotNull(message = "the age cannot be null")
    private final int age;
    @NotNull(message = "the gender cannot be null")
    @NotEmpty(message = "the gender cannot be empty")
    private final String gender;
    @NotNull(message = "the city cannot be null")
    @NotEmpty(message = "the city cannot be empty")
    private final String city;
}

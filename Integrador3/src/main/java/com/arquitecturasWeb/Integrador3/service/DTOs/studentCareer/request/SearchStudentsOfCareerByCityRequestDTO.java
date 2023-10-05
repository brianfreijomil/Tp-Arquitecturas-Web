package com.arquitecturasWeb.Integrador3.service.DTOs.studentCareer.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SearchStudentsOfCareerByCityRequestDTO {

    @NotNull(message = "the city cannot be null")
    @NotEmpty(message = "the city cannot be empty")
    private String city;

    @NotNull(message = "the city cannot be null")
    @NotEmpty(message = "the city cannot be empty")
    private String nameCareer;
}

package com.arquitecturasWeb.Integrador3.service.DTOs.Searchs;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@ToString
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
    private String career;
}

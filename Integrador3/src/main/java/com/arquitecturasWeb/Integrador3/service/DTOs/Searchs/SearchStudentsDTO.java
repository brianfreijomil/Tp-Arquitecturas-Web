package com.arquitecturasWeb.Integrador3.service.DTOs.Searchs;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;
import lombok.Getter;

@Data
@AllArgsConstructor
public class SearchStudentsDTO {
    private Integer DNI;
    private Integer lu;
    private String lastName;
    private String name;
    private Integer age;
    private String genre;
    private String city;

}

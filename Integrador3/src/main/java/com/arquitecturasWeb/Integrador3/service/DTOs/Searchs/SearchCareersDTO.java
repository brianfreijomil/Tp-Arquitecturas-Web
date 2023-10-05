package com.arquitecturasWeb.Integrador3.service.DTOs.Searchs;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SearchCareersDTO {
    private Long id;
    private String name;
    private Integer duration;
}

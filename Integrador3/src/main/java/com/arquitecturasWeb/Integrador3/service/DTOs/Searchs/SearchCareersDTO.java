package com.arquitecturasWeb.Integrador3.service.DTOs.Searchs;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SearchCareersDTO {
    private long id;
    private String name;
    private int duration;
}

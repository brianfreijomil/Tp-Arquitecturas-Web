package com.arquitecturasWeb.Integrador3.service.DTOs.career.response;

import com.arquitecturasWeb.Integrador3.domain.Career;
import lombok.Data;

@Data
public class CareerResponseDTO {
    private final Long id;
    private final String name;
    private final int duration;

    public CareerResponseDTO(Career c) {
        this.id = c.getId();
        this.name = c.getName();
        this.duration = c.getDuration();
    }
}

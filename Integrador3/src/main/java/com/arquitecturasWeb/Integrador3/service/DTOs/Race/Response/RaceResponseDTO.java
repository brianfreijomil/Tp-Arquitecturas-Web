package com.arquitecturasWeb.Integrador3.service.DTOs.Race.Response;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class RaceResponseDTO {

    private final Long id;
    private final String name;
    private final int duration;

    public RaceResponseDTO(Race r) {
        this.id = r.getId();
        this.name = r.getName();
        this.duration = r.getDuration();
    }
}

package com.arquitecturasWeb.Integrador3.domain;

import com.arquitecturasWeb.Integrador3.service.DTOs.Career.Request.CareerRequestDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Career {

    @Id
    private long id;
    @Column(nullable = false)
    private String name;
    @Column(name = "duration_years")
    private int duration;

    public Career(CareerRequestDTO request) {
        super();
        this.id = request.getId();
        this.name = request.getName();
        this.duration = request.getDuration();
    }
}
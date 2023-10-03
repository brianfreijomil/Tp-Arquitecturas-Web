package com.arquitecturasWeb.Integrador3.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
public class StudentCareer {
    @EmbeddedId
    private StudentCareerId id;
    @Column(nullable = false)
    private Timestamp inscription;
    @Column(nullable = true)
    private Timestamp graduation;
    @Column
    private int antiquity;

    public StudentCareer(StudentCareerRequestDTO request) {
        super();
        this.id = request.getId();
        this.inscription = request.getInscription();
        this.graduation = request.getGraduation();
        this.antiquity = request.getAntiquity();
    }

}

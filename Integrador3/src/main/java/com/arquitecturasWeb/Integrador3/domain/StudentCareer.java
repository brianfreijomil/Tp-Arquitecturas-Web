package com.arquitecturasWeb.Integrador3.domain;

import com.arquitecturasWeb.Integrador3.service.DTOs.studentCareer.request.StudentCareerRequestDTO;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
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

    public StudentCareer(StudentCareerId id, Timestamp inscription, Timestamp graduation, int antiquity) {
        super();
        this.id = id;
        this.inscription = inscription;
        this.graduation = graduation;
        this.antiquity = antiquity;
    }

}

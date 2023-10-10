package com.arquitecturasWeb.Integrador3.domain;

import com.arquitecturasWeb.Integrador3.service.DTOs.studentCareer.request.StudentCareerRequestDTO;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatusCode;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

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

    public StudentCareer(StudentCareerId id, Long inscription, Long graduation, Integer antiquity) {
        super();
        this.id = id;
        this.inscription = new Timestamp(Math.toIntExact(inscription), 1, 1, 1, 1, 1, 1);
        if(graduation == null){
            this.graduation = null;
        }else{
            this.graduation = new Timestamp(Math.toIntExact(graduation), 1, 1, 1, 1, 1, 1);
        }
        this.antiquity = antiquity;
    }

}

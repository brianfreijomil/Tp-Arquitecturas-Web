package com.arquitecturasWeb.Integrador3.domain;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
public class StudentCareerId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "carrera_id")
    private Career career;

    @ManyToOne
    @JoinColumn(name = "estudiante_id")
    private Student student;

    public StudentCareerId(StudentCareerIdRequestDTO requets) {
        super();
        this.student = requets.getStudent();
        this.career = requets.getCareer();
    }

}

package com.arquitecturasWeb.Integrador3.domain;
import com.arquitecturasWeb.Integrador3.service.DTOs.studentCareerId.request.StudentCareerIdRequestDTO;
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
        this.student = new Student(requets.getStudent());
        this.career = new Career(requets.getCareer());
    }
}

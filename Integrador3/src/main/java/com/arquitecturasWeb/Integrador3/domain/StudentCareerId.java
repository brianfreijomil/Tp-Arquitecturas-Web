package com.arquitecturasWeb.Integrador3.domain;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentCareerId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "career_id")
    private Career career;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public StudentCareerId(Student s, Career c) {
        super();
        this.student = s;
        this.career = c;
    }
}

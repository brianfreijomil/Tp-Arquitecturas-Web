package com.arquitecturasWeb.Integrador3.service.DTOs.studentCareerId.response;

import com.arquitecturasWeb.Integrador3.domain.StudentCareerId;
import com.arquitecturasWeb.Integrador3.service.DTOs.career.response.CareerResponseDTO;
import com.arquitecturasWeb.Integrador3.service.DTOs.student.response.StudentResponseDTO;

public class StudentCareerIdResponseDTO {
    private CareerResponseDTO career;
    private StudentResponseDTO student;

    public StudentCareerIdResponseDTO(StudentCareerId s) {
        this.career = new CareerResponseDTO(s.getCareer());
        this.student = new StudentResponseDTO(s.getStudent());
    }
}

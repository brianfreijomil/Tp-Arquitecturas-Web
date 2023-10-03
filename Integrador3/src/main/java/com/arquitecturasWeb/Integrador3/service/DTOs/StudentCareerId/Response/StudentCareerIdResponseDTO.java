package com.arquitecturasWeb.Integrador3.service.DTOs.StudentCareerId.Response;

import com.arquitecturasWeb.Integrador3.domain.StudentCareerId;
import com.arquitecturasWeb.Integrador3.service.DTOs.Career.Response.CareerResponseDTO;
import com.arquitecturasWeb.Integrador3.service.DTOs.Student.Response.StudentResponseDTO;

public class StudentCareerIdResponseDTO {
    private CareerResponseDTO career;
    private StudentResponseDTO student;

    public StudentCareerIdResponseDTO(StudentCareerId s) {
        this.career = new CareerResponseDTO(s.getCareer());
        this.student = new StudentResponseDTO(s.getStudent());
    }
}

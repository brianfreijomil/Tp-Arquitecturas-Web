package com.arquitecturasWeb.Integrador3.controllers;

import com.arquitecturasWeb.Integrador3.service.DTOs.StudentCareerService;
import com.arquitecturasWeb.Integrador3.service.DTOs.StudentService;
import com.arquitecturasWeb.Integrador3.service.DTOs.studentCareer.response.CareerWithStudentsResponseDTO;
import com.arquitecturasWeb.Integrador3.service.DTOs.studentCareer.response.StudentsOfCareerByCityResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students/careers")
public class StudentCareerController {
    private StudentCareerService service;

    @Autowired
    public StudentCareerController(StudentCareerService service){
        this.service = service;
    }

    @GetMapping("/students/careers/getByCareersWithStudents")
    public List<CareerWithStudentsResponseDTO> findCareersWithStudents(){
        return  this.service.findCareersWithStudents();
    }

    @GetMapping("/students/careers/getByStudentsOfCareerByCity")
    public List<StudentsOfCareerByCityResponseDTO> findStudentsOfCareerByCity(){
        return  this.service.findStudentsOfCareerByCity();
    }
}

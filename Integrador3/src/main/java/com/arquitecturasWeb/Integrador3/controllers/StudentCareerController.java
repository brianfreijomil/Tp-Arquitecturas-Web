package com.arquitecturasWeb.Integrador3.controllers;

import com.arquitecturasWeb.Integrador3.service.DTOs.career.response.ReportCareerDTO;
import com.arquitecturasWeb.Integrador3.service.DTOs.studentCareer.request.SearchStudentsOfCareerByCityRequestDTO;
import com.arquitecturasWeb.Integrador3.service.StudentCareerService;
import com.arquitecturasWeb.Integrador3.service.DTOs.studentCareer.response.CareerWithStudentsResponseDTO;
import com.arquitecturasWeb.Integrador3.service.DTOs.studentCareer.response.StudentsOfCareerByCityResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/studentsCareers")
public class StudentCareerController {
    private StudentCareerService service;

    public StudentCareerController(StudentCareerService service){
        this.service = service;
    }

    @GetMapping("/getByCareersWithStudents")
    public List<CareerWithStudentsResponseDTO> findCareersWithStudents(){
        return this.service.findCareersWithStudents();
    }

    @GetMapping("getByStudentsOfCareerByCity")
    public List<StudentsOfCareerByCityResponseDTO> findStudentsOfCareerByCity(SearchStudentsOfCareerByCityRequestDTO s){
        return  this.service.findStudentsOfCareerByCity(s);
    }

    @GetMapping("reportOfCareers")
    public List<ReportCareerDTO> reportOfCareers(){
        return this.service.reportOfCareers();
    }
}

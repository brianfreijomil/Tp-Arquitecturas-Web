package com.arquitecturasWeb.Integrador3.controllers;

import com.arquitecturasWeb.Integrador3.repositories.CareerWithStudentsInterface;
import com.arquitecturasWeb.Integrador3.repositories.StudentsByCareerAndCityInterface;
import com.arquitecturasWeb.Integrador3.service.DTOs.Searchs.SearchStudentsOfCareerByCityRequestDTO;
import com.arquitecturasWeb.Integrador3.service.DTOs.career.response.ReportCareerDTO;
import com.arquitecturasWeb.Integrador3.service.DTOs.studentCareer.request.StudentCareerRequestDTO;
import com.arquitecturasWeb.Integrador3.service.DTOs.studentCareer.response.CareerWithStudentsResponseDTO;
import com.arquitecturasWeb.Integrador3.service.StudentCareerService;
import com.arquitecturasWeb.Integrador3.service.DTOs.studentCareer.response.StudentsOfCareerByCityResponseDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/studentsCareers")
public class StudentCareerController {
    private StudentCareerService service;

    public StudentCareerController(StudentCareerService service){
        this.service = service;
    }

    @PostMapping("")
    public ResponseEntity save(@RequestBody @Valid StudentCareerRequestDTO scrdto){
        return service.save(scrdto);
    }

    @GetMapping("/getByCareersWithStudents")
    public List<CareerWithStudentsResponseDTO> findCareersWithStudents(){
        return this.service.findCareersWithStudents();
    }

    @GetMapping("getByStudentsOfCareerByCity")
    public List<StudentsOfCareerByCityResponseDTO> findStudentsOfCareerByCity(SearchStudentsOfCareerByCityRequestDTO s){
        System.out.println(s);
        return  this.service.findStudentsOfCareerByCity(s);
    }

    @GetMapping("reportOfCareers")
    public List<ReportCareerDTO> reportOfCareers(){
        return this.service.reportOfCareers();
    }
}

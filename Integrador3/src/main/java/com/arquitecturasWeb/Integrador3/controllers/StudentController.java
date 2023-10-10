package com.arquitecturasWeb.Integrador3.controllers;

import com.arquitecturasWeb.Integrador3.service.DTOs.Searchs.SearchStudentsDTO;
import com.arquitecturasWeb.Integrador3.service.DTOs.Searchs.SearchStudentsOfCareerByCityRequestDTO;
import com.arquitecturasWeb.Integrador3.service.DTOs.studentCareer.request.StudentCareerRequestDTO;
import com.arquitecturasWeb.Integrador3.service.DTOs.studentCareer.response.StudentsOfCareerByCityResponseDTO;
import com.arquitecturasWeb.Integrador3.service.StudentService;
import com.arquitecturasWeb.Integrador3.service.DTOs.student.request.StudentRequestDTO;
import com.arquitecturasWeb.Integrador3.service.DTOs.student.response.StudentResponseDTO;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private StudentService service;

    public StudentController(StudentService ss){
        this.service = ss;
    }

    @PostMapping("")
    public ResponseEntity<Integer> save(@RequestBody @Valid StudentRequestDTO sdto){
        return this.service.save(sdto);
    }

    @PostMapping("/{dni}/career")
    public ResponseEntity save(@RequestBody @Valid StudentCareerRequestDTO scrdto, @PathVariable int dni) {
        return service.save(scrdto, dni);
    }

    @GetMapping("/")
    public List<StudentResponseDTO> getAllStudents(){
        return this.service.findAll();
    }

    @GetMapping("/dni/{dni}")
    public StudentResponseDTO findStudentByDNI(@PathVariable int dni){
        return this.service.findByDNI(dni);
    }

    @GetMapping("/lu/{lu}")
    public StudentResponseDTO findStudentByLu(@PathVariable int lu){
        return this.service.findStudentByLU(lu);
    }

    //method from StudentCareer controller
    @GetMapping("/sort")
    public List<StudentsOfCareerByCityResponseDTO> findStudentsOfCareerByCity(SearchStudentsOfCareerByCityRequestDTO s){
        return  this.service.findStudentsOfCareerByCity(s);
    }

    @GetMapping("/search")
    public List<StudentResponseDTO> search(SearchStudentsDTO request){
        return this.service.search(request);
    }
}

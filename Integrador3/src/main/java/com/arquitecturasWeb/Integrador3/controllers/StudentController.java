package com.arquitecturasWeb.Integrador3.controllers;

import com.arquitecturasWeb.Integrador3.service.StudentService;
import com.arquitecturasWeb.Integrador3.service.DTOs.student.request.StudentRequestDTO;
import com.arquitecturasWeb.Integrador3.service.DTOs.student.response.StudentResponseDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private StudentService service;

    @Autowired
    public StudentController(StudentService ss){
        this.service = ss;
    }

    @PostMapping("/")
    public void saveStudent(@RequestBody @Valid StudentRequestDTO sdto){
        service.save(sdto);
    }

    @GetMapping("")
    public List<StudentResponseDTO> getAllStudents(){
        return this.service.findAll();
    }

    @GetMapping("/{DNI}")
    public StudentResponseDTO getStudentByDni(@PathVariable int dni){
        return this.service.findByDNI(dni);
    }

    @GetMapping("/{lastName}")
    public StudentResponseDTO getStudentByLastName(@PathVariable String lastName){
        return service.getStudentByLastName(lastName);
    }

    @GetMapping("/{lu}")
    public ResponseEntity<?> getStudentByLU(@PathVariable int lu){
        return ResponseEntity.ok(service.getStudentByLU(lu));
    }
    @GetMapping("/{genre}")
    public ResponseEntity<?> getStudentByGenre(@PathVariable String genre){
       return ResponseEntity.ok(service.getStudentByGenre(genre));
    }

    @GetMapping("/search")
    public List<StudentResponseDTO> search(StudentRequestDTO request){
        return this.service.search(request);
    }
}

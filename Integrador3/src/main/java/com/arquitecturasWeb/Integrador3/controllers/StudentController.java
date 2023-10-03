package com.arquitecturasWeb.Integrador3.controllers;

import com.arquitecturasWeb.Integrador3.service.DTOs.StudentService;
import com.arquitecturasWeb.Integrador3.service.DTOs.student.request.StudentRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.arquitecturasWeb.Integrador3.domain.Student;

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
    public void saveStudent(@RequestBody StudentRequestDTO sdto){
        this.service.save(sdto);
    }

    @GetMapping("")
    public List<Student> getAllStudents(){
        return this.service.findAll();
    }
    @GetMapping("/{DNI}")
    public Student getStudentByDni(@PathVariable Long dni){
        return this.service.getById(dni);
    }

    @GetMapping("/{lastName}")
    public ResponseEntity<?> getStudentByLastName(@PathVariable String lastName){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.getStudentByLastName(lastName));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

    @GetMapping("/{lu}")
    public ResponseEntity<?> getStudentByLU(@PathVariable int lu){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.getStudentByLU(lu));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }
    @GetMapping("/{genre}")
    public ResponseEntity<?> getStudentByGenre(@PathVariable String genre){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.getStudentByGenre(genre));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }
}

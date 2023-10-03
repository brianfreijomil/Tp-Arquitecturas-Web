package com.arquitecturasWeb.Integrador3.controllers;

import com.arquitecturasWeb.Integrador3.domain.Student;
import com.arquitecturasWeb.Integrador3.repositories.StudentRepository;
import com.arquitecturasWeb.Integrador3.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService service;

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }
    @GetMapping("/{DNI}")
    public ResponseEntity<?> getStudentByDni(@PathVariable Long dni){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.findById(dni));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
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

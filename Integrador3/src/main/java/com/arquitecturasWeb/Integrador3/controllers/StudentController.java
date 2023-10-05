package com.arquitecturasWeb.Integrador3.controllers;

import com.arquitecturasWeb.Integrador3.service.StudentService;
import com.arquitecturasWeb.Integrador3.service.DTOs.student.request.StudentRequestDTO;
import com.arquitecturasWeb.Integrador3.service.DTOs.student.response.StudentResponseDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<Integer> saveStudent(@RequestBody @Valid StudentRequestDTO sdto){
        int id = service.save(sdto);
        return new ResponseEntity(id, HttpStatus.CREATED);
    }

    @GetMapping("")
    public List<StudentResponseDTO> getAllStudents(){
        return this.service.findAll();
    }



    @GetMapping("/search")
    public List<StudentResponseDTO> search(StudentRequestDTO request){
        return this.service.search(request);
    }
}

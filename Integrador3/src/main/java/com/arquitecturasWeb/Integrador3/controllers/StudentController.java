package com.arquitecturasWeb.Integrador3.controllers;

import com.arquitecturasWeb.Integrador3.service.DTOs.Searchs.SearchStudentsDTO;
import com.arquitecturasWeb.Integrador3.service.StudentService;
import com.arquitecturasWeb.Integrador3.service.DTOs.student.request.StudentRequestDTO;
import com.arquitecturasWeb.Integrador3.service.DTOs.student.response.StudentResponseDTO;
import com.arquitecturasWeb.Integrador3.service.exception.BadRequestException;
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
    public ResponseEntity<Integer> save(@RequestBody @Valid StudentRequestDTO sdto){
        Integer id = service.save(sdto);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    @GetMapping("/orderByName")
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

    @GetMapping("/search")
    public List<StudentResponseDTO> search(SearchStudentsDTO request){
        return this.service.search(request);
    }
}

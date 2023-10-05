package com.arquitecturasWeb.Integrador3.controllers;

import com.arquitecturasWeb.Integrador3.service.CareerService;
import com.arquitecturasWeb.Integrador3.service.DTOs.Searchs.SearchCareersDTO;
import com.arquitecturasWeb.Integrador3.service.DTOs.Searchs.SearchStudentsDTO;
import com.arquitecturasWeb.Integrador3.service.DTOs.career.request.CareerRequestDTO;
import com.arquitecturasWeb.Integrador3.service.DTOs.career.response.CareerResponseDTO;
import com.arquitecturasWeb.Integrador3.service.DTOs.student.response.StudentResponseDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/careers")
public class CareerController {
    private CareerService service;

    public CareerController(CareerService service){
        this.service = service;
    }

    @PostMapping("")
    public ResponseEntity save(@RequestBody @Valid CareerRequestDTO cdto){
        return service.save(cdto);
    }

    @GetMapping("/{id}")
    public CareerResponseDTO getCareerById(@PathVariable Long id){
        return service.findCareerById(id);
    }

    @GetMapping("/")
    public List<CareerResponseDTO> getAllCareers(){
        return this.service.findAll();
    }

    @GetMapping("/search")
    public List<CareerResponseDTO> search(SearchCareersDTO request){
        return this.service.search(request);
    }
}

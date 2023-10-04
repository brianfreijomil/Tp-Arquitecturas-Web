package com.arquitecturasWeb.Integrador3.controllers;

import com.arquitecturasWeb.Integrador3.service.CareerService;
import com.arquitecturasWeb.Integrador3.service.DTOs.career.request.CareerRequestDTO;
import com.arquitecturasWeb.Integrador3.service.DTOs.career.response.CareerResponseDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/careers")
public class CareerController {
    private CareerService service;

    @Autowired
    public CareerController(CareerService service){
        this.service = service;
    }

    @PostMapping("/")
    public void saveCareer(@RequestBody @Valid CareerRequestDTO cdto){
        service.save(cdto);
    }

    @GetMapping("/{id}")
    public CareerResponseDTO getCareerById(@PathVariable long id){
        return service.findCareerById(id);
    }

    @GetMapping("/{name}")
    public CareerResponseDTO getCareerByName(@PathVariable String name){
        return service.findCareerByName(name);
    }

    @GetMapping("/")
    public List<CareerResponseDTO> getAllCareers(){
        return this.service.findAll();
    }
}

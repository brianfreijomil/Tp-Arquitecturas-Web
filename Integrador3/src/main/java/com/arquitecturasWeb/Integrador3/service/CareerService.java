package com.arquitecturasWeb.Integrador3.service;

import com.arquitecturasWeb.Integrador3.domain.Career;
import com.arquitecturasWeb.Integrador3.domain.Student;
import com.arquitecturasWeb.Integrador3.repositories.CareerRepository;
import com.arquitecturasWeb.Integrador3.service.DTOs.career.request.CareerRequestDTO;
import com.arquitecturasWeb.Integrador3.service.DTOs.career.response.CareerResponseDTO;
import com.arquitecturasWeb.Integrador3.service.DTOs.student.response.StudentResponseDTO;
import com.arquitecturasWeb.Integrador3.service.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service("CareerService")
public class CareerService{
    private CareerRepository repository;

    public CareerService(CareerRepository repository){
        this.repository = repository;
    }

    public CareerResponseDTO findCareerById(long id) {
        return repository.findById(id).map(CareerResponseDTO::new).orElseThrow(() -> new NotFoundException("no se ecntron la carrera"));
    }

    public CareerResponseDTO findCareerByName(String name) {
        Optional<Career> career = repository.findByName(name);
        if(career.isPresent()){
            CareerResponseDTO c = new CareerResponseDTO(career.get());
            return c;
        }
        return null;
    }

    public List<CareerResponseDTO> findAll() {
        List<Career> careers = repository.findAll();
        return careers.stream().map(s1-> new CareerResponseDTO(s1)).collect(Collectors.toList());
    }

    public void save(CareerRequestDTO career) {
        repository.save(new Career(career)).getId();
    }
}

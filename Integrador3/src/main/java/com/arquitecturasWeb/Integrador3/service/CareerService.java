package com.arquitecturasWeb.Integrador3.service;

import com.arquitecturasWeb.Integrador3.domain.Career;
import com.arquitecturasWeb.Integrador3.domain.Student;
import com.arquitecturasWeb.Integrador3.repositories.CareerRepository;
import com.arquitecturasWeb.Integrador3.service.DTOs.Searchs.SearchCareersDTO;
import com.arquitecturasWeb.Integrador3.service.DTOs.Searchs.SearchStudentsDTO;
import com.arquitecturasWeb.Integrador3.service.DTOs.career.request.CareerRequestDTO;
import com.arquitecturasWeb.Integrador3.service.DTOs.career.response.CareerResponseDTO;
import com.arquitecturasWeb.Integrador3.service.DTOs.student.response.StudentResponseDTO;
import com.arquitecturasWeb.Integrador3.service.exception.ConflictExistException;
import com.arquitecturasWeb.Integrador3.service.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional(readOnly = true)
    public CareerResponseDTO findCareerById(long id) {
        return repository.findById(id).map(CareerResponseDTO::new).orElseThrow(() -> new NotFoundException("Cliente", "ID", id));
    }

    @Transactional(readOnly = true)
    public List<CareerResponseDTO> findAll() {
        List<Career> careers = repository.findAll();
        return careers.stream().map(s1-> new CareerResponseDTO(s1)).collect(Collectors.toList());
    }

    @Transactional
    public ResponseEntity save(CareerRequestDTO career) {
        /*if the career does not exist then I persist*/
        if(!this.repository.existsById(career.getId())){
            this.repository.save(new Career(career));
            return new ResponseEntity(career.getId(), HttpStatus.CREATED);
        }

        throw new ConflictExistException("Career", "ID", career.getId());
    }

    @Transactional(readOnly = true)
    public List<CareerResponseDTO> search(SearchCareersDTO request) {
        return this.repository.
                search(request.getId(), request.getName(), request.getDuration())
                .stream()
                .map(CareerResponseDTO::new).collect(Collectors.toList());
    }
}

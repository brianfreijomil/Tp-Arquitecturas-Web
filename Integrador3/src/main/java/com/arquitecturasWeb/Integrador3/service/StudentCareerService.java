package com.arquitecturasWeb.Integrador3.service;

import com.arquitecturasWeb.Integrador3.domain.StudentCareer;
import com.arquitecturasWeb.Integrador3.repositories.CareerRepository;
import com.arquitecturasWeb.Integrador3.repositories.StudentCareerRepository;
import com.arquitecturasWeb.Integrador3.repositories.StudentRepository;
import com.arquitecturasWeb.Integrador3.service.DTOs.career.response.ReportCareerDTO;
import com.arquitecturasWeb.Integrador3.service.DTOs.Searchs.SearchStudentsOfCareerByCityRequestDTO;
import com.arquitecturasWeb.Integrador3.service.DTOs.studentCareer.request.StudentCareerRequestDTO;
import com.arquitecturasWeb.Integrador3.service.DTOs.studentCareer.response.CareerWithStudentsResponseDTO;
import com.arquitecturasWeb.Integrador3.service.DTOs.studentCareer.response.StudentsOfCareerByCityResponseDTO;
import com.arquitecturasWeb.Integrador3.service.exception.ConflictExistException;
import com.arquitecturasWeb.Integrador3.service.exception.ConflictExistWithEmbebbedIdException;
import com.arquitecturasWeb.Integrador3.service.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service("StudentCareerService")
public class StudentCareerService {

    private StudentCareerRepository repository;
    private StudentRepository studentRepo;
    private CareerRepository careerRepo;


    public StudentCareerService(StudentCareerRepository repository, StudentRepository studentRepo, CareerRepository careerRepo){
        this.repository = repository;
        this.studentRepo = studentRepo;
        this.careerRepo = careerRepo;
    }

    @Transactional(readOnly = true)
    public List<CareerWithStudentsResponseDTO> findCareersWithStudents() {
        List<CareerWithStudentsResponseDTO> studentsCareers = repository.findCareersWithStudents();
        return studentsCareers;
    }
    @Transactional(readOnly = true)
    public List<StudentsOfCareerByCityResponseDTO> findStudentsOfCareerByCity(SearchStudentsOfCareerByCityRequestDTO search) {
        List<StudentsOfCareerByCityResponseDTO> students = repository.findStudentByCareerAndCity();
        return students;
    }


    public ResponseEntity save(StudentCareerRequestDTO scrdto) {
        if(!this.studentRepo.existsById((long)scrdto.getId().getStudent().getDNI())){
            if(!this.careerRepo.existsById(scrdto.getId().getCareer().getId())){
                this.repository.save(new StudentCareer(scrdto));
                return new ResponseEntity(scrdto.getId(), HttpStatus.CREATED);
            }
            else{
                throw new ConflictExistException("Career","ID", scrdto.getId().getCareer().getId());
            }
        }
        else {
            throw new ConflictExistException("Student","ID", (long) scrdto.getId().getStudent().getDNI());
        }
    }
}

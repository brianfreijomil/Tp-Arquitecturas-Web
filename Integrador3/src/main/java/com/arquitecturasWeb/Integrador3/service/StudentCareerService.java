package com.arquitecturasWeb.Integrador3.service;

import com.arquitecturasWeb.Integrador3.domain.Career;
import com.arquitecturasWeb.Integrador3.domain.StudentCareer;
import com.arquitecturasWeb.Integrador3.domain.StudentCareerId;
import com.arquitecturasWeb.Integrador3.repositories.StudentCareerRepository;
import com.arquitecturasWeb.Integrador3.repositories.StudentRepository;
import com.arquitecturasWeb.Integrador3.repositories.CareerRepository;
import com.arquitecturasWeb.Integrador3.service.DTOs.career.response.ReportCareerDTO;
import com.arquitecturasWeb.Integrador3.service.DTOs.Searchs.SearchStudentsOfCareerByCityRequestDTO;
import com.arquitecturasWeb.Integrador3.service.DTOs.studentCareer.request.StudentCareerRequestDTO;
import com.arquitecturasWeb.Integrador3.service.DTOs.studentCareer.response.CareerWithStudentsResponseDTO;
import com.arquitecturasWeb.Integrador3.service.DTOs.studentCareer.response.StudentsOfCareerByCityResponseDTO;
import com.arquitecturasWeb.Integrador3.service.DTOs.studentCareerId.request.StudentCareerIdRequestDTO;
import com.arquitecturasWeb.Integrador3.service.DTOs.studentCareerId.response.StudentCareerIdResponseDTO;
import com.arquitecturasWeb.Integrador3.service.exception.ConflictExistException;
import com.arquitecturasWeb.Integrador3.service.exception.ConflictExistWithEmbebbedIdException;
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
    private StudentRepository studentRepository;
    private CareerRepository careerRepository;

    public StudentCareerService(StudentCareerRepository repository, StudentRepository studentRepository,
                                CareerRepository careerRepository){

        this.repository = repository;
        this.studentRepository = studentRepository;
        this.careerRepository = careerRepository;
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
    @Transactional
    public ResponseEntity save(StudentCareerRequestDTO scrdto) {
        if(!this.studentRepository.existsById((long)scrdto.getId().getStudent().getDNI())){
            if(!this.careerRepository.existsById(scrdto.getId().getCareer().getId())){
                this.repository.save(new StudentCareer(scrdto));
                return new ResponseEntity(scrdto.getId(), HttpStatus.CREATED);
                }
            }
            throw new ConflictExistWithEmbebbedIdException("Student", "Career","ID","ID",
                    scrdto.getId().getStudent().getDNI(), scrdto.getId().getCareer().getId());
        }
}

package com.arquitecturasWeb.Integrador3.service;

import com.arquitecturasWeb.Integrador3.repositories.StudentCareerRepository;
import com.arquitecturasWeb.Integrador3.service.DTOs.career.response.ReportCareerDTO;
import com.arquitecturasWeb.Integrador3.service.DTOs.Searchs.SearchStudentsOfCareerByCityRequestDTO;
import com.arquitecturasWeb.Integrador3.service.DTOs.studentCareer.response.CareerWithStudentsResponseDTO;
import com.arquitecturasWeb.Integrador3.service.DTOs.studentCareer.response.StudentsOfCareerByCityResponseDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service("StudentCareerService")
public class StudentCareerService {

    private StudentCareerRepository repository;

    public StudentCareerService(StudentCareerRepository repository){
        this.repository = repository;
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
    @Transactional(readOnly = true)
    public List<ReportCareerDTO> reportOfCareers() {
        return this.repository.findInscriptionAndGraduatedForYear().stream()
                .map(result -> new ReportCareerDTO((String) result[0], ((BigDecimal) result[1]), ((BigDecimal) result[2]), ((Long) result[3])))
                .collect(Collectors.toList());
    }

}

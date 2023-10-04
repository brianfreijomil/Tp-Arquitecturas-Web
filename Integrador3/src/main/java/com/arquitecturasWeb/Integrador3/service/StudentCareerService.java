package com.arquitecturasWeb.Integrador3.service;

import com.arquitecturasWeb.Integrador3.domain.Student;
import com.arquitecturasWeb.Integrador3.domain.StudentCareer;
import com.arquitecturasWeb.Integrador3.repositories.StudentCareerRepository;
import com.arquitecturasWeb.Integrador3.service.DTOs.student.response.StudentResponseDTO;
import com.arquitecturasWeb.Integrador3.service.DTOs.studentCareer.request.StudentsOfCareerByCityRequestDTO;
import com.arquitecturasWeb.Integrador3.service.DTOs.studentCareer.response.CareerWithStudentsResponseDTO;
import com.arquitecturasWeb.Integrador3.service.DTOs.studentCareer.response.StudentsOfCareerByCityResponseDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public List<StudentsOfCareerByCityResponseDTO> findStudentsOfCareerByCity() {
        List<StudentsOfCareerByCityResponseDTO> students = repository.findStudentByCareerAndCity();
        return students;
    }
}

package com.arquitecturasWeb.Integrador3.service;

import com.arquitecturasWeb.Integrador3.domain.Student;
import com.arquitecturasWeb.Integrador3.repositories.StudentRepository;
import com.arquitecturasWeb.Integrador3.service.DTOs.student.request.StudentRequestDTO;
import com.arquitecturasWeb.Integrador3.service.DTOs.student.response.StudentResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("StudentService")
public class StudentService{
    private StudentRepository repository;

    public StudentService(StudentRepository repository){
        this.repository = repository;
    }

    @Transactional
    public int save(StudentRequestDTO student){
        return repository.save(new Student(student)).getDNI();
    }
    @Transactional(readOnly = true)
    public StudentResponseDTO getStudentByLastName(String lastName) {
        Optional<Student> student = repository.findByLastName(lastName);
        if(student.isPresent()){
            StudentResponseDTO s = new StudentResponseDTO(student.get());
            return s;
        }
        return null;
    }
    @Transactional(readOnly = true)
    public StudentResponseDTO getStudentByLU(int lu) {
        Optional<Student> student = repository.findByLu(lu);
        if(student.isPresent()){
            StudentResponseDTO s = new StudentResponseDTO(student.get());
            return s;
        }
        return null;
    }
    @Transactional(readOnly = true)
    public StudentResponseDTO getStudentByGenre(String genre) {
        Optional<Student> student = repository.findByGenre(genre);
        if(student.isPresent()){
            StudentResponseDTO s = new StudentResponseDTO(student.get());
            return s;
        }
        return null;
    }
    @Transactional(readOnly = true)
    public StudentResponseDTO findByDNI(int dni){
        Optional<Student> student = repository.findByDNI(dni);
        if(student.isPresent()){
            StudentResponseDTO s = new StudentResponseDTO(student.get());
            return s;
        }
        return null;
    }
    @Transactional(readOnly = true)
    public List<StudentResponseDTO> findAll() {
        List<Student> students = repository.findAll();
        return students.stream().map(StudentResponseDTO::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<StudentResponseDTO> search(StudentRequestDTO request) {
        return this.repository.
                search(request.getDNI(), request.getLu(), request.getLastName(), request.getName(), request.getAge(), request.getGenre(), request.getCity())
                .stream()
                .map(StudentResponseDTO::new).collect(Collectors.toList());
    }
}

package com.arquitecturasWeb.Integrador3.service.DTOs;

import com.arquitecturasWeb.Integrador3.domain.Student;
import com.arquitecturasWeb.Integrador3.repositories.StudentRepository;
import com.arquitecturasWeb.Integrador3.service.DTOs.student.request.StudentRequestDTO;
import com.arquitecturasWeb.Integrador3.service.DTOs.student.response.StudentResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("StudentService")
public class StudentService{
    @Autowired
    private StudentRepository repository;


    //------------------------------------------------------------------>>>>>

    public int save(StudentRequestDTO student){
        return repository.save(new Student(student)).getDNI();
    }
    public StudentResponseDTO getStudentByLastName(String lastName) {
        Optional<Student> student = repository.findByLastName(lastName);
        if(student.isPresent()){
            StudentResponseDTO s = new StudentResponseDTO(student.get());
            return s;
        }
        return null;
    }

    public StudentResponseDTO getStudentByLU(int lu) {
        Optional<Student> student = repository.findByLu(lu);
        if(student.isPresent()){
            StudentResponseDTO s = new StudentResponseDTO(student.get());
            return s;
        }
        return null;
    }

    public Object getStudentByGenre(String genre) {
        return repository.getStudentByGenre(genre);
    }

    public Student findByDNI(int id){
        return repository.findByDNI(id);
    }

    public List<StudentResponseDTO> findAll() {
        List<Student> students = repository.findAll();
        return students.stream().map(s1-> new StudentResponseDTO(s1)).collect(Collectors.toList());
    }
//------------------------------------------------------------------>>>>>
}

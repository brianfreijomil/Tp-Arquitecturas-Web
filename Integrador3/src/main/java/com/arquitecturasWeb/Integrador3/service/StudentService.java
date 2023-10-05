package com.arquitecturasWeb.Integrador3.service;

import com.arquitecturasWeb.Integrador3.domain.Student;
import com.arquitecturasWeb.Integrador3.repositories.StudentRepository;
import com.arquitecturasWeb.Integrador3.service.DTOs.Searchs.SearchStudentsDTO;
import com.arquitecturasWeb.Integrador3.service.DTOs.student.request.StudentRequestDTO;
import com.arquitecturasWeb.Integrador3.service.DTOs.student.response.StudentResponseDTO;
import com.arquitecturasWeb.Integrador3.service.exception.ConflictExistException;
import com.arquitecturasWeb.Integrador3.service.exception.NotFoundException;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity save(StudentRequestDTO student){
        /*if the student does not exist then I persist*/
        if(!this.repository.existsById((long) student.getDNI())){
            return new ResponseEntity(student.getDNI(), HttpStatus.CREATED);
        }

        throw new ConflictExistException("Student", "DNI", (long) student.getDNI());
    }

    @Transactional(readOnly = true)
    public StudentResponseDTO findStudentByLU(int lu) {
        Optional<Student> student = repository.findByLu(lu);
        return student.map(StudentResponseDTO::new).orElseThrow(() -> new NotFoundException("Student", "LU", (long) lu));
    }

    @Transactional(readOnly = true)
    public StudentResponseDTO findByDNI(int dni){
        Optional<Student> student = repository.findByDNI(dni);
        return student.map(StudentResponseDTO::new).orElseThrow(() -> new NotFoundException("Student", "DNI", (long) dni));
    }
    @Transactional(readOnly = true)
    public List<StudentResponseDTO> findAll() {
        Sort sort = Sort.by(Sort.Order.asc("name"));
        List<Student> students = repository.findAll(sort);
        return students.stream().map(StudentResponseDTO::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<StudentResponseDTO> search(SearchStudentsDTO request) {
        return this.repository.
                search(request.getDNI(), request.getLu(), request.getLastName(), request.getName(), request.getAge(), request.getGenre(), request.getCity())
                .stream()
                .map(StudentResponseDTO::new).collect(Collectors.toList());
    }
}

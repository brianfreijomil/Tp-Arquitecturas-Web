package com.arquitecturasWeb.Integrador3.service;

import com.arquitecturasWeb.Integrador3.domain.Career;
import com.arquitecturasWeb.Integrador3.domain.Student;
import com.arquitecturasWeb.Integrador3.domain.StudentCareer;
import com.arquitecturasWeb.Integrador3.domain.StudentCareerId;
import com.arquitecturasWeb.Integrador3.repositories.CareerRepository;
import com.arquitecturasWeb.Integrador3.repositories.StudentCareerRepository;
import com.arquitecturasWeb.Integrador3.repositories.StudentRepository;
import com.arquitecturasWeb.Integrador3.service.DTOs.Searchs.SearchStudentsDTO;
import com.arquitecturasWeb.Integrador3.service.DTOs.Searchs.SearchStudentsOfCareerByCityRequestDTO;
import com.arquitecturasWeb.Integrador3.service.DTOs.student.request.StudentRequestDTO;
import com.arquitecturasWeb.Integrador3.service.DTOs.student.response.StudentResponseDTO;
import com.arquitecturasWeb.Integrador3.service.DTOs.studentCareer.request.StudentCareerRequestDTO;
import com.arquitecturasWeb.Integrador3.service.DTOs.studentCareer.response.StudentCareerResponseDTO;
import com.arquitecturasWeb.Integrador3.service.DTOs.studentCareer.response.StudentsOfCareerByCityResponseDTO;
import com.arquitecturasWeb.Integrador3.service.exception.ConflictExistException;
import com.arquitecturasWeb.Integrador3.service.exception.NotFoundException;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("StudentService")
public class StudentService{
    private StudentRepository repository;
    private StudentCareerRepository studentCareerRepository;
    private CareerRepository careerRepository;

    public StudentService(StudentRepository repository, StudentCareerRepository studentCareerRepository, CareerRepository careerRepository){
        this.repository = repository;
        this.studentCareerRepository = studentCareerRepository;
        this.careerRepository = careerRepository;
    }

    @Transactional
    public ResponseEntity save(StudentRequestDTO student){
        /*if the student does not exist then I persist*/
        if(!this.repository.existsById((long) student.getDNI())){
            return new ResponseEntity(student.getDNI(), HttpStatus.CREATED);
        }

        throw new ConflictExistException("Student", "DNI", (long) student.getDNI());
    }

    @Transactional
    public ResponseEntity save(StudentCareerRequestDTO scrdto, int studentId) {
        Student s = (this.repository.findByDNI(studentId));
        if(s != null){
            Career c = this.careerRepository.findById(scrdto.getCareer_id()).get();
            if(c != null){
                StudentCareerId id = new StudentCareerId(s, c);
                if(!this.studentCareerRepository.existsById(id)){
                    StudentCareer sc = new StudentCareer(id, scrdto.getInscription(), scrdto.getGraduation(), scrdto.getAntiquity());
                    this.studentCareerRepository.save(sc);
                    return new ResponseEntity("CREATED Student: " + studentId + ", Career: " + scrdto.getCareer_id(), HttpStatus.ACCEPTED);
                }
                throw new ConflictExistException("Student", "Career", "DNI", "CareerID", (long) studentId, scrdto.getCareer_id());
            }
            else{
                throw new NotFoundException("Career","ID", scrdto.getCareer_id());
            }
        }
        else {
            throw new NotFoundException("Student", "DNI", (long) studentId);
        }
    }

    @Transactional(readOnly = true)
    public StudentResponseDTO findStudentByLU(int lu) {
        Optional<Student> student = repository.findByLu(lu);
        return student.map(StudentResponseDTO::new).orElseThrow(() -> new NotFoundException("Student", "LU", (long) lu));
    }

    @Transactional(readOnly = true)
    public StudentResponseDTO findByDNI(int dni){
        Student student = repository.findByDNI(dni);
        if(student != null) {
            return new StudentResponseDTO(student);
        }
        throw new NotFoundException("Student", "DNI", (long) dni);
    }
    @Transactional(readOnly = true)
    public List<StudentResponseDTO> findAll() {
        Sort sort = Sort.by(Sort.Order.asc("name"));
        List<Student> students = repository.findAll(sort);
        return students.stream().map(StudentResponseDTO::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<StudentsOfCareerByCityResponseDTO> findStudentsOfCareerByCity(SearchStudentsOfCareerByCityRequestDTO search) {
        return studentCareerRepository.findStudentByCareerAndCity(search.getCity(), search.getCareer()).stream()
                .map(result -> new StudentsOfCareerByCityResponseDTO(result.getStudentDNI(), result.getStudentName(), result.getStudentSurname(), result.getCareerName(), result.getStudentCity()))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<StudentResponseDTO> search(SearchStudentsDTO request) {
        return this.repository.
                search(request.getDNI(), request.getLu(), request.getLastName(), request.getName(), request.getAge(), request.getGenre(), request.getCity())
                .stream()
                .map(StudentResponseDTO::new).collect(Collectors.toList());
    }
}

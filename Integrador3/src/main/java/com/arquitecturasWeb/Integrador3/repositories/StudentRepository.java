package com.arquitecturasWeb.Integrador3.repositories;

import com.arquitecturasWeb.Integrador3.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("EstudianteRepository")
public interface StudentRepository extends JpaRepository<Student, Long> {

    Student getStudentByGenre(String genre);

    Optional<Student> findByDNI(int dni);

    Optional<Student> findByLastName(String lastName);

    Optional<Student> findByLu(int lu);

    Optional<Student> findByGenre(String genre);
}

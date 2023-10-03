package com.arquitecturasWeb.Integrador3.repositories;

import com.arquitecturasWeb.Integrador3.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("EstudianteRepository")
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("SELECT s FROM Student s WHERE s.lastName = :lastName")
    public Student getStudentByLastName(String lastName);

    Student getStudentByLu(int lu);
    Student getStudentByGenre(String genre);

}

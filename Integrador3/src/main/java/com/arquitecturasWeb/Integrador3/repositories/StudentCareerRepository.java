package com.arquitecturasWeb.Integrador3.repositories;

import com.arquitecturasWeb.Integrador3.domain.StudentCareer;
import com.arquitecturasWeb.Integrador3.domain.StudentCareerId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentCareerRepository extends JpaRepository<StudentCareer, StudentCareerId> {
    @Query("SELECT c.name, ec.id.career.id, COUNT(ec.id.student.DNI)\n" +
            "FROM StudentCareer ec JOIN ec.id.career c " +
            "GROUP BY ec.id.career.id,c.name " +
            "ORDER BY COUNT(ec.id.student.DNI) desc")
    CareerWithStudentsDTO findCareersWithStudents();

    @Query("select ec.id.student.DNI, e.name, e.lastName, c.name, e.city\n"+
            "from StudentCareer ec JOIN ec.id.student e " +
            "JOIN ec.id.career c "+
            "where e.city = :ciudad " +
            "and c.name like :carrera "+
            "GROUP BY ec.id.student.DNI, e.name, e.lastName, c.name, e.city")
    StudentsOfCareerByCity findStudentByCareerAndCity();
}

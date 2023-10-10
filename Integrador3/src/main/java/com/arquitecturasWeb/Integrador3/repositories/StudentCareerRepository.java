package com.arquitecturasWeb.Integrador3.repositories;

import com.arquitecturasWeb.Integrador3.domain.StudentCareer;
import com.arquitecturasWeb.Integrador3.domain.StudentCareerId;
import com.arquitecturasWeb.Integrador3.service.DTOs.Searchs.SearchStudentsOfCareerByCityRequestDTO;
import com.arquitecturasWeb.Integrador3.service.DTOs.studentCareer.response.StudentsOfCareerByCityResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentCareerRepository extends JpaRepository<StudentCareer, StudentCareerId> {
    @Query("SELECT c.name AS careerName, ec.id.career.id AS careerId, COUNT(ec.id.student.DNI) AS studentNumber " +
            "FROM StudentCareer ec JOIN ec.id.career c " +
            "GROUP BY ec.id.career.id,c.name " +
            "ORDER BY COUNT(ec.id.student.DNI) desc")
    List<CareerWithStudentsInterface> findCareersWithStudents();

    @Query("select ec.id.student.DNI AS studentDNI, e.name AS studentName, e.lastName AS studentSurname, c.name AS careerName, e.city AS studentCity \n"+
            "from StudentCareer ec JOIN ec.id.student e " +
            "JOIN ec.id.career c "+
            "where e.city = :city " +
            "and c.name like :career "+
            "GROUP BY ec.id.student.DNI, e.name, e.lastName, c.name, e.city")
    List<StudentsByCareerAndCityInterface> findStudentByCareerAndCity(@Param("city") String city, @Param("career") String career);

    @Query(value="SELECT career, SUM(count_inscripts) AS count_inscripts, SUM(count_graduated) as count_graduated, old " +
            "FROM( SELECT c.name AS career, COUNT(ec.student_id) AS count_inscripts, 0 AS count_graduated, " +
            "EXTRACT(YEAR FROM ec.inscription) AS old " +
            "FROM student_career ec JOIN career c ON ec.career_id = c.id " +
            "GROUP BY c.name, ec.career_id, old " +
            "UNION ALL " +
            "SELECT c.name AS career, 0 AS count_inscripts, COUNT(ec.student_id) AS count_graduated, " +
            "EXTRACT(YEAR FROM ec.graduation) AS old " +
            "FROM student_career ec " +
            "JOIN career c ON ec.career_id = c.id " +
            "GROUP BY c.name, ec.career_id, old) AS subQuery " +
            "WHERE old IS NOT NULL GROUP BY career, old ORDER BY career ASC, old ASC", nativeQuery = true)
    List<Object[]> findInscriptionAndGraduatedForYear();
}

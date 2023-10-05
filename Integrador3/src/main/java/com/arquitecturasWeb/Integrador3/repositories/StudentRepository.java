package com.arquitecturasWeb.Integrador3.repositories;

import com.arquitecturasWeb.Integrador3.domain.Student;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository("EstudianteRepository")
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findAll(Sort sort);

    Optional<Student> findByDNI(int dni);

    Optional<Student> findByLu(int lu);

    @Query("Select s " +
            "from Student s " +
            " where(:dni is null or s.DNI = :dni) " +
            " and(:lu is null or s.lu = :lu) " +
            "and (:lastName is null or s.lastName like :lastName)" +
            "and (:name is null or s.name like :name)" +
            "and (:age is null or s.age = :age)" +
            "and (:genre is null or s.genre like :genre)" +
            "and (:city is null or s.city like :city) ")
    List<Student> search(Integer dni, Integer lu, String lastName, String name, Integer age, String genre, String city);
}

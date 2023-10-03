package com.arquitecturasWeb.Integrador3.repositories;

import com.arquitecturasWeb.Integrador3.entities.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("EstudianteRepository")
public interface StudentRepository extends JpaRepository<Estudiante, Long>{

}

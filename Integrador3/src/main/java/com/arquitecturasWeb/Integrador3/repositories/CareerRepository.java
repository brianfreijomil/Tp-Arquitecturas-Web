package com.arquitecturasWeb.Integrador3.repositories;

import com.arquitecturasWeb.Integrador3.entities.Carrera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("CarreraRepository")
public interface CareerRepository extends JpaRepository<Carrera, Long> {
}

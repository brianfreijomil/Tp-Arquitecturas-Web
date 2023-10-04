package com.arquitecturasWeb.Integrador3.repositories;

import com.arquitecturasWeb.Integrador3.domain.Career;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("CarreraRepository")
public interface CareerRepository extends JpaRepository<Career, Long> {
    @Override
    List<Career> findAll();

    Optional<Career> findByName(String name);
}

package com.arquitecturasWeb.Integrador3.repositories;

import com.arquitecturasWeb.Integrador3.domain.Career;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("CarreraRepository")
public interface CareerRepository extends JpaRepository<Career, Long> {

    Career getCareerById(long id);
    Career getCareerByName(String name);

    @Override
    List<Career> findAll();
}

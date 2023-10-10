package com.arquitecturasWeb.Integrador3.repositories;

import com.arquitecturasWeb.Integrador3.domain.Career;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface CareerRepository extends JpaRepository<Career, Long> {
    @Override
    List<Career> findAll();

    Optional<Career> findByName(String name);

    Optional<Career> findById(Long id);

    @Query("Select c " +
            "from Career c " +
            " where(:id is null or c.id = :id) " +
            "and (:name is null or c.name like :name)" +
            "and (:duration is null or c.duration = :duration)")
    List<Career> search(Long id, String name, Integer duration);
}

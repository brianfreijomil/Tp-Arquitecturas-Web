package com.arquitecturasWeb.Integrador3.services;

import com.arquitecturasWeb.Integrador3.entities.Carrera;
import com.arquitecturasWeb.Integrador3.repositories.CareerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service("CareerService")
public class CareerService implements JpaRepository<Carrera, Long> {

    @Autowired
    private CareerRepository repository;


    @Override
    public void flush() {

    }

    @Override
    public <S extends Carrera> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Carrera> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Carrera getOne(Long aLong) {
        return null;
    }

    @Override
    public Carrera getById(Long aLong) {
        return null;
    }

    @Override
    public Carrera getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Carrera> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Carrera> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Carrera> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Carrera> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Carrera> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Carrera> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Carrera, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Carrera> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Carrera> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Carrera> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Carrera> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<Carrera> findAll() {
        return null;
    }

    @Override
    public List<Carrera> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Carrera entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Carrera> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Carrera> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Carrera> findAll(Pageable pageable) {
        return null;
    }
}

package com.arquitecturasWeb.Integrador3.services;

import com.arquitecturasWeb.Integrador3.entities.Estudiante;
import com.arquitecturasWeb.Integrador3.repositories.StudentRepository;
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

@Service("StudentService")
public class StudentService implements JpaRepository<Estudiante, Long> {
    @Autowired
    private StudentRepository repository;

    @Override
    public void flush() {

    }

    @Override
    public <S extends Estudiante> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Estudiante> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Estudiante> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Estudiante getOne(Long aLong) {
        return null;
    }

    @Override
    public Estudiante getById(Long aLong) {
        return null;
    }

    @Override
    public Estudiante getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Estudiante> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Estudiante> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Estudiante> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Estudiante> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Estudiante> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Estudiante> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Estudiante, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Estudiante> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Estudiante> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Estudiante> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<Estudiante> findAll() {
        return null;
    }

    @Override
    public List<Estudiante> findAllById(Iterable<Long> longs) {
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
    public void delete(Estudiante entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Estudiante> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Estudiante> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Estudiante> findAll(Pageable pageable) {
        return null;
    }
}

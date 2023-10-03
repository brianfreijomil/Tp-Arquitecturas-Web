package com.arquitecturasWeb.Integrador3.services;

import com.arquitecturasWeb.Integrador3.domain.Career;
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
public class CareerService implements JpaRepository<Career, Long> {

    @Autowired
    private CareerRepository repository;


    @Override
    public void flush() {

    }

    @Override
    public <S extends Career> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Career> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Career getOne(Long aLong) {
        return null;
    }

    @Override
    public Career getById(Long aLong) {
        return null;
    }

    @Override
    public Career getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Career> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Career> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Career> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Career> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Career> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Career> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Career, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Career> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Career> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Career> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Career> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<Career> findAll() {
        return null;
    }

    @Override
    public List<Career> findAllById(Iterable<Long> longs) {
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
    public void delete(Career entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Career> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Career> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Career> findAll(Pageable pageable) {
        return null;
    }
}

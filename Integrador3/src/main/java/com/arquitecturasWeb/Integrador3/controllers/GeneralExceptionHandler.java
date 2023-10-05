package com.arquitecturasWeb.Integrador3.controllers;

import com.arquitecturasWeb.Integrador3.service.exception.ConflictExistException;
import com.arquitecturasWeb.Integrador3.service.exception.ErrorDTO;
import com.arquitecturasWeb.Integrador3.service.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;


@RestControllerAdvice(basePackages = "com.arquitecturasWeb.Integrador3.controllers")
public class GeneralExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity notFoundException(NotFoundException exception) {
        return new ResponseEntity(new ErrorDTO(exception.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ConflictExistException.class)
    public ResponseEntity conflictExistException(ConflictExistException exception) {
        return new ResponseEntity(new ErrorDTO(exception.getMessage()), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class) //MethodArgumentNotValidException, receives the exception of validations
    public ResponseEntity constraintViolationException(MethodArgumentNotValidException exc){
        /*create the array to store the messages of the fields that failed validation*/
        List<String> errors = new ArrayList<String>();
        /*first I get the BindingResult. second I get the list of FieldError*/
        List<FieldError> ex = exc.getBindingResult().getFieldErrors();
        /*for each FieldError, I get the defaultMessage which is a string and add it to the error list*/
        for(FieldError fe : ex){
            errors.add(fe.getDefaultMessage());
        }
        return new ResponseEntity(errors, HttpStatus.BAD_REQUEST);
    }
}
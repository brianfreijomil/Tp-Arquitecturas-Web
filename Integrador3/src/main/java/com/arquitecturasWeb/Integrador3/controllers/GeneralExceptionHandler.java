package com.arquitecturasWeb.Integrador3.controllers;

import com.arquitecturasWeb.Integrador3.service.exception.ErrorDTO;
import com.arquitecturasWeb.Integrador3.service.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackages = "com.arquitecturasWeb.Integrador3.controllers")
public class GeneralExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity notFoundException(NotFoundException exception) {
        return new ResponseEntity(new ErrorDTO(exception.getMessage()), HttpStatus.NOT_FOUND);
    }
}

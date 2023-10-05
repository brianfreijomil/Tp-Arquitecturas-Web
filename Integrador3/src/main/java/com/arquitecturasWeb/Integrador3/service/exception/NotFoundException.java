package com.arquitecturasWeb.Integrador3.service.exception;

import lombok.Getter;

@Getter
public class NotFoundException extends RuntimeException {

    private String message;
    public NotFoundException(String message) {
        this.message = message;
    }
}

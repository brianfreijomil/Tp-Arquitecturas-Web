package com.arquitecturasWeb.Integrador3.service.exception;

public class ConflictExistException extends RuntimeException {

    private String message;
    public ConflictExistException(String entidad, String attribute, Long id) {
        this.message = String.format("There is already a %s entity with %s %s.", entidad, attribute, id);
    }

    public String getMessage() {
        return message;
    }

}

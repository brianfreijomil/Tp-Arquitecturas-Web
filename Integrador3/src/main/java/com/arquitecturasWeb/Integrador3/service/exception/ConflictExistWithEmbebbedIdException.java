package com.arquitecturasWeb.Integrador3.service.exception;


public class ConflictExistWithEmbebbedIdException extends RuntimeException{

    private String message;
    public ConflictExistWithEmbebbedIdException(String entidad, String entidad2, String attribute, String attribute2, int studentId, long careerId) {
        this.message = String.format("There is already a %s entity with %s %s.",
                                        "entity: " + entidad, "attribute: "+ attribute, "value: "+studentId, "\n" +
                                        "entity: " + entidad2, "attribute: " + attribute2, "value: " + careerId);
    }
    public String getMessage() {
        return message;
    }

}



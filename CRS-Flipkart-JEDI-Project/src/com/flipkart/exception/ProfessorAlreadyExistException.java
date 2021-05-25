package com.flipkart.exception;

public class ProfessorAlreadyExistException extends Exception{
    private String profId;

    public ProfessorAlreadyExistException(String profId) {
        this.profId = profId;
    }

    @Override
    public String getMessage() {
        return "Professor with " + this.profId + " already exists.";
    }
}

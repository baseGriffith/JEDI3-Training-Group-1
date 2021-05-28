package com.flipkart.exception;

public class ProfessorAlreadyExistException extends Exception{
    private int profId;

    public ProfessorAlreadyExistException(int profId) {
        this.profId = profId;
    }

    @Override
    public String getMessage() {
        return "Professor with " + this.profId + " already exists.";
    }
}

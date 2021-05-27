package com.flipkart.exception;

public class ProfessorDoesNotExistException extends Exception{
    private String professorId;

    public ProfessorDoesNotExistException(String professorId) {
        this.professorId = professorId;
    }

    @Override
    public String getMessage() {
        return "Professor with Id " + this.professorId + " does not exist!";
    }
}

package com.flipkart.exception;

public class StudentAlreadyExistsException extends Exception{
    private String studentId;

    public StudentAlreadyExistsException(String studentId) {
        this.studentId = studentId;
    }

    @Override
    public String getMessage() {
        return "Student with Id " + this.studentId + " already exists!";
    }
}

package com.flipkart.exception;

public class StudentAlreadyExistsException extends Exception{
    private int studentId;

    public StudentAlreadyExistsException(int studentId) {
        this.studentId = studentId;
    }

    public String getMessage() {
        return "Student with id " + this.studentId + " already exists";
    }
}

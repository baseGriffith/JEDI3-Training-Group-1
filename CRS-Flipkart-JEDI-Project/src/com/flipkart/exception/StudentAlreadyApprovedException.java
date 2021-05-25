package com.flipkart.exception;

public class StudentAlreadyApprovedException extends Exception{
    private String studentId;

    public StudentAlreadyApprovedException(String studentId) {
        this.studentId = studentId;
    }

    @Override
    public String getMessage() {
        return "Student with Id " + this.studentId + " already exists!";
    }
}

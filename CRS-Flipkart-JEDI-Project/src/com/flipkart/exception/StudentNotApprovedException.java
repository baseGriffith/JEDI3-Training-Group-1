package com.flipkart.exception;

public class StudentNotApprovedException extends Exception{
    private String studentId;

    public StudentNotApprovedException(String studentId) {
        this.studentId = studentId;
    }

    @Override
    public String getMessage() {
        return "Student with Id " + this.studentId + " is not approved!";
    }
}

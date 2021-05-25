package com.flipkart.exception;

public class StudentRegistrationFailedException extends Exception{
    private String studentId;

    public StudentRegistrationFailedException(String studentId) {
        this.studentId = studentId;
    }

    @Override
    public String getMessage() {
        return "Student " + this.studentId + " registration failed!";
    }
}

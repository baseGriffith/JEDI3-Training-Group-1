package com.flipkart.exception;

public class StudentRegistrationFailedException extends Exception{
    private int studentId;

    public StudentRegistrationFailedException(int studentId) {
        this.studentId = studentId;
    }

    @Override
    public String getMessage() {
        return "Student " + this.studentId + " registration failed!";
    }
}

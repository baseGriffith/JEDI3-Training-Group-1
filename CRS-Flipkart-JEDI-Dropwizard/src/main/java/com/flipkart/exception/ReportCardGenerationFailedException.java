package com.flipkart.exception;

public class ReportCardGenerationFailedException extends Exception{
    private int studentId;

    public ReportCardGenerationFailedException(int studentId) {
        this.studentId = studentId;
    }

    @Override
    public String getMessage() {
        return "Report card generation for student " + this.studentId + " failed!";
    }
}

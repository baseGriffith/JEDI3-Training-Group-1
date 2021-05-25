package com.flipkart.exception;

public class ReportCardGenerationFailedException extends Exception{
    private String studentId;

    public ReportCardGenerationFailedException(String studentId) {
        this.studentId = studentId;
    }

    @Override
    public String getMessage() {
        return "Report card generation for student " + this.studentId + " failed!";
    }
}

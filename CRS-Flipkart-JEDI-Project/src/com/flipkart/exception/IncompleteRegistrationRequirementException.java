package com.flipkart.exception;

public class IncompleteRegistrationRequirementException extends Exception{
    private String studentId;
    private String courseId;

    public IncompleteRegistrationRequirementException(String studentId, String courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }

    @Override
    public String getMessage() {
        return "The student " + this.studentId + " cannot be registered to the course " + this.courseId + " due to incomplete registration requirements!";
    }
}

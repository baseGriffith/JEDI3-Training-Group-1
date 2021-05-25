package com.flipkart.exception;

public class GradeNotAssignedException extends Exception{
    private String studentId;
    private String courseId;

    public GradeNotAssignedException(String studentId, String courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }

    @Override
    public String getMessage() {
        return "The student " + this.studentId + " has no grade assigned to them in the course " + this.courseId + "!";
    }
}

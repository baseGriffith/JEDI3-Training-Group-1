package com.flipkart.exception;

public class GradeNotAssignedException extends Exception{
    private int studentId;
    private int courseId;

    public GradeNotAssignedException(int studentId, int courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }

    @Override
    public String getMessage() {
        return "The student " + this.studentId + " has no grade assigned to them in the course " + this.courseId + "!";
    }
}

package com.flipkart.exception;

public class CourseAlreadyRegisteredException extends Exception{
    private int courseId;
    private int studentId;

    public CourseAlreadyRegisteredException(int courseId, int studentId) {
        this.courseId = courseId;
        this.studentId = studentId;
    }

    @Override
    public String getMessage() {
        return "The student " + this.studentId + " is already registered to the course " + this.courseId + "!";
    }
}

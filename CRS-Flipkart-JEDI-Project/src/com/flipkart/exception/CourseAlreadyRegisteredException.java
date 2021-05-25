package com.flipkart.exception;

public class CourseAlreadyRegisteredException extends Exception{
    private String courseId;
    private String studentId;

    public CourseAlreadyRegisteredException(String courseId, String studentId) {
        this.courseId = courseId;
        this.studentId = studentId;
    }

    @Override
    public String getMessage() {
        return "The student " + this.studentId + " is already registered to the course " + this.courseId + "!";
    }
}

package com.flipkart.exception;

public class CourseNotFoundException extends Exception{
    private String courseId;

    public CourseNotFoundException(String courseId) {
        this.courseId = courseId;
    }

    @Override
    public String getMessage() {
        return "The course " + this.courseId + " cannot be found!";
    }
}

package com.flipkart.exception;

public class CourseNotFoundException extends Exception{
    private int courseId;

    public CourseNotFoundException(int courseId) {
        this.courseId = courseId;
    }

    @Override
    public String getMessage() {
        return "The course " + this.courseId + " cannot be found!";
    }
}

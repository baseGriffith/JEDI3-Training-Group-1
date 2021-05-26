package com.flipkart.exception;

public class CourseAlreadyExistsException extends Exception{
    private int courseId;

    public CourseAlreadyExistsException(int courseId) {
        this.courseId = courseId;
    }

    @Override
    public String getMessage() {
        return "The course " + this.courseId + " already exists!";
    }
}

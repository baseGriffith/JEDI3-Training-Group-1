package com.flipkart.exception;

public class CourseAlreadyFullException extends Exception{
    private String courseId;

    public CourseAlreadyFullException(String courseId) {
        this.courseId = courseId;
    }

    @Override
    public String getMessage() {
        return "The course " + this.courseId + " is already full!";
    }
}

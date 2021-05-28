package com.flipkart.exception;

public class CourseAlreadyFullException extends Exception{
    private int courseId;

    public CourseAlreadyFullException(int courseId) {
        this.courseId = courseId;
    }

    @Override
    public String getMessage() {
        return "The course " + this.courseId + " is already full!";
    }
}

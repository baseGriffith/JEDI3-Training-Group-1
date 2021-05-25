package com.flipkart.exception;

public class CourseAlreadyBeingTaughtException extends Exception{
    private String courseId;
    private String professorId;

    public CourseAlreadyBeingTaughtException(String courseId, String professorId) {
        this.courseId = courseId;
        this.professorId = professorId;
    }

    @Override
    public String getMessage() {
        return "Course " + this.courseId + " already taught by professor " + this.professorId;
    }

}

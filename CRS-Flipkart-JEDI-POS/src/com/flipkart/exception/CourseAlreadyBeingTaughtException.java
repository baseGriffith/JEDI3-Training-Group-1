package com.flipkart.exception;

public class CourseAlreadyBeingTaughtException extends Exception{
    private int courseId;
    private int professorId;

    public CourseAlreadyBeingTaughtException(int courseId, int professorId) {
        this.courseId = courseId;
        this.professorId = professorId;
    }

    @Override
    public String getMessage() {
        return "Course " + this.courseId + " already taught by professor " + this.professorId;
    }

}

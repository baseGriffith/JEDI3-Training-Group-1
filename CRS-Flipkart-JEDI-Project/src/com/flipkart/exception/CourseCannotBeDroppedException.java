package com.flipkart.exception;

public class CourseCannotBeDroppedException extends Exception{
    private String courseId;
    private String studentId;

    public CourseCannotBeDroppedException(String courseId, String studentId) {
        this.courseId = courseId;
        this.studentId = studentId;
    }

    @Override
    public String getMessage() {
        return "The student " + this.studentId + " cannot drop the course " + this.courseId + "!";
    }
}

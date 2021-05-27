package com.flipkart.exception;

public class EnrollmentFailedException extends Exception{
    public String studentId;
    public String courseId;

    public EnrollmentFailedException(String studentId, String courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }

    @Override
    public String getMessage() {
        return "The student " + this.studentId + " failed to enroll in the course " + this.courseId + "!";
    }
}

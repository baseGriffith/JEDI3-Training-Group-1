package com.flipkart.dao;

import java.util.ArrayList;

import com.flipkart.exception.CourseAlreadyBeingTaughtException;

public interface ProfessorDaoInterface {
    /**
     *
     * @param courseId
     */
    void signupCourse(int professorId, int courseId)  throws CourseAlreadyBeingTaughtException;


    void gradeCourse(int studentId, int courseId, String grade);



    /**
     *
     * @param courseId
     * @return
     */
    ArrayList<Integer> getEnrolledStudents(int courseId);

}

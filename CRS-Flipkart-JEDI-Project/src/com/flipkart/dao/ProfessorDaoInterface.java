package com.flipkart.dao;

import java.util.ArrayList;

public interface ProfessorDaoInterface {
    /**
     *
     * @param courseId
     */
    void signupCourse(int professorId, int courseId);


    void gradeCourse(int studentId, int courseId, String grade);



    /**
     *
     * @param courseId
     * @return
     */
    ArrayList<Integer> getEnrolledStudents(int courseId);

}

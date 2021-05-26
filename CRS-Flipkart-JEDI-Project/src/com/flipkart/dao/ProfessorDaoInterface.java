package com.flipkart.dao;

import java.util.ArrayList;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.exception.CourseAlreadyBeingTaughtException;

public interface ProfessorDaoInterface {
    /**
     *
     * @param courseId
     */
    void signupCourse(int professorId, int courseId)  throws CourseAlreadyBeingTaughtException;


    void gradeCourse(int studentId, int courseId, String grade);

    ArrayList <Course> getProfessorRegisteredCourses(int professorId);

    /**
     *
     * @param courseId
     * @return
     */
    ArrayList<Student> getEnrolledStudents(int courseId);

}

package com.flipkart.dao;
/**
 * @author JEDI-Group-1
 */
import java.util.ArrayList;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.exception.CourseAlreadyBeingTaughtException;

public interface ProfessorDaoInterface {
    /**
     *Signs up courses for the professor to teach
     *
     * @param courseId
     */
    void signupCourse(int professorId, int courseId)  throws CourseAlreadyBeingTaughtException;

    /**
     * Used by professor for grading a student
     * 
     * @param studentId
     * @param courseId
     * @param grade
     */
    void gradeCourse(int studentId, int courseId, String grade);

    /**
     * Returns a list of courses signed up by the professor to teach
     * 
     * @param professorId
     * @return
     */
    ArrayList <Course> getProfessorRegisteredCourses(int professorId);

    /**
     *Returns a list of students enrolled in the courses signed up by the professor
     *
     * @param courseId
     * @return
     */
    ArrayList<Student> getEnrolledStudents(int courseId);

}

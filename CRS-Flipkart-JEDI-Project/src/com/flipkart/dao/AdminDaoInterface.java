package com.flipkart.dao;

import com.flipkart.bean.Course;
import com.flipkart.bean.Grade;
import com.flipkart.bean.Professor;

import java.util.ArrayList;

/**
 *Interfaces with the database to execute Admin operations.
 */
public interface AdminDaoInterface {
    /**
     *Approves a new student account registration and writes it to the database
     * @param studentId
     */
    void approveStudent(int studentId); // verify whether

    /**
     *Adds a new professor into the database
     * @param professor
     * @return boolean
     */
    boolean addProfessor(Professor professor);

    /**
     *Adds a new course to the course catalogue
     * @param course
     * @return boolean
     */
    boolean addCourse(Course course);

    /**
     *Removes a course from the course catalogue
     * @param courseId
     * @return boolean
     */
    boolean removeCourse(int courseId);

    /**
     *Fetches a students grade's for their registered courses from the database
     * @param studentId
     * @return ArrayList<Grade>
     */
    ArrayList<Grade> fetchGrade(int studentId);

    /**
     *Modifies the details of a course and saves it to the database
     * @param course
     * @return boolean
     */
    boolean modifyCourseDetails(Course course);

}

package com.flipkart.dao;

import com.flipkart.bean.Course;
import com.flipkart.bean.Grade;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;

public interface AdminDaoInterface {
    /**
     *
     * @param studentId
     */
    void approveStudent(int studentId); // verify whether

    /**
     *
     * @param professor
     */
    void addProfessor(Professor professor);

    /**
     *
     * @param course
     */
    void addCourse(Course course);

    /**
     *
     * @param courseId
     */
    void removeCourse(int courseId);

    /**
     *
     * @param studentId
     * @return
     */
    Grade[] fetchGrade(int studentId);

}

package com.flipkart.dao;

/**
 * @author JEDI-Group-1
 */
import com.flipkart.bean.Course;
import com.flipkart.bean.Grade;
import com.flipkart.bean.Professor;

import java.util.ArrayList;

public interface AdminDaoInterface {
    /**
     *
     * @param studentId
     */
    void approveStudent(int studentId); // verify whether

    /**
     *
     * @param professor
     * @return
     */
    boolean addProfessor(Professor professor);

    /**
     *
     * @param course
     * @return
     */
    boolean addCourse(Course course);

    /**
     *
     * @param courseId
     * @return
     */
    boolean removeCourse(int courseId);

    /**
     *
     * @param studentId
     * @return
     */
    ArrayList<Grade> fetchGrade(int studentId);

    /**
     *
     * @param course
     * @return
     */
    boolean modifyCourseDetails(Course course);

}

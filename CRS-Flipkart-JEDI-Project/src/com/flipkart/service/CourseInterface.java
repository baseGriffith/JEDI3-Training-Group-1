package com.flipkart.service;

/**
 * @author JEDI-Group-1
 */
import com.flipkart.bean.Course;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.ProfessorDoesNotExistException;

public interface CourseInterface {
    /**
     * Modify details fo a course in course catalog
     * @param modifiedCourse
     * @throws CourseNotFoundException
     */
    public void modifyDetails(Course modifiedCourse) throws CourseNotFoundException;

    /**
     * Allot a professor to a course
     * @param professorId
     * @throws ProfessorDoesNotExistException
     */
    public void allotProfessor(String professorId) throws ProfessorDoesNotExistException;

    /**
     * Get sprcific course details
     * @return
     * @throws CourseNotFoundException
     */
    public String getCourseDetails() throws CourseNotFoundException;
}

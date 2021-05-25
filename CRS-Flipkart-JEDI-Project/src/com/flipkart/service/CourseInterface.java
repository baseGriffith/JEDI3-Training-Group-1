package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.ProfessorDoesNotExistException;

public interface CourseInterface {
    public void modifyDetails(Course modifiedCourse) throws CourseNotFoundException;

    public void allotProfessor(String professorId) throws ProfessorDoesNotExistException;

    public String getCourseDetails() throws CourseNotFoundException;
}

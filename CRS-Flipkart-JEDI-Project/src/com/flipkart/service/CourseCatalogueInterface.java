package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.exception.CourseAlreadyExistsException;
import com.flipkart.exception.CourseNotFoundException;

public interface CourseCatalogueInterface {
	
    /**
     * Admin adds a new course to the course catalog
     * @param newCourse
     * @throws CourseAlreadyExistsException
     */
    public void addCourse(Course newCourse) throws CourseAlreadyExistsException;

    
    /**
     * Admin removes a course from course catalog
     * @param courseId
     * @throws CourseNotFoundException
     */
    public void deleteCourse(String courseId) throws CourseNotFoundException;
}

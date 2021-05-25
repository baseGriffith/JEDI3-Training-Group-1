package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.exception.CourseAlreadyExistsException;
import com.flipkart.exception.CourseNotFoundException;

public interface CourseCatalogueInterface {
    public void addCourse(Course newCourse) throws CourseAlreadyExistsException;

    public void deleteCourse(String courseId) throws CourseNotFoundException;
}

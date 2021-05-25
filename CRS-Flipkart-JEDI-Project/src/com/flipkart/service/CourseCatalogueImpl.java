package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.exception.CourseAlreadyExistsException;
import com.flipkart.exception.CourseNotFoundException;

public class CourseCatalogueImpl implements CourseCatalogueInterface {
    public void addCourse(Course newCourse) throws CourseAlreadyExistsException{
        System.out.println("Course successfully added!");
    }

    public void deleteCourse(String courseId) throws CourseNotFoundException{
        System.out.println("Course successfully deleted!");
    }
}

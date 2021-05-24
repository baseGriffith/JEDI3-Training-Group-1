package com.flipkart.service;

import com.flipkart.bean.Course;

public class CourseCatalogueImpl implements CourseCatalogueInterface {
    public void addCourse(Course newCourse){
        System.out.println("Course successfully added!");
    }

    public void deleteCourse(String courseId){
        System.out.println("Course successfully deleted!");
    }
}

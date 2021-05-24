package com.flipkart.service;

import com.flipkart.bean.Course;

public interface CourseCatalogueInterface {
    public void addCourse(Course newCourse);

    public void deleteCourse(String courseId);
}

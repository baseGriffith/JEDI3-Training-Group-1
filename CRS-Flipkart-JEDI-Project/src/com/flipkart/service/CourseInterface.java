package com.flipkart.service;

import com.flipkart.bean.Course;

public interface CourseInterface {
    public void modifyDetails(Course modifiedCourse);

    public void allotProfessor(String professorId);

    public String getCourseDetails();
}

package com.flipkart.service;

import com.flipkart.bean.Course;

public class CourseImpl implements CourseInterface {
    public void modifyDetails(Course modifiedCourse){
        System.out.println("Course details modified!");
    }

    public void allotProfessor(String professorId){
        System.out.println("Professor allotted to course");
    }

    public String getCourseDetails(){
        System.out.println("Details of the course are: ------------");
        return "";
    }
}

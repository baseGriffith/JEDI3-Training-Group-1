package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.ProfessorDoesNotExistException;

public class CourseOperation implements CourseInterface {
    public void modifyDetails(Course modifiedCourse)  throws CourseNotFoundException{
        System.out.println("Course details modified!");
    }

    public void allotProfessor(String professorId) throws ProfessorDoesNotExistException{
        System.out.println("Professor allotted to course");
    }

    public String getCourseDetails()  throws CourseNotFoundException{
        System.out.println("Details of the course are: ------------");
        return "";
    }
}

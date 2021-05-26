package com.flipkart.service;

import java.util.ArrayList;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.exception.*;

public interface ProfessorInterface {
	
	
	/**
	 * Grade a student using RegisteredCourse and Grade class
	 * @param courseId
	 * @param studentId
	 * @param gradeAlloted
	 */
	public void gradeStudent(int courseId,int studentId,String gradeAlloted);
	
	
	/**
	 * Enroll a professor for teaching a course
	 * @param courseId
	 * @return boolean indicating if professor was registered to a course or not
	 * @throws CourseNotFoundException 
	 */
	public boolean registerCourse(int professorId, int courseId) throws CourseAlreadyBeingTaughtException, CourseNotFoundException;
	
	
	/**
	 * Professor enters the course Id and the enrolled students are returned
	 * @param courseId
	 * @return list of students enrolled in a course
	 */
	public ArrayList<Student> getEnrolledStudents(int courseId) throws CourseNotFoundException;
	
	
	public ArrayList<Course> getProfessorRegisteredCourses(int professorId);
}

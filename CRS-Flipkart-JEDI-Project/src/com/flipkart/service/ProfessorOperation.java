
package com.flipkart.service;

import java.util.ArrayList;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.exception.*;
import com.flipkart.dao.*;

public class ProfessorOperation implements ProfessorInterface {

	@Override
	public void gradeStudent(int courseId, int studentId, String gradeAlloted) {
		
		ProfessorDaoImpl p = new ProfessorDaoImpl();
		p.gradeCourse(studentId, courseId, gradeAlloted);
		System.out.println("Student graded");

	}

	@Override
	public boolean registerCourse(int professorId, int courseId) throws CourseAlreadyBeingTaughtException, CourseNotFoundException {
		
		try{
			ProfessorDaoImpl p = new ProfessorDaoImpl();
			p.signupCourse(professorId, courseId);
			return true;
		}
		catch(Exception e) {
			throw new CourseAlreadyBeingTaughtException(courseId, professorId);			
		}
	
	}

	@Override
	public ArrayList<Student> getEnrolledStudents(int courseId) throws CourseNotFoundException {
		try{
			ProfessorDaoImpl p = new ProfessorDaoImpl();
			return p.getEnrolledStudents(courseId);
		}
		catch(Exception e) {
			throw new CourseNotFoundException(courseId);
		}
	}

	@Override
	public ArrayList<Course> getProfessorRegisteredCourses(int professorId) {
		// TODO Auto-generated method stub
		try{
			ProfessorDaoImpl p = new ProfessorDaoImpl();
			return p.getProfessorRegisteredCourses(professorId);
		}
		catch(Exception e) {
			//throw new CourseNotFoundException(courseId);
		}
		return null;
	}

}

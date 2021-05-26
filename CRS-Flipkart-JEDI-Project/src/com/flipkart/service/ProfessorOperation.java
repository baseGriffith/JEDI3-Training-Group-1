
package com.flipkart.service;

import java.util.ArrayList;

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
	public ArrayList<Integer> getEnrolledStudents(int courseId) throws CourseNotFoundException {
		try{
			ProfessorDaoImpl p = new ProfessorDaoImpl();
			return p.getEnrolledStudents(courseId);
		}
		catch(Exception e) {
			throw new CourseNotFoundException(courseId);
		}
	}

}

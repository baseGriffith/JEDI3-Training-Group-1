/**
 * 
 */
package com.flipkart.service;

import com.flipkart.bean.Student;
import com.flipkart.exception.CourseAlreadyRegisteredException;
import com.flipkart.exception.CourseNotFoundException;

/**
 * @author dhruv
 *
 */
public class ProfessorOperation implements ProfessorInterface {

	@Override
	public void gradeStudent(int courseId, int studentId, char gradeAlloted) {
		// TODO Auto-generated method stub
		System.out.println("Student graded");

	}

	@Override
	public boolean registerCourse(int courseId) throws CourseAlreadyRegisteredException, CourseNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("Course registered");
		return false;
	}

	@Override
	public Student[] getEnrolledStudents(int courseId) {
		// TODO Auto-generated method stub
		System.out.println("Enrolled students are ---- .");
		return null;
	}

}

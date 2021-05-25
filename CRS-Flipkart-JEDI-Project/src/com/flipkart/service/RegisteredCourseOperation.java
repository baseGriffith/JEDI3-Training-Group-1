/**
 * 
 */
package com.flipkart.service;

import com.flipkart.dao.RegistrationDaoImpl;
import com.flipkart.dao.RegistrationDaoInterface;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.GradeNotAssignedException;

/**
 * @author Nayan
 *
 */
public class RegisteredCourseOperation implements RegisteredCourseInterface {
		
	@Override
	public boolean dropCourse(int studentId, int courseId) throws CourseNotFoundException {
		// TODO Auto-generated method stub
		try {
			RegistrationDaoInterface semesterRegistration = new RegistrationDaoImpl();
			if(semesterRegistration.dropCourse(studentId, courseId)) {
				System.out.println("Course dropped");
				return true;
			}
			else throw new CourseNotFoundException(courseId); 
		} catch(CourseNotFoundException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public String viewGrade(int studentId, int courseId) throws GradeNotAssignedException {
		// TODO Auto-generated method stub
		try {
			RegistrationDaoInterface semesterRegistration = new RegistrationDaoImpl();
			
			String grade = semesterRegistration.getRegisteredCourse(studentId, courseId).getGrade();
			
			if(grade.equals("NA")) throw new GradeNotAssignedException(studentId, courseId);
			return grade; 	
		} catch(GradeNotAssignedException e){
			return e.getMessage();
		}
	}
}

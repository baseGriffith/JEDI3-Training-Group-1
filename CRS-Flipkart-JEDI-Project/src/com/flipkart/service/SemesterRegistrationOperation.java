/**
 * 
 */
package com.flipkart.service;

import com.flipkart.exception.CourseAlreadyRegisteredException;
import com.flipkart.exception.StudentRegistrationFailedException;

/**
 * @author nayan
 *
 */
public class SemesterRegistrationOperation implements SemesterRegistrationInterface {

	@Override
	public boolean register(String rollNumber, int semester) throws StudentRegistrationFailedException{
		// TODO Auto-generated method stub
		System.out.println("registration successful");
		return false;
	}

	@Override
	public boolean addCourse(String rollNumber, int courseId, int semester) throws CourseAlreadyRegisteredException {
		// TODO Auto-generated method stub
		System.out.println("student succesfully enrolled in the course");
		return false;
	}

	@Override
	public boolean dropCourse(String rollNumber, int courseId, int semester) {
		// TODO Auto-generated method stub
		System.out.println("Course succesfully droped the course");
		return false;
	}

	@Override
	public boolean checkStatus(String rollNumber, int semester) {
		// TODO Auto-generated method stub
		System.out.println("Registration completed");
		return false;
	}

	@Override
	public void showRegisteredCourses(String rollNumber, int semester) {
		// TODO Auto-generated method stub
		System.out.println("Registered courses are  ________");
		
	}
	
}

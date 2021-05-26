/**
 * 
 */
package com.flipkart.service;

import java.util.ArrayList;

import com.flipkart.bean.RegisteredCourse;
import com.flipkart.dao.RegistrationDaoImpl;
import com.flipkart.dao.RegistrationDaoInterface;
import com.flipkart.exception.CourseAlreadyFullException;
import com.flipkart.exception.CourseAlreadyRegisteredException;

/**
 * @author JEDI-Group-1
 * 
 */
public class SemesterRegistrationOperation implements SemesterRegistrationInterface {

	@Override
	public boolean addCourse(int studentId, int courseId) throws CourseAlreadyRegisteredException, CourseAlreadyFullException {
		// TODO Auto-generated method stub
		try {
			RegistrationDaoInterface semesterRegistration = new RegistrationDaoImpl();
			
			if(semesterRegistration.addCourse(courseId, studentId) == 2) {
				return true;
			}
			else if(semesterRegistration.addCourse(courseId, studentId) == 0) {
				throw new CourseAlreadyRegisteredException(courseId, studentId);
			}
			else {
				throw new CourseAlreadyFullException(courseId);
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean dropCourse(int studentId, int courseId) {
		// TODO Auto-generated method stub

		RegistrationDaoInterface semesterRegistration = new RegistrationDaoImpl();
		if(semesterRegistration.dropCourse(courseId, studentId)) {
			return true;
		};
		
		return false;
	}

	@Override
	public boolean showRegisteredCourses(int studentId, int semester) {
		// TODO Auto-generated method stub
		
		RegistrationDaoInterface semesterRegistration = new RegistrationDaoImpl();
		
		ArrayList<RegisteredCourse> registeredCourses = semesterRegistration.viewRegisteredCourses(studentId, semester);
		
		System.out.println("Registered Courses in "+semester+" semester:-->");
		
		for(RegisteredCourse registeredCourse : registeredCourses) {
			System.out.println("CourseId: "+registeredCourse.getCourseId()+"  CourseName: "+registeredCourse.getCourseName()+"  Grade: "+registeredCourse.getGrade());
		}
		return true;
	}
	
}

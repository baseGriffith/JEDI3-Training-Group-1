/**
 * 
 */
package com.flipkart.service;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.flipkart.bean.RegisteredCourse;
import com.flipkart.dao.RegistrationDaoImpl;
import com.flipkart.dao.RegistrationDaoInterface;
import com.flipkart.exception.CourseAlreadyFullException;
import com.flipkart.exception.CourseAlreadyRegisteredException;

/**
 * @author JEDI-Group1
 *
 */
public class SemesterRegistrationOperation implements SemesterRegistrationInterface {

	private static Logger logger = Logger.getLogger(AdminOperation.class);
	
	@Override
	public boolean addCourse(int studentId, int courseId) throws CourseAlreadyRegisteredException, CourseAlreadyFullException {
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
			return false;
		}
	}

	@Override
	public boolean dropCourse(int studentId, int courseId) {

		RegistrationDaoInterface semesterRegistration = new RegistrationDaoImpl();
		if(semesterRegistration.dropCourse(courseId, studentId)) {
			return true;
		};
		
		return false;
	}

	@Override
	public boolean showRegisteredCourses(int studentId, int semester) {
		
		RegistrationDaoInterface semesterRegistration = new RegistrationDaoImpl();
		
		ArrayList<RegisteredCourse> registeredCourses = semesterRegistration.viewRegisteredCourses(studentId, semester);
		logger.info("Registered Courses in " + semester + " semester:-->");
		
		for(RegisteredCourse registeredCourse : registeredCourses) {
			logger.info("CourseId: "+registeredCourse.getCourseId()+"  CourseName: "+registeredCourse.getCourseName()+"  Grade: "+registeredCourse.getGrade());
		}
		return true;
	}
	
}

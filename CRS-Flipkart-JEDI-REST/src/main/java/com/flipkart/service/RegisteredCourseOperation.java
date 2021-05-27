/**
 * 
 */
package com.flipkart.service;

import org.apache.log4j.Logger;

/**
 * @author JEDI-Group1
 *
 */

import com.flipkart.dao.RegistrationDaoImpl;
import com.flipkart.dao.RegistrationDaoInterface;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.GradeNotAssignedException;


public class RegisteredCourseOperation implements RegisteredCourseInterface {
	
		private static volatile RegisteredCourseOperation instance = null;
	 
    // private constructor
    private RegisteredCourseOperation() {
    }
 
    public static RegisteredCourseOperation getInstance() {
        if (instance == null) {
            synchronized (RegisteredCourseOperation.class) {
                instance = new RegisteredCourseOperation();
            }
        }
        return instance;
    }
	
	private static Logger logger = Logger.getLogger(AdminOperation.class);
	
	@Override
	public boolean dropCourse(int studentId, int courseId) throws CourseNotFoundException {
		try {
			RegistrationDaoInterface semesterRegistration =  RegistrationDaoImpl.getInstance();

			if(semesterRegistration.dropCourse(studentId, courseId)) {
				logger.info("Course dropped");
				return true;
			}
			else throw new CourseNotFoundException(courseId); 
		} catch(CourseNotFoundException e) {
			return false;
		}
	}

	@Override
	public String viewGrade(int studentId, int courseId) throws GradeNotAssignedException {
		try {

			RegistrationDaoInterface semesterRegistration =  RegistrationDaoImpl.getInstance();
			
			String grade = semesterRegistration.getRegisteredCourse(studentId, courseId).getGrade();
			
			if(grade.equals("NA")) throw new GradeNotAssignedException(studentId, courseId);
			return grade; 	
		} catch(GradeNotAssignedException e){
			return e.getMessage();
		}
	}

}

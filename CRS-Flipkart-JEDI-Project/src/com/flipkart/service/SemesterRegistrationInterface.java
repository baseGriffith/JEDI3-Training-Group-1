/**
 * 
 */
package com.flipkart.service;

import com.flipkart.exception.CourseAlreadyFullException;
import com.flipkart.exception.CourseAlreadyRegisteredException;
import com.flipkart.exception.StudentRegistrationFailedException;

/**
 * @author nayan
 * 
 */
public interface SemesterRegistrationInterface {
	
	/** To request a course
	 * @param rollNumber
	 * @param courseId
	 * @param semester
	 * @return
	 */
	
	public boolean addCourse(int studentId, int courseId) throws CourseAlreadyRegisteredException, CourseAlreadyFullException;
	
	/** To drop a course 
	 * @param rollNumber
	 * @param courseId
	 * @param semester
	 * @return
	 */
	public boolean dropCourse(int studentId, int courseId);

	/** print list of courses in which the student is enrolled 
	 * @param rollNumber
	 * @param semester
	 */
	public boolean showRegisteredCourses(int studentId, int semester);
	
}

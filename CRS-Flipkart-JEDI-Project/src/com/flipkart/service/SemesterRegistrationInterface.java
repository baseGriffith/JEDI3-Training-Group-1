/**
 * 
 */
package com.flipkart.service;

import com.flipkart.exception.CourseAlreadyFullException;
import com.flipkart.exception.CourseAlreadyRegisteredException;
import com.flipkart.exception.StudentRegistrationFailedException;

/**
 * Class used for services for registered courses
 * @author JEDI-Group1
 *
 */
public interface SemesterRegistrationInterface {
	
	/**
	 * 
	 * @param studentId
	 * @param courseId
	 * @return whether the course has been added or not 
	 * @throws CourseAlreadyRegisteredException
	 * @throws CourseAlreadyFullException
	 */
	
	public boolean addCourse(int studentId, int courseId) throws CourseAlreadyRegisteredException, CourseAlreadyFullException;
	
	/** To drop a course 
	 * @param rollNumber
	 * @param courseId
	 * @param semester
	 * @return whether the course has been dropped or not
	 */
	public boolean dropCourse(int studentId, int courseId);

	
	/**
	 * prints the list of courses registered by the student
	 * @param studentId
	 * @param semester
	 * @return whether the list has been returned or not
	 */
	public boolean showRegisteredCourses(int studentId, int semester);
	
}

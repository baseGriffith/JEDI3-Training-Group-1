/**
 * 
 */
package com.flipkart.service;

import com.flipkart.bean.Student;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.GradeNotAssignedException;

/**
 * @author JEDI-Group-1
 * 
 */
public interface RegisteredCourseInterface {
	/** To drop a course 
	 * @param studentId
	 * @param courseId
	 * @return
	 */
	public boolean dropCourse(int studentId, int courseId) throws CourseNotFoundException;
	
	/** To view grade in a course
	 * @param studentId
	 * @return
	 */
	public String viewGrade(int studentId, int courseId) throws GradeNotAssignedException;
	
}

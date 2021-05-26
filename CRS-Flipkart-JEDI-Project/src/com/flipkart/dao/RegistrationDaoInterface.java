package com.flipkart.dao;

/**
 * @author JEDI-Group-1
 */
import java.util.ArrayList;

import com.flipkart.bean.RegisteredCourse;

public interface RegistrationDaoInterface {
	/**
	 * Adds a course for the student for registration
	 * 
	 * @param courseId
	 * @param studentId
	 * @param courseName
	 * @return
	 */
	int addCourse(int courseId, int studentId);
	/**
	 * Drops a course while semester registration
	 * 
	 * @param courseId
	 * @param studentId
	 * @return
	 */
	boolean dropCourse(int courseId, int studentId);
	/**
	 * Returns a list of registered courses taken by a student
	 * 
	 * @param studentId
	 * @return
	 */
	ArrayList<RegisteredCourse> viewRegisteredCourses(int studentId, int semester);
	
	/**
	 * Returns a registered course using the student and course id
	 * 
	 * @param studentId
	 * @param courseId
	 * @return
	 */
	RegisteredCourse getRegisteredCourse(int studentId, int courseId);
	
	
	
}

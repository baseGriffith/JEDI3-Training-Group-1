package com.flipkart.dao;

import java.util.ArrayList;

import com.flipkart.bean.RegisteredCourse;

public interface RegistrationDaoInterface {
	/**
	 * 
	 * @param courseId
	 * @param studentId	
	 * @return
	 */
	int addCourse(int courseId, int studentId);
	/**
	 * 
	 * @param courseId
	 * @param studentId
	 * @return
	 */
	boolean dropCourse(int courseId, int studentId);
	/**
	 * 
	 * @param studentId
	 * @return
	 */
	ArrayList<RegisteredCourse> viewRegisteredCourses(int studentId, int semester);
	
	RegisteredCourse getRegisteredCourse(int studentId, int courseId);
	
	
	
}

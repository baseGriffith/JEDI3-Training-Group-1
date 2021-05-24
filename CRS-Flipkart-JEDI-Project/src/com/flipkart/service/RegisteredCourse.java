/**
 * 
 */
package com.flipkart.service;

import com.flipkart.bean.Student;

/**
 * @author Nayan
 *
 */
public interface RegisteredCourse {
	/** To drop a course 
	 * @param studentId
	 * @param courseId
	 * @return
	 */
	public boolean dropCourse(String studentId, int courseId);
	
	/** To view grade in a course
	 * @param studentId
	 * @param courseId
	 * @return
	 */
	public String viewGrade(String studentId, int courseId);
	
	/** For professor to add grades 
	 * @param studentRollNumber
	 * @param courseId
	 */
	public void addGrade(String studentRollNumber, int courseId);
	
	/** get list of enrolled student in a course
	 * @param courseId
	 * @return
	 */
	public Student[] getStudents(int courseId ); 
	
}

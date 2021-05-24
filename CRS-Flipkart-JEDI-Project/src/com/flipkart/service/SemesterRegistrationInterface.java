/**
 * 
 */
package com.flipkart.service;

/**
 * @author nayan
 *
 */
public interface SemesterRegistrationInterface {
	
	/** Register students for the semester
	 * @param rollNumber
	 * @param semester
	 * @return
	 */
	public boolean register(String rollNumber, int semester);
	
	/** To request a course
	 * @param rollNumber
	 * @param courseId
	 * @param semester
	 * @return
	 */
	
	public boolean addCourse(String rollNumber, int courseId,int semester);
	
	/** To drop a course 
	 * @param rollNumber
	 * @param courseId
	 * @param semester
	 * @return
	 */
	public boolean dropCourse(String rollNumber, int courseId,int semester);
	
	/** Check status of the registration
	 * @param rollNumber
	 * @param semester
	 * @return
	 */
	public boolean checkStatus(String rollNumber, int semester);

	/** print list of courses in which the student is enrolled 
	 * @param rollNumber
	 * @param semester
	 */
	public void showRegisteredCourses(String rollNumber, int semester);
	
}

package com.flipkart.dao;

import java.util.ArrayList;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;

public interface StudentDaoInterface {	
	
	/**
	 * Get student details based on id
	 * @param studentId
	 * @return Student object
	 */
	Student getStudent(int studentId);

	int register(Student student);
	
	/**
	 * pay fees as part of registration of courses	
	 * @param studentId
	 * @param amount
	 * @param mode
	 * @return status of payment done or not
	 */
	boolean payFees(int studentId,int amount,String mode);
	
	/**
	 * based on studentId return the registered courses of the student
	 * @param studentId
	 * @return a list of registered courses for the semester
	 */
	ArrayList <Course> viewRegisteredCourses(int studentId);

	/**
	 *
	 * @return
	 */
	ArrayList<Student> fetchAllStudents();

	/**
	 *
     * @param studentId
     * @return
     */
	boolean removeStudent(int studentId);
	void approveStudent(int studentId);
}

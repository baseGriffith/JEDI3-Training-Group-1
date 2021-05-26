package com.flipkart.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.exception.PaymentFailedException;

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
	
}

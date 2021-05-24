package com.flipkart.service;

import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;

/**
 * @author dhruv
 *
 */
public interface AdminImpl {
	
	/**
	 * Approve if student is verified
	 * @param Student
	 * @return boolean indicating if the student was approved
	 */
	public boolean approveStudent(Student student);
		
	/**
	 * Adds a new professor to database
	 * @param ProfessorImpl
	 * @return boolean indicating if the student was approved
	 */
	public void addProfessor(Professor professor);
	
	/**
	 * Generate report card based on studentId
	 * @param studentId
	 * @return Report card data
	 */
	public String generateReportCard(String studentRollNumber);
}

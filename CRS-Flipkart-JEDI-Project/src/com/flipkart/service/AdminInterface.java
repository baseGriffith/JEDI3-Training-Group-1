package com.flipkart.service;

import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;

/**
 * @author dhruv
 *
 */
<<<<<<< HEAD
public class AdminInterface implements AdminImpl{

	@Override
	public boolean approveStudent(Student student) {
		// TODO Auto-generated method stub
		System.out.println("Student approved");
		return false;
	}

	@Override
	public void addProfessor(Professor professor) {
		// TODO Auto-generated method stub
		System.out.println("Professor added");
	}

	@Override
	public String generateReportCard(String studentRollNumber) {
		// TODO Auto-generated method stub
		System.out.println("Report card generated");
		return null;
	}

=======
public interface AdminInterface {
	
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
	public void addProfessor(ProfessorImpl professor);
	
	/**
	 * Generate report card based on studentId
	 * @param studentId
	 * @return Report card data
	 */
	public String generateReportCard(int studentId);
>>>>>>> bc442c1b75b354763974a13d60bc68c4d324cad4
}

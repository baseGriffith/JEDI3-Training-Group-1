/**
 * 
 */
package com.flipkart.service;

/**
 * @author dhruv
 *
 */
public class Admin implements AdminImpl{

	@Override
	public boolean approveStudent(Student student) {
		// TODO Auto-generated method stub
		System.out.println("Student approved");
		return false;
	}

	@Override
	public void addProfessor(ProfessorImpl professor) {
		// TODO Auto-generated method stub
		System.out.println("Professor added");
	}

	@Override
	public String generateReportCard(int studentId) {
		// TODO Auto-generated method stub
		System.out.println("Report card generated");
		return null;
	}

}

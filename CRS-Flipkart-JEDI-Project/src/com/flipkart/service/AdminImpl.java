/**
 * 
 */
package com.flipkart.service;

import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;

/**
 * @author dhruv
 *
 */

public class AdminImpl implements AdminInterface{

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
	public String generateReportCard(int rollNumber) {
		// TODO Auto-generated method stub
		System.out.println("Report card generated");
		return null;
	}


}

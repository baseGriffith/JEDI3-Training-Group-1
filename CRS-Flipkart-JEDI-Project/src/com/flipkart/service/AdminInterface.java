package com.flipkart.service;

import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;

/**
 * @author dhruv
 *
 */

public interface AdminInterface{
	
	public boolean approveStudent(Student student);

	public void addProfessor(Professor professor);
	
	public String generateReportCard(int rollNumber);
}


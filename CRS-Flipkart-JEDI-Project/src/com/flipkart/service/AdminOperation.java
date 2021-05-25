/**
 * 
 */
package com.flipkart.service;

import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.exception.ProfessorAlreadyExistException;
import com.flipkart.exception.ReportCardGenerationFailedException;
import com.flipkart.exception.StudentNotApprovedException;

/**
 * @author dhruv
 *
 */

public class AdminOperation implements AdminInterface{

	@Override	
	public boolean approveStudent(Student student) throws StudentNotApprovedException{
		// TODO Auto-generated method stub
		System.out.println("Student approved");
		return false;
	}

	@Override
	public void addProfessor(Professor professor) throws ProfessorAlreadyExistException{
		// TODO Auto-generated method stub
		System.out.println("Professor added");
	}

	@Override
	public String generateReportCard(String rollNumber) throws ReportCardGenerationFailedException{
		// TODO Auto-generated method stub
		System.out.println("Report card generated");
		return null;
	}


}

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

public interface AdminInterface{
	
	public boolean approveStudent(Student student) throws StudentNotApprovedException;

	public void addProfessor(Professor professor) throws ProfessorAlreadyExistException;
	
	public String generateReportCard(String rollNumber) throws ReportCardGenerationFailedException;
}


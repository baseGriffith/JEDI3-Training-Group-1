package com.flipkart.service;

import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.exception.ProfessorAlreadyExistException;
import com.flipkart.exception.ReportCardGenerationFailedException;
import com.flipkart.exception.StudentNotApprovedException;

/**
 * Admin used services
 * @author JEDI-Group1
 *
 */

public interface AdminInterface{
	
	/**
	 * Approve a student based on the details provided
	 * @param student
	 * @return boolean indicating if the student is approved or not 
	 * @throws StudentNotApprovedException
	 */
	public boolean approveStudent(Student student) throws StudentNotApprovedException;

	/**
	 * Add a new professor to the application
	 * @param professor
	 * @throws ProfessorAlreadyExistException
	 */
	public void addProfessor(Professor professor) throws ProfessorAlreadyExistException;
	
	/**
	 * Generate report card based on the student roll number
	 * @param rollNumber
	 * @return 
	 * @throws ReportCardGenerationFailedException
	 */
	public void generateReportCard(String rollNumber) throws ReportCardGenerationFailedException;

}


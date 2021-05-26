/**
 * 
 */
package com.flipkart.service;

import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.dao.AdminDaoImpl;
import com.flipkart.dao.AdminDaoInterface;
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

		return false;
	}

	@Override
	public void addProfessor(Professor professor) throws ProfessorAlreadyExistException{
		AdminDaoInterface admin = new AdminDaoImpl();
		boolean ok = admin.addProfessor(professor);
		if(ok)
			System.out.println("Professor added");
		else {
			throw new ProfessorAlreadyExistException(professor.getUserId());
		}
	}

	@Override
	public String generateReportCard(String rollNumber) throws ReportCardGenerationFailedException{
		// TODO Auto-generated method stub
		System.out.println("Report card generated");
		return null;
	}


}

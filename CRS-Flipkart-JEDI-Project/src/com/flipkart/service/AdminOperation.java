/**
 * 
 */
package com.flipkart.service;

import org.apache.log4j.Logger;

import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.dao.AdminDaoImpl;
import com.flipkart.dao.AdminDaoInterface;
import com.flipkart.exception.ProfessorAlreadyExistException;
import com.flipkart.exception.ReportCardGenerationFailedException;
import com.flipkart.exception.StudentNotApprovedException;

/**
 * @author JEDI-Group1
 *
 */

public class AdminOperation implements AdminInterface{

	private static Logger logger = Logger.getLogger(AdminOperation.class);
	
	@Override	
	public boolean approveStudent(Student student) throws StudentNotApprovedException{
		// TODO Auto-generated method stub

		return false;
	}

	@Override
	public void addProfessor(Professor professor) throws ProfessorAlreadyExistException{
		AdminDaoInterface admin = AdminDaoImpl.getInstance();
		boolean ok = admin.addProfessor(professor);
		if(ok)
			logger.info("Professor added");
		else {
			throw new ProfessorAlreadyExistException(professor.getUserId());
		}
	}

	@Override
	public void generateReportCard(String rollNumber) throws ReportCardGenerationFailedException{
		// TODO Auto-generated method stub
		logger.info("Print the grade sheet");
		return;
	}


}

/**
 * 
 */
package com.flipkart.service;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.flipkart.dao.RegistrationDaoImpl;
import com.flipkart.dao.RegistrationDaoInterface;
import com.flipkart.exception.ReportCardGenerationFailedException;
import com.flipkart.bean.RegisteredCourse;

/**
 * @author JEDI-Group1
 *
 */
public class ReportCardOperation implements ReportCardInterface{
	
	private static Logger logger = Logger.getLogger(AdminOperation.class);
	@Override

	public boolean printReportCard(int studentId, int semester) throws ReportCardGenerationFailedException {
		try {
			RegistrationDaoInterface semesterRegistration = RegistrationDaoImpl.getInstance();
			
			ArrayList<RegisteredCourse> registeredCourses = semesterRegistration.viewRegisteredCourses(studentId, semester);
			
			for(RegisteredCourse registeredCourse : registeredCourses) {
				if(registeredCourse.getGrade().equals("NA")) throw new ReportCardGenerationFailedException(studentId);
			}
			
			for(RegisteredCourse registeredCourse : registeredCourses) {
				logger.info("Student "+studentId+" has got "+registeredCourse.getGrade()+" grade in "+registeredCourse.getCourseName()+ " course");
			}
			return true;
		} catch(ReportCardGenerationFailedException e) {
			return false;
		}
	}
}

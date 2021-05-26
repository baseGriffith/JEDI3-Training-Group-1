/**
 * 
 */
package com.flipkart.service;

import java.util.ArrayList;

import com.flipkart.dao.RegistrationDaoImpl;
import com.flipkart.dao.RegistrationDaoInterface;
import com.flipkart.exception.ReportCardGenerationFailedException;
import com.flipkart.bean.RegisteredCourse;

/**
 * @author Kaustubh
 *
 */
public class ReportCardOperation implements ReportCardInterface{
	
	@Override

	public boolean printReportCard(int studentId, int semester) throws ReportCardGenerationFailedException {
		try {
			RegistrationDaoInterface semesterRegistration = new RegistrationDaoImpl();
			
			ArrayList<RegisteredCourse> registeredCourses = semesterRegistration.viewRegisteredCourses(studentId);
			
			for(RegisteredCourse registeredCourse : registeredCourses) {
				if(registeredCourse.getGrade().equals("NA")) throw new ReportCardGenerationFailedException(studentId);
			}
			
			for(RegisteredCourse registeredCourse : registeredCourses) {
				System.out.println("Student "+studentId+" has got "+registeredCourse.getGrade()+" grade in "+registeredCourse.getCourseName()+ " course");
			}
			return true;
		} catch(ReportCardGenerationFailedException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
}

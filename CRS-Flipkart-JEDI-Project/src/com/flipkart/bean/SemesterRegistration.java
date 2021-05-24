/**
 * 
 */
package com.flipkart.bean;

import java.sql.Date;

/**
 * @author Nayan
 *
 */
public class SemesterRegistration {
	private String rollNumber;
	private int semester;
	private Date registrationDate;
	private Course[] registeredCourse;
	public String getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	public Date getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	public Course[] getRegisteredCourse() {
		return registeredCourse;
	}
	public void setRegisteredCourse(Course[] registeredCourse) {
		this.registeredCourse = registeredCourse;
	}

}

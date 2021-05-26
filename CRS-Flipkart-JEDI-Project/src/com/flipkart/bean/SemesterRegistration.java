/**
 * 
 */
package com.flipkart.bean;

import java.sql.Date;

/**
 * @author JEDI-Group-1
 *
 */
public class SemesterRegistration {
	private int studentId;
	private int semester;
	private Date registrationDate;
	private Course[] registeredCourse;
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

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
}

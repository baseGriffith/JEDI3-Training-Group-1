/**
 * 
 */
package com.flipkart.bean;

import java.util.Arrays;

/**
 * @author Kaustubh
 *
 */
public class ReportCard {
	@Override
	public String toString() {
		return "ReportCard{" +
				"semester=" + semester +
				", rollNo='" + rollNo + '\'' +
				", cgpa=" + cgpa +
				", registeredCourses=" + Arrays.toString(registeredCourses) +
				'}';
	}

	private int semester;
	private String rollNo;
	private double cgpa;
	private RegisteredCourse[] registeredCourses;
	
	public int getSemester() {
		System.out.println("Returns the semester of the report card");
		return semester;
	}
	
	public void setSemester(int semester) {
		System.out.println("Assigns the semester of the report card");
		this.semester = semester;
	}
	
	public String getRollNo() {
		System.out.println("Returns the roll number of the student");
		return rollNo;
	}
	
	public void setRollNo(String rollNo) {
		System.out.println("Sets the roll number in the report card");
		this.rollNo = rollNo;
	}
	
	public double getCgpa() {
		System.out.println("Returns the cgpa of the student for the sem");
		return cgpa;
	}
	
	public void setCgpa(double cgpa) {
		System.out.println("Sets the cgpa of the student");
		this.cgpa = cgpa;
	}
	
	public RegisteredCourse[] getRegisteredCourses() {
		System.out.println("Returns the list of registered courses of the student");
		return registeredCourses;
	}
	
	public void setRegisteredCourses(RegisteredCourse[] registeredCourses) {
		System.out.println("Sets the list of registered courses of the student");
		this.registeredCourses = registeredCourses;
	}
}

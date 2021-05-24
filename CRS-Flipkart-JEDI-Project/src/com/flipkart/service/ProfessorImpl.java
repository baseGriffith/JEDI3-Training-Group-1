/**
 * 
 */
package com.flipkart.service;

/**
 * @author dhruv
 *
 */
public class ProfessorImpl implements ProfessorInterface{

	@Override
	public void gradeStudent(int courseId, int studentId, char gradeAlloted) {
		// TODO Auto-generated method stub
		System.out.println("Student graded");
		
	}

	@Override
	public boolean registerCourse(int courseId) {
		// TODO Auto-generated method stub
		System.out.println("Course registered");
		return false;
	}

	@Override
	public Student[] getEnrolledStudents(int courseId) {
		// TODO Auto-generated method stub
		System.out.println("Enrolled students are ---- .");
		return null;
	}

}

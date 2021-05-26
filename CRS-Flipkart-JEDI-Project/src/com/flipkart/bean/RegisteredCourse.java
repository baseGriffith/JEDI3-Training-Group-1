/**
 * 
 */
package com.flipkart.bean;

/**
 * @author JEDI-Group-1
 *
 */
public class RegisteredCourse {
	private int studentId;
	private int courseId;
	private String grade;
	private String courseName;
	
	public RegisteredCourse(int studentId, int courseId, String grade, String courseName){
		this.studentId = studentId;
		this.courseId = courseId;
		this.grade = grade;
		this.courseName = courseName;
	}
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
}

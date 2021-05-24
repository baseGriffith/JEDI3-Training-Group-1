/**
 * 
 */
package com.flipkart.bean;

/**
 * @author dhruv
 *
 */
public class Professor extends User{
	
	private String department;
	private String professorId;
	
	public String getDepartment() {
		return department;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public String getProfessorId() {
		return professorId;
	}
	
	public void setProfessorId(String professorId) {
		this.professorId = professorId;
	}

}

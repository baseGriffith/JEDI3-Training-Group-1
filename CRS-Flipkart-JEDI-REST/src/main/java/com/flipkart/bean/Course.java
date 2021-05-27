package com.flipkart.bean;

/**
 * Stores the properties corresponding to Courses taught
 * @author JEDI-Group1
 *
 */
public class Course {
    private String courseName;
    private int courseId;
    private String department;
    private int professorId;
    private int semester;
    private String courseCode;
    
    private RegisteredCourse[] registeredCourses;

    public String getCourseName(){
        return courseName;
    }

    @Override
	public String toString() {
		return "Course [courseName=" + courseName + ", courseId=" + courseId + ", department=" + department
				+ ", professorId=" + professorId + ", semester=" + semester + ", courseCode=" + courseCode + "]";
	}

	public void setCourseName(String courseName){
        this.courseName = courseName;
    }

    public int getCourseId(){
        return courseId;
    }

    public void setCourseId(int courseId){
        this.courseId = courseId;
    }

    public String getDepartment(){
        return department;
    }

    public void setDepartment(String department){
        this.department = department;
    }

    public int getProfessorId(){
        return professorId;
    }

    public void setProfessorId(int professorId){
        this.professorId = professorId;
    }

    public RegisteredCourse[] getRegisteredCourses(){
        return registeredCourses;
    }

    public void setRegisteredCourses(RegisteredCourse[] registeredCourses){
        this.registeredCourses = registeredCourses;
    }

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
    
    
}

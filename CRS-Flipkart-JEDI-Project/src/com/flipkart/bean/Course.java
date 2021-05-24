package com.flipkart.bean;

public class Course {
    private String courseName;
    private String courseId;
    private String department;
    private String professorId;
    private RegisteredCourse[] registeredCourses;

    public String getCourseName(){
        return courseName;
    }

    public void setCourseName(String courseName){
        this.courseName = courseName;
    }

    public String getCourseId(){
        return courseId;
    }

    public void setCourseId(String courseId){
        this.courseId = courseId;
    }

    public String getDepartment(){
        return department;
    }

    public void setDepartment(String department){
        this.department = department;
    }

    public String getProfessorId(){
        return professorId;
    }

    public void setProfessorId(String professorId){
        this.professorId = professorId;
    }

    public RegisteredCourse[] getRegisteredCourses(){
        return registeredCourses;
    }

    public void setRegisteredCourses(RegisteredCourse[] registeredCourses){
        this.registeredCourses = registeredCourses;
    }
}

package com.flipkart.bean;

public class Course {
    private String courseName;
    private String courseId;
    private String department;
    private int professorId;
    private int semester;
    private String courseCode;
    private RegisteredCourse[] registeredCourses;

    public int getSemester() {
        return semester;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

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
}

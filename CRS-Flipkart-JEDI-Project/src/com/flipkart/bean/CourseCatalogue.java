package com.flipkart.bean;

public class CourseCatalogue {
    private int semester;
    private Course[] courses;

    public int getSemester(){
        return semester;
    }

    public void setSemester(int semester){
        this.semester = semester;
    }

    public Course[] getCourses(){
        return courses;
    }

    public void setCourses(Course[] courses){
        this.courses = courses;
    }
}

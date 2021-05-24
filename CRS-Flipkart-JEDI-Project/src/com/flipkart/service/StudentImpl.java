package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.ReportCard;

public class StudentImpl implements StudInterface{
    @Override
    public ReportCard viewReportCard(String rollNumber) {
        return null;
    }

    @Override
    public Course[] viewRegisteredCourses(String rollNumber) {
        return new Course[0];
    }

    @Override
    public boolean payFees(String rollNumber) {
        // implement whole frees payment function
        return false;
    }
}

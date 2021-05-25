package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.ReportCard;
import com.flipkart.exception.PaymentFailedException;
import com.flipkart.exception.ReportCardGenerationFailedException;

public class StudentImpl implements StudInterface{
    @Override
    public ReportCard viewReportCard(String rollNumber) throws ReportCardGenerationFailedException{
        return null;
    }

    @Override
    public Course[] viewRegisteredCourses(String rollNumber) {
        return new Course[0];
    }

    @Override
    public boolean payFees(String rollNumber) throws PaymentFailedException{
        // implement whole frees payment function
        return false;
    }
}

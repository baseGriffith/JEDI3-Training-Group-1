package com.flipkart.service;

import java.util.ArrayList;

import com.flipkart.bean.Course;
import com.flipkart.bean.ReportCard;
import com.flipkart.bean.Student;
import com.flipkart.dao.StudentDaoImpl;
import com.flipkart.exception.PaymentFailedException;
import com.flipkart.exception.ReportCardGenerationFailedException;

public class StudentOperation implements StudInterface{
    @Override
    public ReportCard viewReportCard(String rollNumber) throws ReportCardGenerationFailedException{
    	//TODO
        return null;
    }

    @Override
    public ArrayList<Course> viewRegisteredCourses(int studentId) {
    	StudentDaoImpl s=new StudentDaoImpl();
    	ArrayList<Course> courses = s.viewRegisteredCourses(studentId);
    	return courses;
    }

    @Override
    public boolean payFees(int studentId,int amount,String mode) throws PaymentFailedException{
        // implement whole frees payment function
    	StudentDaoImpl s=new StudentDaoImpl();
    	boolean feeStatus=s.payFees(studentId, amount, mode);
    	if(feeStatus==false) {
    		throw new PaymentFailedException(studentId);
    	}
        return feeStatus;
    }

    @Override
    public Student getStudent(int studentId) {
        StudentDaoImpl s = new StudentDaoImpl();
        Student ret = s.getStudent(studentId);
        return ret;
    }
}

package com.flipkart.restcontroller;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.crypto.URIReferenceException;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.exception.ReportCardGenerationFailedException;
import com.flipkart.service.ReportCardInterface;
import com.flipkart.service.ReportCardOperation;
import com.flipkart.service.StudentOperation;
import com.flipkart.service.UserInterface;
import com.flipkart.service.UserOperation;


public class StudentRestAPI {
	
	@GET
	@Path("/student/viewCourseCatalog")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<String> viewCourseCatalog(Student student) {
		UserInterface user = UserOperation.getInstance();
		ArrayList<Course> courseCatalog = user.getCourseCatalog(student.getSemester());
		ArrayList<String> courseCatalogDisplay = new ArrayList<String>();
		for(Course course:courseCatalog) {
			String courseCode="Course Code: "+course.getCourseCode();
			String courseName= "Course Name: "+course.getCourseName();
			String department="Department: "+course.getDepartment();
			String formattedString = String.format("%-25s. %-20s\n",  courseCode, courseName);
			courseCatalogDisplay.add(formattedString);
		}
		return courseCatalogDisplay;
	}
	
	@GET
	@Path("/student/viewRegisteredCourses")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<String> viewRegisteredCourses(Student student){
		
		StudentOperation f = StudentOperation.getInstance();
		
		ArrayList<Course> registeredCourse = f.viewRegisteredCourses(student.getUserId());
		ArrayList<String> registeredCourseDisplay = new ArrayList<String>();
		System.out.println("************REGISTERED COURSES*****************");
		for(Course course:registeredCourse) {
			String courseCode="Course Code: "+course.getCourseCode();
			String courseName= "Course Name: "+course.getCourseName();						
			String formattedString = String.format("%-25s. %-20s\n",  courseCode, courseName);
			registeredCourseDisplay.add(formattedString);
		}
		return registeredCourseDisplay;
	}
	
	@GET
	@Path("/student/viewReportCard")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<String> viewReportCard(Student student, int semester) throws ReportCardGenerationFailedException{
		ReportCardInterface reportCard = ReportCardOperation.getInstance();
		ArrayList<String> reportCardDisplay = reportCard.printReportCard(student.getUserId(), semester);
		return reportCardDisplay;
	}
	
	@GET
	@Path("/student/viewNotification")
	@Produces(MediaType.APPLICATION_JSON)
	public String viewNotifications(Student student) throws ReportCardGenerationFailedException{
		return "---";
	}
	
	
}

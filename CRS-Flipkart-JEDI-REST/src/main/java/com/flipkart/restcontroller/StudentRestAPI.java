package com.flipkart.restcontroller;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import java.util.ArrayList;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.crypto.URIReferenceException;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.exception.ReportCardGenerationFailedException;
import com.flipkart.service.NotificationOperation;
import com.flipkart.service.ReportCardInterface;
import com.flipkart.service.ReportCardOperation;
import com.flipkart.service.SemesterRegistrationOperation;
import com.flipkart.service.StudentOperation;
import com.flipkart.service.UserInterface;
import com.flipkart.service.UserOperation;

@Path("/student")
public class StudentRestAPI {
	
	private static Logger logger = Logger.getLogger(StudentRestAPI.class);
	static ArrayList<Integer> courseIdPrimary = new ArrayList<Integer>(), courseIdAlternate = new ArrayList<Integer>();
	
	
	/**
	 * API to view course catalog
	 * @param student
	 * @return
	 */
	@GET
	@Path("/viewCourseCatalog")
	@Produces(MediaType.APPLICATION_JSON)
	public Response viewCourseCatalog(Student student) {
		UserInterface user = UserOperation.getInstance();
		ArrayList<Course> courseCatalog = user.getCourseCatalog(student.getSemester());
		
		ArrayList<String> courseCatalogDisplay = new ArrayList<String>();
		for(Course course:courseCatalog) {
			String courseCode="Course Code: "+course.getCourseCode();
			String courseName= "Course Name: "+course.getCourseName();
			String department="Department: "+course.getDepartment();
			String formattedString = String.format("%-20s %s",  courseCode, courseName);
			courseCatalogDisplay.add(formattedString);
		}
		return Response.status(201).entity(courseCatalogDisplay).build();
	}

	
	/**
	 * API for viewing registered courses
	 * @param student
	 * @return
	 */
	@GET
	@Path("/viewRegisteredCourses")
	@Produces(MediaType.APPLICATION_JSON)
	public Response viewRegisteredCourses(Student student){
		
		StudentOperation f = StudentOperation.getInstance();
		
		ArrayList<Course> registeredCourse = f.viewRegisteredCourses(student.getUserId());
		ArrayList<String> registeredCourseDisplay = new ArrayList<String>();
		for(Course course:registeredCourse) {
			String courseCode="Course Code: "+course.getCourseCode();
			String courseName= "Course Name: "+course.getCourseName();						
			String formattedString = String.format("%-25s %s",  courseCode, courseName);
			registeredCourseDisplay.add(formattedString);
		}
		return Response.status(201).entity(registeredCourseDisplay).build(); 
	}

	/**
	 * API for viewing report card after all grades have been added
	 * 
	 * @param student
	 * @param semester
	 * @return
	 * @throws ReportCardGenerationFailedException
	 */
	@GET
	@Path("/viewReportCard/{semester}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response viewReportCard(Student student, @PathParam("semester")int semester) 
		throws ReportCardGenerationFailedException{
		try {
			ReportCardInterface reportCard = ReportCardOperation.getInstance();
			ArrayList<String> reportCardDisplay = reportCard.printReportCard(student.getUserId(), semester);
			return Response.status(201).entity(reportCardDisplay).build();	
		} catch (Exception e){
			logger.info(e.getMessage());
			return Response.status(500).entity(e.getMessage()).build();
		}
	}

	/**
	 * API to view the notifications
	 * 
	 * @param student
	 * @return
	 * @throws ReportCardGenerationFailedException
	 */
	@GET
	@Path("/viewNotifications")
	@Produces(MediaType.APPLICATION_JSON)
	public Response viewNotifications(Student student) throws ReportCardGenerationFailedException{
		try {
			NotificationOperation notificationOperation=NotificationOperation.getInstance();
			ArrayList <String> messages=notificationOperation.fetchMessages(student.getUserId());
			
			return Response.status(201).entity(messages).build();
		}
		catch(Exception e) {
			System.out.println("SYSTEM ERROR,TRY AGAIN!!");
		}
		break;
	}
	

	/**
	 * API to pay fees using card
	 * 
	 * @param amount
	 * @param cardNumber
	 * @param expiryDate
	 * @param cvv
	 * @param studentId
	 * @return
	 */
	@POST
	@Path("/payFee/card")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response cardPayment(
			   @NotNull 
               @Min(value = 0, message = "Fee to be paid has to be a positive number!") 
			   @QueryParam("amount") int amount,
			   @NotNull
			   @Size(min = 16, max = 16, message = "Enter a valid 16 digit card number!")
			   @QueryParam("cardNumber") String cardNumber,
			   @NotNull
			   @QueryParam("expiryDate") String expiryDate,
			   @NotNull
			   @QueryParam("cvv") String cvv,
			   @NotNull
			   @QueryParam("studentId") int studentId
			) {
		try {
			SemesterRegistrationOperation sro = SemesterRegistrationOperation.getInstance();
			for(Integer courseId: courseIdPrimary) {
				sro.addCourse(studentId, courseId);
			}
		} catch(Exception e) {
			return Response.status(201).entity( "Payment Successful!").build();
		}
		
		return Response.status(201).entity( "Payment Successful!").build();	
	}

	
	/**
	 * API to pay fees using net banking
	 * 
	 * @param amount
	 * @param bankName
	 * @param bankUserId
	 * @param bankPassword
	 * @param studentId
	 * @return
	 */
	@POST
	@Path("/payFee/netBanking")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response netBankingPayment(@NotNull 
			               @Min(value = 0, message = "Fee to be paid has to be a positive number!") 
						   @QueryParam("amount") int amount,
						   @NotNull
						   @QueryParam("bankName") String bankName,
						   @NotNull
						   @QueryParam("bankUserId") String bankUserId,
						   @NotNull
						   @QueryParam("bankPassword") String bankPassword,
						   @NotNull
						   @QueryParam("studentId") int studentId) {
		try {
			SemesterRegistrationOperation sro = SemesterRegistrationOperation.getInstance();
			for(Integer courseId: courseIdPrimary) {
				sro.addCourse(studentId, courseId);
			}
		} catch(Exception e) {
			return Response.status(201).entity( "Payment Failed. Try Again!").build();
		}
		
		return Response.status(201).entity( "Payment Successful!").build();	
	}
	

	/**
	 * API to add courses for semester registration
	 * 
	 * @param courseChoice
	 * @param courseId
	 * @return
	 */
	@POST
	@Path("/semesterRegistration/addCourse")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addCourse(@NotNull 
			                  @Min(value = 1, message = "Course can either be primary or alternate!")
							  @Max(value = 2, message = "Course can either be primary or alternate!")
						      @QueryParam("courseChoice") int courseChoice,
						      @NotNull
						      @QueryParam("courseId") int courseId) {
		
		
		switch(courseChoice) {

		case 1:

			if(courseIdPrimary.size() >= 4) {
				return Response.status(400).entity( "Primary course list already full!").build();
			}
			int alreadyExist = 0;
			for(int coursePrimary : courseIdPrimary) {
				if(coursePrimary == courseId) {
					alreadyExist = 1;
					break;
				}
			}
			if(alreadyExist == 1) {
				return Response.status(400).entity( "Course already added!").build();
			}
			
			courseIdPrimary.add(courseId);
			break;

		case 2:

			if(courseIdAlternate.size() >= 4) {
				return Response.status(400).entity( "Alternate course list already full!").build();
			}
			alreadyExist = 0;
			for(int courseAlternate : courseIdAlternate) {
				if(courseAlternate == courseId) {
					alreadyExist = 1;
					break;
				}
			}
			if(alreadyExist == 1) {
				return Response.status(400).entity( "Course already added!").build();
			}
			
			courseIdAlternate.add(courseId);	
		}
		
		return Response.status(201).entity( "Course added!").build();
	}

	
	/**
	 * API to register for a semester
	 * 
	 * @param obj
	 * @return
	 */
	@POST
	@Path("/semesterRegistration")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response semesterRegistration(JSONObject obj) {
		courseIdPrimary.clear();
		courseIdAlternate.clear();
		
		ArrayList<Integer> primaryCourses = (ArrayList<Integer>)obj.get("primaryCourses");
		ArrayList<Integer> alternateCourses = (ArrayList<Integer>)obj.get("alternateCourses");
		int semester = (int)obj.get("semester");
		
		for(int i = 0; i < 4; i++) {
			courseIdPrimary.add(primaryCourses.get(i));
		}
		
		for(int i = 0; i < 2; i++) {
			courseIdAlternate.add(alternateCourses.get(i));
		}
		
		UserOperation user = UserOperation.getInstance();
		ArrayList<Course> courseCatalog = user.getCourseCatalog(semester);
		
		ArrayList<ArrayList<String>> coursesForRegistration = new ArrayList<ArrayList<String>>();
		
		ArrayList<String> primaryRegistrationCourses = new ArrayList<String>();
		primaryRegistrationCourses.add("Primary courses: ");
		ArrayList<String> alternateRegistrationCourses = new ArrayList<String>();
		alternateRegistrationCourses.add("Alternate courses: ");
		
		for(Integer id:courseIdPrimary) {
			for(Course course:courseCatalog) {
				if(course.getCourseId()==id) {
					String formattedString = String.format("%-25d. %-20s %s",course.getCourseId(),course.getCourseCode(),course.getCourseName());
					primaryRegistrationCourses.add(formattedString);
				}
			}
		}
		
		for(Integer id:courseIdAlternate) {
			for(Course course:courseCatalog) {
				if(course.getCourseId()==id) {
					String formattedString = String.format("%-25d. %-20s %s",course.getCourseId(),course.getCourseCode(),course.getCourseName());
					alternateRegistrationCourses.add(formattedString);
				}
			}
		}
		
		coursesForRegistration.add(primaryRegistrationCourses);
		coursesForRegistration.add(alternateRegistrationCourses);
		
		return Response.status(201).entity(coursesForRegistration).build();
	}
	
	/**
	 * API to drop a course for registration
	 * 
	 * @param courseChoice
	 * @param courseId
	 * @return
	 */
	@POST
	@Path("/semesterRegistration/dropCourse")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response dropCourse(@NotNull 
			                  @Min(value = 1, message = "Course can either be primary or alternate!")
							  @Max(value = 2, message = "Course can either be primary or alternate!")
						      @QueryParam("courseChoice") int courseChoice,
						      @NotNull
						      @QueryParam("courseId") int courseId) {
		
		switch(courseChoice) {

		case 1:
			int dropped = 0;
			int count=0;
			for(int primaryCourse: courseIdPrimary) {
				if(primaryCourse == courseId) {
					courseIdPrimary.remove(count);
					dropped = 1;
					break;
				}
				count++;
			}
			
			if(dropped == 0) {
				return Response.status(400).entity( "Course not found\\n!").build();
			}

		case 2:
			dropped = 0;
			count=0;
			for(int alternateCourse: courseIdAlternate) {
				if(alternateCourse == courseId) {
					courseIdAlternate.remove(count);
					dropped = 1;
					break;
				}
				count++;
			}
			if(dropped == 0) {
				return Response.status(400).entity( "Course not found\\n").build();
			}
		}
		
		return Response.status(201).entity( "Course dropped\\n!").build();
	}
	
	/**
	 * API for logging out of the system
	 * 
	 * @param student
	 * @return
	 */
	@POST
	@Path("/logout")
	@Produces(MediaType.APPLICATION_JSON)
	public Response logout(Student student){
		return Response.status(201).entity( "Logged out\\n!").build();
	}
}

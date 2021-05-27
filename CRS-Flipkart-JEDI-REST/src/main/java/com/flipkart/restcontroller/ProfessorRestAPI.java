package com.flipkart.restcontroller;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.service.ProfessorOperation;

/**
 * Handles the requests pertaining to the professor
 * @author JEDI-Group1
 *
 */
@Path("/professor")
public class ProfessorRestAPI {

	/**
	 * register for a course
	 * @param courseId
	 * @param professorId
	 * @return
	 */
	
	@POST
	@Path("/registerCourse")
	public Response registerCourse(@QueryParam("courseId") int courseId,@QueryParam("professorId") int professorId) {
		try {
			ProfessorOperation professorOperations=ProfessorOperation.getInstance();
			professorOperations.registerCourse(professorId, courseId);
			return Response.status(201).entity("SUCCESSFULLY REGISTERED FOR COURSE!").build();
		}catch(Exception e) {
			return Response.status(500).entity("COURSE CANNOT BE REGISTERED!").build();
		}
	}
	
	
	/**
	 * get the enrolled students of a course
	 * @param courseId
	 * @return
	 */
	@GET
	@Path("/getEnrolledStudents/{courseId}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response getEnrolledStudents(@PathParam("courseId") int courseId){
		ProfessorOperation professorImpl=ProfessorOperation.getInstance();
		try {
			ArrayList <Student> students=professorImpl.getEnrolledStudents(courseId);			
			return Response.status(201).entity(students).build();
		}
		catch(Exception e) {
			return Response.status(500).entity("Error occured").build();
		}
		
	}
	
	
	/**
	 * get the registered courses of a professor
	 * @param professorId
	 * @return
	 */
	@GET
	@Path("/getRegisteredCourses/{professorId}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response getRegisteredCourses(@PathParam("professorId") int professorId){
		ProfessorOperation professorImpl=ProfessorOperation.getInstance();
		try {
			ArrayList <Course> courses=professorImpl.getProfessorRegisteredCourses(professorId);			
			return Response.status(500).entity(courses).build();
		}
		catch(Exception e) {
			return Response.status(500).entity("Error occured").build();
		}
	}
	
	/**
	 * grade a student registered in a course
	 * @param courseId
	 * @param studentId
	 * @param grade
	 * @return
	 */
	
	@POST
	@Path("/gradeCourse")
	public Response gradeCourse(@QueryParam("courseId") int courseId,@QueryParam("studentId") int studentId,@QueryParam("grade") String grade) {
		try {
			ProfessorOperation professorOperation=ProfessorOperation.getInstance();
			professorOperation.gradeStudent(courseId, studentId, grade);
			return Response.status(201).entity("COURSE GRADED").build();
		}catch(Exception e) {
			return Response.status(500).entity("COURSE COULD NOT BE GRADED").build();
		}
	}
	
}

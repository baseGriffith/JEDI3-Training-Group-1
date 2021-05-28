package com.flipkart.restcontroller;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.simple.JSONObject;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.exception.ProfessorAlreadyExistException;
import com.flipkart.service.AdminInterface;
import com.flipkart.service.AdminOperation;
import com.flipkart.service.CourseCatalogueOperation;
import com.flipkart.service.StudentOperation;

@Path("/admin")
public class AdminRestAPI {

	/**
	 * 
	 * @return
	 */
	@GET
	@Path("/viewUnapprovedStudents")
	@Produces(MediaType.APPLICATION_JSON)
	public Response viewUnapprovedStudents(){
		try {
			StudentOperation studentOperation = StudentOperation.getInstance();
			ArrayList<Student> students=null;
			students = studentOperation.fetchAllStudents();
			return Response.status(201).entity(students).build();
		} catch (Exception e) {
			return Response.status(500).entity(e.getMessage()).build();
		}
	}
	/**
	 * 	
	 * @param p
	 * @return
	 */
	@POST
	@Path("/addProfessor")
	@Consumes("application/json")	
	public Response addProfessor(Professor p) {
		AdminInterface adminOp = AdminOperation.getInstance();
		try {
			adminOp.addProfessor(p);
			return Response.status(201).entity("Profssor has been added to the database.").build();
		} catch (ProfessorAlreadyExistException e) {
			e.printStackTrace();
			return Response.status(409).entity("Inserrtion Failed due to some internal error.").build();
		}
	}
	
	/**
	 * 
	 * @param c
	 * @return
	 */
	@POST
	@Path("/addCourse")
	@Consumes("application/json")	
	public Response addCourse(Course c) {
		CourseCatalogueOperation cco = CourseCatalogueOperation.getInstance();
		try {
			cco.addCourse(c);
			return Response.status(201).entity("Course has been added to the database.").build();
		}catch(Exception e) {
			return Response.status(409).entity("Insertion Failed due to some internal error.").build();
		}
	}
	/**
	 * 
	 * @param input
	 * @return
	 */
	@POST
	@Path("/dropCourse")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response dropCourse(JSONObject input) {
		int courseId = (Integer)input.get("courseId");
		CourseCatalogueOperation cco = CourseCatalogueOperation.getInstance();
		try {
			cco.deleteCourse(courseId);
			return Response.status(201).entity("Course has been deleted from the database.").build();
		}catch(Exception e) {
			return Response.status(409).entity("Deletion Failed due to some internal error.").build();
		}
	}
}
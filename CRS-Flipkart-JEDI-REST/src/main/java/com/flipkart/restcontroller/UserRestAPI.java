package com.flipkart.restcontroller;

import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.flipkart.bean.Student;
import com.flipkart.bean.User;
import com.flipkart.service.StudentOperation;
import com.flipkart.service.UserOperation;

/**
 * Rest controller for the user class
 * @author JEDI-Group1
 *
 */


/**
 * @param userId
 * @param password
 * @param userRole
 */
@Path("/user")
public class UserRestAPI {
	
	
	/**
	 * login a user
	 * @param user
	 * @param userChoice
	 * @return
	 */
	
	@POST
	@Path("/login/{userChoice}")
	public Response Login(User user,@PathParam("userChoice")int userChoice) {
		try {			
			UserOperation userOperation=UserOperation.getInstance();
			userOperation.login(user.getUserId(), user.getPassword());
			userOperation.getRole(user.getUserId(),userChoice);			
			
			return Response.status(200).entity("SUCCESSFULL LOGIN!").build();
			
		}catch(Exception exception) {
			return Response.status(500).entity("INVALID LOGIN!!").build();
		}
	}
	
	
	/**
	 * update the user password
	 * @param user
	 * @param password
	 * @return
	 */
	@PUT
	@Path("/updatePassword/{updatedPassword}")
	public Response updatePassword(User user,@PathParam("updatedPassword")String password) {
		try {			
			UserOperation userOperation=UserOperation.getInstance();
			userOperation.login(user.getUserId(), user.getPassword());
			userOperation.updatePassword(user.getUserId(),password);	
			
			return Response.status(201).entity("PASSWORD UPDATED!").build();
			
		}catch(Exception exception) {
			return Response.status(500).entity("INVALID LOGIN!!").build();
		}
	}
	
	/**
	 * register a new user
	 * @param student
	 * @return
	 */
	@POST
	@Path("/register")	
	public Response register(Student student) {
		try {
			StudentOperation studentOperation=StudentOperation.getInstance();
			studentOperation.register(student);			
			return Response.status(201).entity("STUDENT REGISTERED!").build();
		}catch(Exception exception) {
			return Response.status(500).entity("REGISTRATION FAILED!").build();
		}
	}
	
}

package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.exception.LoginException;

/**
 * @author dhruv
 *
 */
public interface UserInterface {		
	
	/**
	 * user login for the application
	 * @param userId
	 * @param password
	 * @throws LoginException
	 * @return boolean indicating if the login was successful
	 */
	boolean login(int userId, String password) throws LoginException;
	
	
	/**
	 * update user password by passing in userId and new password
	 * @param userId
	 * @param password
	 * @return boolean indicating if successful or not
	 * @throws LoginException
	 */
	boolean updatePassword(int userId, String password) throws LoginException;
	
	
	/**
	 * get the course catalog of a particular semester
	 * @param semester
	 * @return Course[]
	 */
	Course[] getCourseCatalog(int semester);
	
}

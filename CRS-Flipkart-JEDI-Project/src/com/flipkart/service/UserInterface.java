package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.exception.LoginException;

/**
 * @author dhruv
 *
 */
public interface UserInterface {		
	
	/**
	 * @param userId
	 * @param password
	 * @return
	 */
	boolean login(int userId, String password) throws LoginException;
	
	boolean updatePassword(int userId, String password) throws LoginException;
	
	Course[] getCourseCatalog(int semester);
	
}

package com.flipkart.service;

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
	boolean login(int userId, String password);
	
	boolean updatePassword(int userId, String password);
	
	Course[] getCourseCatalog(int semester);
	
}

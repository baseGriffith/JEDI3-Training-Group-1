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
	public boolean login(int userId,String password);
	
	public boolean updatePassword(int userId,String password);
	
	public Course[] getCourseCatalog(int semester);
	
}

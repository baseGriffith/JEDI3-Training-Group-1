package com.flipkart.dao;

import java.util.ArrayList;

import com.flipkart.bean.Course;
/**
 * 
 * @author JEDI-group1
 *
 */
public interface UserDaoInterface {
	
	/**
	 * Checks the credentials of the user
	 * @param userId
	 * @param password
	 * @return true if the user credentials are valid
	 */
	public boolean login(int userId,String password);
	
	/**
	 * update user password in the db
	 * @param userId
	 * @param password
	 * @return true if the password was updated
	 */
	public boolean updatePassword(int userId,String password);
	
	/**
	 * fetch course catalog based on the semester
	 * @param semester
	 * @return list of courses part of this semester
	 */
	public ArrayList<Course> getCourseCatalog(int semester);
	
	/**
	 * 
	 * @param userId
	 * @param choice
	 * @return
	 */
	public boolean getRole(int userId,int choice);
}

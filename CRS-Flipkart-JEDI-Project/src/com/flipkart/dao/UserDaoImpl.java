package com.flipkart.dao;

/**
 * @author JEDI-Group-1
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.client.MainMenu;
import com.flipkart.constant.SQLQueriesConstants;
import com.flipkart.utils.DBUtil;

public class UserDaoImpl implements UserDaoInterface {

	private static Logger logger = Logger.getLogger(UserDaoImpl.class);
	@Override
	public boolean login(int userId, String password) {
		// TODO Auto-generated method stub		
		Connection conn = DBUtil.getConnection();		
		String validPassword="";
		try {
			String sql = SQLQueriesConstants.VIEW_USER_QUERY;
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setInt(1, userId);
			
			ResultSet rs = statement.executeQuery();
			rs.next();
			
			validPassword=rs.getString(4);
			logger.info(validPassword);
			
		} catch (Exception e) {
			logger.info(e);
		}
		return password.equals(validPassword);
	}

	@Override
	public boolean updatePassword(int userId, String newPassword) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		boolean passwordUpdated=true;
		try {
			String sql=SQLQueriesConstants.UPDATE_PASSWORD_QUERY;
			
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, newPassword);
			statement.setInt(2, userId);
			
			statement.executeUpdate();			
			
		} catch (Exception e) {
			logger.info(e);
			passwordUpdated=false;
		}
		return passwordUpdated;
	}

	@Override
	public ArrayList<Course> getCourseCatalog(int semester) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		ArrayList <Course> courses=new ArrayList<Course>();
		
		try {
			String sql = SQLQueriesConstants.VIEW_COURSE_CATALOG_QUERY;
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, semester);
			
			ResultSet rs=statement.executeQuery();
			
			while(rs.next()) {
				Course course = new Course();
				course.setCourseId(rs.getInt(1));
				course.setCourseName(rs.getString(2));
				course.setDepartment(rs.getString(3));
				course.setProfessorId(rs.getInt(4));
				course.setSemester(rs.getInt(5));
				course.setCourseCode(rs.getString(6));

				courses.add(course);				
			}
			
		} catch (Exception e) {
			logger.info(e);
		}
		return courses;
	}

	@Override
	public boolean getRole(int userId, int choice) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		if(choice==1) {
			String sql = SQLQueriesConstants.VIEW_STUDENT_QUERY;			
			try {
				PreparedStatement statement = conn.prepareStatement(sql);
				statement.setInt(1, userId);
				
				ResultSet rs=statement.executeQuery();
				return rs.next();
			}
			catch(Exception e) {
				return false;
			}			
		}else if(choice==2) {
			String sql = SQLQueriesConstants.VIEW_PROFESSOR_QUERY;			
			try {
				PreparedStatement statement = conn.prepareStatement(sql);
				statement.setInt(1, userId);
				
				ResultSet rs=statement.executeQuery();
				return rs.next();
			}
			catch(Exception e) {
				return false;
			}	
		}else if(choice==3) {
			String sql = SQLQueriesConstants.VIEW_ADMIN_QUERY;		
			try {
				PreparedStatement statement = conn.prepareStatement(sql);
				statement.setInt(1, userId);
				
				ResultSet rs=statement.executeQuery();
				return rs.next();
			}
			catch(Exception e) {
				return false;
			}	
		}	
		return false;
	}


}

package com.flipkart.dao;

/**
 * @author JEDI-Group-1
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.flipkart.bean.RegisteredCourse;
import com.flipkart.constant.SQLQueriesConstants;
import com.flipkart.utils.*;

public class RegistrationDaoImpl implements RegistrationDaoInterface {
	
	public int addCourse(int courseId, int studentId) {

		try {
			Connection conn = DBUtil.getConnection();
			
			String sqlCheck = SQLQueriesConstants.REGISTERED_COURSE_QUERY;
			PreparedStatement stmt = conn.prepareStatement(sqlCheck);
			stmt.setInt(1, studentId);
			stmt.setInt(2, courseId);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				return 0;
			}

			
			sqlCheck = SQLQueriesConstants.VIEW_STUDENT_COUNT_QUERY;
			stmt = conn.prepareStatement(sqlCheck);
			stmt.setInt(1, courseId);
			rs =stmt.executeQuery();
			rs.next();
			if(rs.getInt(1) >= 10) {
				return 1;
			}
			
			String sql1 = SQLQueriesConstants.VIEW_COURSE_NAME_QUERY;
			stmt = conn.prepareStatement(sql1);
			
			stmt.setInt(1, courseId);
			rs = stmt.executeQuery();
			rs.next();
			String courseName = rs.getString(1);
			
			String sql=SQLQueriesConstants.REGISTER_COURSE_QUERY;
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, studentId);
			stmt.setInt(2, courseId);
			stmt.setString(3, "NA");
			stmt.setString(4, courseName);
			stmt.executeUpdate();
			
			stmt.close();
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    
		return 2;
	}
	
	public boolean dropCourse(int courseId, int studentId) {
		
		try {
			Connection conn = DBUtil.getConnection();
			String sql= SQLQueriesConstants.DROP_COURSE_QUERY;
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, studentId);
			stmt.setInt(2, courseId);
			
			stmt.executeUpdate();
			
			stmt.close();
//		    conn.close();
		    
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	public ArrayList<RegisteredCourse> viewRegisteredCourses(int studentId, int semester) {
		
		try {
			Connection conn = DBUtil.getConnection();
			String sql = SQLQueriesConstants.VIEW_REGISTERED_COURSES_QUERY;
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, studentId);
			stmt.setInt(2, semester);
			
			ResultSet registeredCoursesSQL = stmt.executeQuery();
			
			ArrayList<RegisteredCourse> registeredCourses = new ArrayList<RegisteredCourse>();
			
			while(registeredCoursesSQL.next()) {
				int studentIdSQL = registeredCoursesSQL.getInt(1);
				int courseIdSQL = registeredCoursesSQL.getInt(2);
				String gradeSQL = registeredCoursesSQL.getString(3) == null ? "NA" : registeredCoursesSQL.getString(3);
				String courseName = registeredCoursesSQL.getString(4);
				
				RegisteredCourse registeredCourse = new RegisteredCourse(studentIdSQL, courseIdSQL, gradeSQL, courseName);
				registeredCourses.add(registeredCourse);
			}
			return registeredCourses;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public RegisteredCourse getRegisteredCourse(int studentId, int courseId) {
		try {
			Connection conn = DBUtil.getConnection();
			String sql = SQLQueriesConstants.REGISTERED_COURSE_QUERY;
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, studentId);
			stmt.setInt(2,  courseId);
			
			ResultSet registeredCoursesSQL = stmt.executeQuery();
				
			int studentIdSQL = registeredCoursesSQL.getInt(1);
			int courseIdSQL = registeredCoursesSQL.getInt(2);
			String gradeSQL = registeredCoursesSQL.getString(3) == null ? "NA" : registeredCoursesSQL.getString(3);
			String courseName = registeredCoursesSQL.getString(4);
			
			RegisteredCourse registeredCourse=new RegisteredCourse(studentIdSQL, courseIdSQL, gradeSQL, courseName);
			
		
			stmt.close();
		    conn.close();
		    
		    return registeredCourse;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}

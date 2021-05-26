package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.flipkart.exception.CourseAlreadyBeingTaughtException;
import com.flipkart.utils.DBUtil;

public class ProfessorDaoImpl implements ProfessorDaoInterface{
    @Override
    public void signupCourse(int professorId, int courseId) throws CourseAlreadyBeingTaughtException {
        try {
            Connection conn = DBUtil.getConnection();
            
            
            String sql ="SELECT * FROM `crs-flipkart`.course where courseId=(?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            
			statement = conn.prepareStatement(sql);
			statement.setInt(1, courseId);
			
            ResultSet rs = statement.executeQuery();
            rs.next();
            if(rs.getInt("professorId") == -1) {
            
                sql = "UPDATE `crs-flipkart`.`course` SET `professorId` = ? WHERE (`courseId` = ?)";
                statement = conn.prepareStatement(sql);
                statement.setInt(1, professorId);
                statement.setInt(2, courseId);
                
                statement.executeUpdate();
            }
            else {
                // implement something in case already  exist, throw exception or something
            	throw new CourseAlreadyBeingTaughtException(courseId,professorId);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void gradeCourse(int studentId, int courseId, String grade) {
        try {
            Connection con = DBUtil.getConnection();
            Statement stmt = con.createStatement();
            String sql = "update RegisteredCourses set grade = '" + grade +
                    "' where courseId = " + courseId + " and studentId = " + studentId;
            stmt.executeUpdate(sql);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Integer> getEnrolledStudents(int courseId) {
        ArrayList<Integer> student = new ArrayList<Integer>();
        try {
            Connection con = DBUtil.getConnection();
            Statement stmt = con.createStatement();
            String sql = "select * from RegisteredCourses where courseId = " + courseId;
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                student.add(rs.getInt("studentId"));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }
}

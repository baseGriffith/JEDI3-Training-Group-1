package com.flipkart.dao;

import com.flipkart.utils.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ProfessorDaoImpl implements ProfessorDaoInterface{
    @Override
    public void signupCourse(int professorId, int courseId) {
        try {
            Connection con = DBUtil.getConnection();
            Statement stmt = con.createStatement();
            String sql = "select * from Course where courseId = " + courseId;
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            if(rs.getInt("professorId") == -1) {
                sql = "update Course set professorId =" + professorId + "where courseId = " + courseId;
                stmt.executeUpdate(sql);
            }
            else {
                // implement something in case already  exist, throw exception or something
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

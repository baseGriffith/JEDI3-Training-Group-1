package com.flipkart.dao;

import com.flipkart.bean.Course;
import com.flipkart.bean.Grade;
import com.flipkart.bean.Professor;
import com.flipkart.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class AdminDaoImpl implements AdminDaoInterface{
    @Override
    public void approveStudent(int studentId) {
        try {

        }
        catch (Exception e) {

        }
    }

    @Override
    public boolean addProfessor(Professor professor) {
        boolean ok = true;
        try {
            Connection con = DBUtil.getConnection();
            Statement stmt = con.createStatement();
            String sql = "insert into User values(" + professor.getUserId() + ",'" + professor.getName() +"','"
                    + professor.getAddress() + "','" + professor.getPassword() + "')";
            stmt.executeUpdate(sql);
            sql = "insert into Professor values(" + professor.getUserId() + ",'" + professor.getName() +"')";
            stmt.executeUpdate(sql);
        }
        catch (Exception e) {
            ok = false;
            System.out.println(e.getMessage());
        }
        return ok;
    }

    @Override
    public boolean addCourse(Course course) {
        boolean ok = true;
        try {
            Connection con = DBUtil.getConnection();
            Statement stmt = con.createStatement();
            String sql = "insert into Course values(" + course.getCourseId() + ",'" +  course.getCourseName() +"','"
                    + course.getDepartment()  + "'," + course.getProfessorId() + "," + course.getSemester() + ",'"
                    + course.getCourseCode() + "')";
            stmt.executeUpdate(sql);
        }
        catch (Exception e) {
            ok = false;
            System.out.println(e.getMessage());
        }
        return ok;
    }

    @Override
    public boolean removeCourse(int courseId) {
        boolean ok = true;
        try {
            Connection con = DBUtil.getConnection();
            Statement stmt = con.createStatement();
            String sql = "delete from Course where courseId = " + courseId;
            stmt.executeUpdate(sql);
        }
        catch (Exception e) {
            ok = false;
            System.out.println(e.getMessage());
        }
        return ok;
    }

    @Override
    public ArrayList<Grade> fetchGrade(int studentId) {
        ArrayList<Grade> grades = new ArrayList<Grade>();
        try {
            Connection con = DBUtil.getConnection();
            Statement stmt = con.createStatement();
            String sql = "select * from RegisteredCourses where studentId = " + studentId;
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                Grade g = new Grade();
                g.setValue(rs.getString("grade"));
                grades.add(g);
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return grades;
    }

    @Override
    public boolean modifyCourseDetails(Course course) {
        boolean ok = true;
        try {
            Connection con = DBUtil.getConnection();
            String sql = "update Course set courseName = ?, department = ?, professorId = ?, semester = ?, courseCode = ? where courseId = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, course.getCourseName());
            stmt.setString(2,course.getDepartment());
            stmt.setInt(3, course.getProfessorId());
            stmt.setInt(4, course.getSemester());
            stmt.setString(5, course.getCourseCode());
            stmt.setInt(6, course.getCourseId());
            stmt.executeUpdate();
        }
        catch (Exception e) {
            ok = false;
            e.printStackTrace();
        }
        return ok;
    }

}

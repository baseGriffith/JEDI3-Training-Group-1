package com.flipkart.constants;

public class SQLQueriesConstants {
	
	public static final String VIEW_COURSE_QUERY = "SELECT * FROM `crs-flipkart`.course where courseId=(?)";
	public static final String ADD_COURSE_TO_PROFESSOR_QUERY = "UPDATE `crs-flipkart`.`course` SET `professorId` = ? WHERE (`courseId` = ?)";
	public static final String VIEW_REGISTERED_COURSE_QUERY = "SELECT * FROM `crs-flipkart`.registeredcourses where courseId=(?)";
	public static final String VIEW_USER_QUERY = "SELECT * FROM `crs-flipkart`.user where userId=(?)";
	public static final String VIEW_PROFESSOR_COURSES_QUERY = "SELECT * FROM `crs-flipkart`.course where professorId=(?)";
	public static final String REGISTERED_COURSE_QUERY = "select * from registeredcourses where studentId=? and courseId=?";
	public static final String VIEW_STUDENT_COUNT_QUERY = "select COUNT(*) from registeredcourses where courseId=?";
	public static final String VIEW_COURSE_NAME_QUERY = "select courseName from course where courseId=?";
	public static final String REGISTER_COURSE_QUERY = "insert into registeredcourses values(?,?,?,?)";
	public static final String DROP_COURSE_QUERY = "delete from registeredcourses where studentId=? and courseId=?";
	public static final String VIEW_REGISTERED_COURSES_QUERY = "select registeredcourses.studentId, registeredcourses.courseId, registeredcourses.grade, course.courseName from registeredcourses join course on registeredcourses.courseId = course.courseId where studentId=? and semester=?";
	public static final String VIEW_STUDENT_QUERY = "SELECT * FROM `crs-flipkart`.student where studentId=(?)";
	public static final String COUNT_USER_WITH_ID_QUERY = "select count(*) from User where userId = ?";
	public static final String ADD_USER_QUERY = "insert into User values (?, ?, ?, ?)";
	public static final String ADD_STUDENT_QUERY = "insert into Student(studentId, branch, joiningDate, semester) values(?, ?, CURDATE(), ?)";
	public static final String PAY_FEES_QUERY = "INSERT INTO `crs-flipkart`.`payment` (`amount`, `studentId`, `paymentMode`) VALUES (?, ?, ?)";
	public static final String VIEW_STUDENT_REGISRETED_COURSE_QUERY = "SELECT * FROM `crs-flipkart`.registeredcourses where studentId=(?)";
	public static final String UPDATE_PASSWORD_QUERY = "UPDATE `crs-flipkart`.`user` SET `password` = ? WHERE (`userId` = ?);";
	public static final String VIEW_COURSE_CATALOG_QUERY = "SELECT * FROM course where semester=(?)";
	public static final String VIEW_PROFESSOR_QUERY = "SELECT * FROM `crs-flipkart`.professor where professorId=(?)";
	public static final String VIEW_ADMIN_QUERY = "SELECT * FROM `crs-flipkart`.admin where adminId=(?)";
	public static final String UPDATE_COURSE_QUERY = "update Course set courseName = ?, department = ?, professorId = ?, semester = ?, courseCode = ? where courseId = ?";
}

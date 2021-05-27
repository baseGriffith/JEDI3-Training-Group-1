package com.flipkart.client;

import java.util.ArrayList;
import java.util.Scanner;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.exception.CourseAlreadyExistsException;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.ProfessorAlreadyExistException;
import com.flipkart.service.AdminInterface;
import com.flipkart.service.AdminOperation;
import com.flipkart.service.CourseCatalogueOperation;
import com.flipkart.service.StudentOperation;
import com.flipkart.service.UserOperation;

/**
 * Displays admin menu and handles functionalities of the admin user
 * @author JEDI-Group1
 *
 */
public class CRSAdminMenu {
	
	/**
	 * Get an integer input from client
	 * @return integer
	 */
	public static int get_choice() {
		Scanner in = new Scanner(System.in);
		return in.nextInt();
	}

	/**
	 * Displays the options for admin
	 */
	public static void adminMenu() {
		System.out.println("**************Admin**************");
		System.out.println("(1).Approve student");
		System.out.println("(2).Add professor");
		System.out.println("(3).Add course to course catalog");
		System.out.println("(4).Remove course from course catalog");
		System.out.println("(5).Logout");
		System.out.println("*********************************\n");
	}
	
	/**
	 * Handles all the functionalities of admin	 * 
	 */
	public static void adminFunctionalities(){
		Scanner in = new Scanner(System.in);
		try {
			while(true) {
				CRSAdminMenu.adminMenu();
				System.out.print("Enter your choice: ");
				int choice  = CRSAdminMenu.get_choice();
				
				System.out.println();
				AdminInterface a = AdminOperation.getInstance();
				switch (choice) {
					case 1:
						StudentOperation studentOperation = StudentOperation.getInstance();
						ArrayList<Student> students=null;
						try {
							students = studentOperation.fetchAllStudents();
						}catch(Exception e) {
							System.out.println(e);
						}
						
						System.out.print("Pending Requests: ");
						if(students.size()==0) {
							System.out.println("NIL\n");
						}
						for(Student st: students) {
							System.out.println(st.toString());
							System.out.print("Action --> 1(Accept), 0(Reject):");
							int action = in.nextInt();
							if(action > 0) {
								studentOperation.approveStudent(st.getUserId());
								System.out.println("Approved\n");
							}
							else {
								studentOperation.removeStudent(st.getUserId());
								System.out.println("Rejected\n");
							}
						}
						break;
					case 2:
						System.out.print("Professor ID:");
						int profId = in.nextInt();
						System.out.print("Password: ");
						String pass = in.next();
						System.out.print("Department:");
						String  department = in.next();
						System.out.print("Name:");
						String name = in.next();
						System.out.print("Professor Address: ");
						String add = in.next();
						Professor p = new Professor();
						p.setUserId(profId);
						p.setPassword(pass);
						p.setName(name);
						p.setDepartment(department);
						p.setAddress(add);
						AdminInterface adminOp = AdminOperation.getInstance();
						try {
							adminOp.addProfessor(p);
						}catch(Exception e) {
							System.out.println(e);
						}
						
						break;
					case 3:
						System.out.print("Course Id:");
						int id = in.nextInt();
						System.out.print("Course Name:");
						String nn = in.next();
						System.out.print("Department:");
						String depart= in.next();
						System.out.print("Semester:");
						int se = in.nextInt();
						System.out.print("Course Code:");
						String cc = in.next();
						Course c = new Course();
						c.setCourseName(nn);
						c.setSemester(se);
						c.setCourseCode(cc);
						c.setDepartment(depart);
						c.setCourseId(id);
						c.setProfessorId(-1);
						CourseCatalogueOperation cco = CourseCatalogueOperation.getInstance();
						try {
							cco.addCourse(c);
						}catch(Exception e) {
							System.out.println(e);
						}
						
						break;
					case 4:
						CourseCatalogueOperation courseCatalogueOperation = CourseCatalogueOperation.getInstance();
						UserOperation userOperation = UserOperation.getInstance();
						System.out.print("Enter Semester to remove the course from: ");
						int sem = in.nextInt();
						ArrayList<Course> courses = userOperation.getCourseCatalog(sem);
						for(Course course:courses) {
							System.out.println("Course Code: "+course.getCourseCode()+" Course Name: "+course.getCourseName());
						}
						System.out.print("Enter courseId which you want to remove: ");
						int idd = in.nextInt();					
						
						try {
							courseCatalogueOperation.deleteCourse(idd);
						}catch(Exception e) {
							System.out.println(e);
						}
						
						System.out.println("Course Removed Sucessfully");
						break;
					case 5:
						System.out.println("Logged out\n");
						return;
					default:
						System.out.println("Invalid Choice");
				}
			}
		}		
		catch(Exception e) {
			System.out.println("INVALID OPERATION,LOGIN AGAIN");
		}
	}

}

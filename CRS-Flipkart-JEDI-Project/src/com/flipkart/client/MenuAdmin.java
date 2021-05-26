package com.flipkart.client;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.exception.CourseAlreadyExistsException;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.ProfessorAlreadyExistException;
import com.flipkart.service.*;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuAdmin {
	public static int get_choice() {
		Scanner in = new Scanner(System.in);
		return in.nextInt();
	}

	public static void adminMenu() {
		System.out.println("What do you want:   ");
		System.out.println("(1).Approve student");
		System.out.println("(2).Add professor");
		System.out.println("(3).Add course to course catalog");
		System.out.println("(4).Remove course from course catalog");
		System.out.println("(5).if you want to logout");
	}
	
	public static void adminFunctionalities() throws ProfessorAlreadyExistException, CourseNotFoundException, CourseAlreadyExistsException {
		Scanner in = new Scanner(System.in);
		while(true) {
			MenuAdmin.adminMenu();
			int choice  = MenuAdmin.get_choice();
			AdminInterface a = new AdminOperation();
			switch (choice) {
				case 1:
					StudentOperation studentOperation = new StudentOperation();
					ArrayList<Student> students = studentOperation.fetchAllStudents();
					System.out.println("Pending Requests: ");
					for(Student st: students) {
						System.out.println(st.toString());
						System.out.print("Action --> 1(Accept), 0(Reject):");
						int action = in.nextInt();
						if(action > 0) {
							System.out.println("Approved");
						}
						else {
							studentOperation.removeStudent(st.getUserId());
							System.out.println("Rejected.");
						}
					}
					System.out.println("Approval Functionality  would be available soon.");
					break;
				case 2:
					System.out.print("Enter New Professor ID:");
					int profId = in.nextInt();
					System.out.print("Enter New Temp Password: ");
					String pass = in.next();
					System.out.print("Enter Department:");
					String  department = in.next();
					System.out.print("Enter name:");
					String name = in.next();
					System.out.print("Enter Professor Address: ");
					String add = in.next();
					Professor p = new Professor();
					p.setUserId(profId);
					p.setPassword(pass);
					p.setName(name);
					p.setDepartment(department);
					p.setAddress(add);
					AdminInterface adminOp = new AdminOperation();
					adminOp.addProfessor(p);
					break;
				case 3:
					System.out.print("Enter New Course Id:");
					int id = in.nextInt();
					System.out.print("Enter New Course Name:");
					String nn = in.next();
					System.out.print("Enter New Department:");
					String depart= in.next();
					System.out.print("Enter New Semester:");
					int se = in.nextInt();
					System.out.print("Enter New Course Code:");
					String cc = in.next();
					Course c = new Course();
					c.setCourseName(nn);
					c.setSemester(se);
					c.setCourseCode(cc);
					c.setDepartment(depart);
					c.setCourseId(id);
					c.setProfessorId(-1);
					CourseCatalogueOperation cco = new CourseCatalogueOperation();
					cco.addCourse(c);
					break;
				case 4:
					CourseCatalogueOperation courseCatalogueOperation = new CourseCatalogueOperation();
					UserOperation userOperation = new UserOperation();
					System.out.print("Enter Semester From which you want to remove the course:");
					int sem = in.nextInt();
					ArrayList<Course> courses = userOperation.getCourseCatalog(sem);
					for(Course course:courses) {
						System.out.println("Course Code: "+course.getCourseCode()+" Course Name: "+course.getCourseName());
					}
					System.out.print("Enter courseId which you want to remove: ");
					int idd = in.nextInt();
					courseCatalogueOperation.deleteCourse(idd);
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

}

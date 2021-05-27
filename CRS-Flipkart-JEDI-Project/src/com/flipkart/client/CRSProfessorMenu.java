package com.flipkart.client;

import java.util.ArrayList;
import java.util.Scanner;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.service.ProfessorOperation;

/**
 * Displays professor menu and handles professor client responsibilities
 * @author JEDI-Group1
 *
 */
public class CRSProfessorMenu {
	
	/**
	 * Get an integer input from client
	 * @return integer
	 */
	public static int get_choice() {
		Scanner in = new Scanner(System.in);
		return in.nextInt();
	}
	
	/**
	 * Displays the professor menu
	 */
	public static void professorMenu() {
		System.out.println("*********Professer**************");
		System.out.println("(1).Register Course ");
		System.out.println("(2).View  Enrolled Students");
		System.out.println("(3).Grade Students of a course ");
		System.out.println("(4).Get all teaching courses");
		System.out.println("(5).if you want to logout");
		System.out.println("********************************");
	}

	/**
	 * Asks the user for their choice and then implements the functionality
	 * @param professor
	 */
	public static void professorFunctionalities(Professor professor) {
		while(true) {
			CRSProfessorMenu.professorMenu();			
			
			int choice  = CRSProfessorMenu.get_choice();
			
			if(choice == 5) break;
			switch (choice) {
				case 1:
					System.out.print("Enter the courseId: ");
					int courseId=CRSProfessorMenu.get_choice();					
					registerCourse(courseId,professor.getUserId());					
					break;
				case 2:
					System.out.print("Enter the courseId: ");
					courseId=CRSProfessorMenu.get_choice();					
					getEnrolledStudents(courseId);
					break;
				case 3:
					System.out.print("Enter the courseId: ");
					courseId=CRSProfessorMenu.get_choice();
					System.out.print("Enter the studentId: ");
					int studentId=CRSProfessorMenu.get_choice();
					System.out.print("Enter the stduent's grade: ");
					Scanner in = new Scanner(System.in);
					String grade=in.nextLine();
					gradeStudent(courseId,studentId,grade);					
					break;
				case 4:
					
					getRegisteredCourses(professor.getUserId()); 
					break;
				default:
					System.out.println("Invalid Choice");
			}
		}
	}
	
	/**
	 * register to a new course
	 * @param courseId
	 * @param userId
	 */
	public static void registerCourse(int courseId,int userId) {
		try {
			ProfessorOperation professorImpl=ProfessorOperation.getInstance();
			professorImpl.registerCourse(userId,courseId);
			System.out.println("Course registered!\n");
		}
		catch(Exception e) {
			System.out.println("Course registration failed!!\n");
		}
	}
	
	/**
	 * get the enrolled students in a particular course
	 * @param courseId
	 */
	public static void getEnrolledStudents(int courseId) {
		try {
			ProfessorOperation professorImpl=ProfessorOperation.getInstance();
			System.out.println();
			System.out.println("Registered students in this course are: (studentId,name)");
			ArrayList<Student> arr=professorImpl.getEnrolledStudents(courseId);
			for(Student it:arr) {
				System.out.printf("%-3s. %-20s\n",  it.getUserId(),it.getName());
				
			}			
			System.out.println();
		}
		catch(Exception e) {
			System.out.println("Some error occured, try again!!\n");
		}
	}
	
	/**
	 * grade a stdudent by passing in his courseId,studentId and grade
	 * @param courseId
	 * @param studentId
	 * @param grade
	 */
	public static void gradeStudent(int courseId,int studentId,String grade) {
		try {
			ProfessorOperation professorImpl=ProfessorOperation.getInstance();
			professorImpl.gradeStudent(courseId,studentId,grade);
			System.out.println();
		}
		catch(Exception e) {
			System.out.println("Course grading failed!!");
		}
	}
	
	/**
	 * get all the courses the professor is teaching
	 * @param professerId
	 */
	public static void getRegisteredCourses(int professerId) {
		try {
			ProfessorOperation professorImpl=ProfessorOperation.getInstance();
			ArrayList <Course> courses=professorImpl.getProfessorRegisteredCourses(professerId);
			System.out.println("Course registered are: ");
			System.out.println("************MY COURSES*********************");
			for(Course course:courses) {
				String courseCode="Course Code: "+course.getCourseCode();
				String courseName= "Course Name: "+course.getCourseName();				
				System.out.printf("%-25s. %-20s\n",  courseCode, courseName);
				      
			}
			System.out.println("*******************************************\n");
			
			
		}
		catch(Exception e) {
			System.out.println("Course generation failed!!");
		}
	}
	
	
}

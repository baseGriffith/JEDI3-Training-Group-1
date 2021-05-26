package com.flipkart.client;

import java.util.ArrayList;
import java.util.Scanner;

import com.flipkart.bean.Professor;
import com.flipkart.service.ProfessorOperation;

public class MenuProfessor {
	public static int get_choice() {
		Scanner in = new Scanner(System.in);
		return in.nextInt();
	}
	public static void professorMenu() {
		System.out.println("What do you want:  ");
		System.out.println("(1).Register Course ");
		System.out.println("(2).View  Enrolled Students");
		System.out.println("(3).Grade Students of a course ");
		System.out.println("(4).if you want to logout");
	}

	public static void professorFunctionalities(Professor professor) {
		while(true) {
			MenuProfessor.professorMenu();			
			
			int choice  = MenuProfessor.get_choice();
			System.out.println("Enter the courseId!!");
			if(choice == 4) break;
			switch (choice) {
				case 1:
					int courseId=MenuProfessor.get_choice();
					
					registerCourse(courseId,3);					
					break;
				case 2:
					courseId=MenuProfessor.get_choice();					
					getEnrolledStudents(courseId);
					break;
				case 3:
					courseId=MenuProfessor.get_choice();
					System.out.println("Enter the studentId");
					int studentId=MenuProfessor.get_choice();
					System.out.println("Enter the stduent's grade");
					Scanner in = new Scanner(System.in);
					String grade=in.nextLine();
					gradeStudent(courseId,studentId,grade);					
					break;
				default:
					System.out.println("Invalid Choice");
			}
		}
	}
	
	public static void registerCourse(int courseId,int userId) {
		try {
			ProfessorOperation professorImpl=new ProfessorOperation();
			professorImpl.registerCourse(userId,courseId);
			System.out.println("Course registered!");
		}
		catch(Exception e) {
			System.out.println("Course registration failed!!");
		}
	}
	
	public static void getEnrolledStudents(int courseId) {
		try {
			ProfessorOperation professorImpl=new ProfessorOperation();
			ArrayList <Integer> arr=professorImpl.getEnrolledStudents(courseId);
			for(Integer it:arr) {
				System.out.println(it);
			}			
		}
		catch(Exception e) {
			System.out.println("Course registration failed!!");
		}
	}
	
	public static void gradeStudent(int courseId,int studentId,String grade) {
		try {
			ProfessorOperation professorImpl=new ProfessorOperation();
			professorImpl.gradeStudent(courseId,studentId,grade);
			System.out.println("Course graded!");
		}
		catch(Exception e) {
			System.out.println("Course grading failed!!");
		}
	}
	
	
}

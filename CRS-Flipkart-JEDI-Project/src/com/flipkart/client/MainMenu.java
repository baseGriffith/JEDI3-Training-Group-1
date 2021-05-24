package com.flipkart.client;

import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.bean.User;
import com.flipkart.service.StudentImpl;

import java.util.Scanner;

public class MainMenu {

	public static int get_choice() {
		Scanner in = new Scanner(System.in);
		return in.nextInt();
	}

	public static void topMenu() {
		System.out.println("Enter the user type: ");
		System.out.println("(1).if you are a student");
		System.out.println("(2). if you aer a professor");
		System.out.println("(3).if you are admin");
		System.out.println("(4).if you want to logout");
	}

	public static void studentMenu() {
		System.out.println("What do you want: ");
		System.out.println("(1).View report card.");
		System.out.println("(2).Pay  Fees");
		System.out.println("(3).View registered Course");
		System.out.println("(4).Register");
		System.out.println("(5).if you want to logout");
	}

	public static void professorMenu() {
		System.out.println("What do you want:  ");
		System.out.println("(1).Register Course ");
		System.out.println("(2).View  Enrolled Students");
		System.out.println("(3).Grade Students of a course ");
		System.out.println("(4).if you want to logout");
	}

	public static void adminMenu() {
		System.out.println("What do you want:   ");
		System.out.println("(1).Add student");
		System.out.println("(2).Add professor");
		System.out.println("(3).generate report card");
		System.out.println("(4).if you want to logout");
	}

	public static void studentFunctionalities(Student student) {
		while(true) {
			MainMenu.studentMenu();
			int choice  = MainMenu.get_choice();
			StudentImpl f = new StudentImpl();
			if(choice == 4) break;
			switch (choice) {
				case 1:
					System.out.println(f.viewReportCard(student.getRollNumber()));
					break;
				case 2:
					f.payFees(student.getRollNumber());
					break;
				case 3:
					f.viewRegisteredCourses(student.getRollNumber());
					break;
				default:
					System.out.println("Invalid Choice");
			}
		}
	}

	public static void professorFunctionalities(Professor professor) {
		while(true) {
			MainMenu.professorMenu();
			int choice  = MainMenu.get_choice();
			if(choice == 4) break;
			switch (choice) {
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				default:
					System.out.println("Invalid Choice");
			}
		}
	}

	public static void adminFunctionalities() {
		while(true) {
			MainMenu.adminMenu();
			int choice  = MainMenu.get_choice();
			if(choice == 5) break;
			switch (choice) {
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				default:
					System.out.println("Invalid Choice");
			}
		}
	}

	public static User getUsernamePassword() {
		Scanner in = new Scanner(System.in);
		int userId = in.nextInt();
		String password = in.next();
		return new User(userId, password);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		while(true) {
			MainMenu.topMenu();
			int choice = MainMenu.get_choice();
			if(choice == 4) break;
			// get username password
			User u = MainMenu.getUsernamePassword();
			switch (choice) {
				case 1:
					//authorize - make student function call
					// make student using user we fetched
					MainMenu.studentFunctionalities(new Student());
					break;
				case 2:
					//authorize - similar to  student
					MainMenu.professorFunctionalities(new Professor());
					break;
				case 3:
					//authorize - similar to student
					MainMenu.adminFunctionalities();
					break;
				default:
					System.out.println("Invalid Choice");
			}
		}

	}

}

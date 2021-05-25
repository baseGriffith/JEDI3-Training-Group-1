package com.flipkart.client;

import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.bean.User;
import com.flipkart.service.AdminOperation;
import com.flipkart.service.AdminInterface;

import com.flipkart.service.ProfessorOperation;
import com.flipkart.service.StudentOperation;

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
					new MenuStudent().studentFunctionalities(new Student());
					break;
				case 2:
					//authorize - similar to  student
					new MenuProfessor().professorFunctionalities(new Professor());
					break;
				case 3:
					//authorize - similar to student
					new MenuAdmin().adminFunctionalities(new Student(),new Professor());
					break;
				default:
					System.out.println("Invalid Choice");
			}
		}

	}

}

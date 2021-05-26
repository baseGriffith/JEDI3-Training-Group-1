package com.flipkart.client;

import java.util.Scanner;

import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.bean.User;
<<<<<<< HEAD
import com.flipkart.exception.PaymentFailedException;
import com.flipkart.exception.ReportCardGenerationFailedException;
import com.flipkart.service.AdminOperation;
import com.flipkart.service.AdminInterface;

import com.flipkart.service.ProfessorOperation;
import com.flipkart.service.StudentOperation;

import java.util.Scanner;
=======
import com.flipkart.service.UserOperation;
>>>>>>> 7b52b9aaeeb62f8bf07313ac5bbb17eb464e2307

public class MainMenu {

	public static void topMenu() {
		System.out.println("**************Welcome********************");
		System.out.println("#Press 1 for login");
		System.out.println("#Press 2 for updatePassword");
		System.out.println("#Press 3 for exiting the application");
		System.out.println("*****************************************\n");
	}

	public static void userMenu() {
		System.out.println("Enter the user type: ");
		System.out.println("#Press 1 if you are a student");
		System.out.println("#Press 2 if you aer a professor");
		System.out.println("#Press 3 if you are admin");
		System.out.println("#Press 4 if you want to logout\n");
	}

	public static User getUsernamePassword() {
		System.out.println("Enter your user id");
		Scanner in = new Scanner(System.in);
		int userId = in.nextInt();
		System.out.println("Enter your user password");
		String password = in.next();
		return new User(userId, password);
	}

	public static void main(String[] args) throws PaymentFailedException, ReportCardGenerationFailedException {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);

		while (true) {

			MainMenu.topMenu();
<<<<<<< HEAD
			int choice = MainMenu.get_choice();
			if(choice == 4) break;
			// get username password
			User u = MainMenu.getUsernamePassword();
			switch (choice) {
				case 1:
					//authorize - make student function call
					// make student using user we fetched
					MenuStudent.studentFunctionalities(new Student());
					break;
				case 2:
					//authorize - similar to  student
					new MenuProfessor().professorFunctionalities(new Professor());
					break;
				case 3:
					//authorize - similar to student
					new MenuAdmin().adminFunctionalities(new Student(),new Professor());
=======
			int actionChoice = in.nextInt();

			if (actionChoice == 1) {
				
				MainMenu.userMenu();
				int userChoice = in.nextInt();
				
				// to exit the user menu area
				if (userChoice == 4)
>>>>>>> 7b52b9aaeeb62f8bf07313ac5bbb17eb464e2307
					break;

				switch (userChoice) {
					case 1:
						if(login(userChoice)==true) {
							//MenuStudent.studentFunctionalities(new Student());
						}		
						else {
							System.out.println("Invalid login\n");
						}
						break;
					case 2:						
						if(login(userChoice)==true) {
							//MenuProfessor.professorFunctionalities(new Professor());
						}					
						else {
							System.out.println("Invalid login\n");
						}
						break;
					case 3:						
						if(login(userChoice)==true) {
							//MenuAdmin.adminFunctionalities(new Student(), new Professor());
						}
						else {
							System.out.println("Invalid login\n");
						}
						break;
					default:
						System.out.println("Invalid choice\n");
				}

			} else if(actionChoice==2){
				userUpdatePassword();
			}else {
				System.out.println("Exiting\n");
				break;
			}
		}
		in.close();
	}

	public static boolean login(int userChoice) {
		User user = MainMenu.getUsernamePassword();
		UserOperation userOperation = new UserOperation();
		try {
			userOperation.login(user.getUserId(), user.getPassword());			
			userOperation.getRole(user.getUserId(),userChoice);
			
			System.out.println("Login successful!!!\n");
			return true;
		} catch (Exception e) {			
			return false;
		}
	}

	public static void userUpdatePassword() {
		User user = MainMenu.getUsernamePassword();
		UserOperation userOperation = new UserOperation();
		
		Scanner in=new Scanner(System.in);
		
		System.out.println("Enter your user new password\n");
		String newPassword = in.next();
		try {
			userOperation.updatePassword(user.getUserId(), newPassword);
			System.out.println("Your password has been updated!!!\n");
		} catch (Exception e) {
			System.out.println("An error occured please try again!!!\n");
		}

	}

}

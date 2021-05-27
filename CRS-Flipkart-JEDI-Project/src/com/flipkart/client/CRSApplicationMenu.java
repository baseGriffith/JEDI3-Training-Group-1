package com.flipkart.client;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.bean.User;
import com.flipkart.exception.CourseAlreadyExistsException;
import com.flipkart.exception.CourseAlreadyFullException;
import com.flipkart.exception.CourseAlreadyRegisteredException;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.LoginException;
import com.flipkart.exception.PaymentFailedException;
import com.flipkart.exception.ProfessorAlreadyExistException;
import com.flipkart.exception.ReportCardGenerationFailedException;
import com.flipkart.service.StudentOperation;
import com.flipkart.service.UserOperation;

/**
 * Main client class which starts differnet clients based on role
 * @author JEDI-Group1
 *
 */
public class CRSApplicationMenu {
	
	/**
	 * Displays the top menu of the application
	 */
	public static void topMenu() {
		System.out.println("************Welcome to CRS***********");
		System.out.println("#Press 1 to Login");
		System.out.println("#Press 2 to Update Password");
		System.out.println("#Press 3 to Register");
		System.out.println("#Press 4 to Exit the application");
		System.out.println("*************************************\n");
	}

	/**
	 * Asks the role of the user or logout choice
	 */
	public static void userMenu() {
		System.out.println("*****************LOGIN***************");
		System.out.println("#Press 1 if you are a Student");
		System.out.println("#Press 2 if you are a Professor");
		System.out.println("#Press 3 if you are Admin");
		System.out.println("#Press 4 if you want to Logout");
		System.out.println("*************************************\n");
	}

	/**
	 * fetch userid and password from the console
	 * @return
	 */
	public static User getUsernamePassword() throws Exception{
		System.out.print("User ID: ");
		Scanner in = new Scanner(System.in);
		int userId = in.nextInt();
		System.out.print("Password: ");
		String password = in.next();
		return new User(userId, password);
	}
	
	/**
	 * current logged in user
	 */
	private static int loggedInUser;

	/**
	 * main function for starting up the POS application
	 * @param args
	 * @throws ProfessorAlreadyExistException
	 * @throws CourseNotFoundException
	 * @throws CourseAlreadyExistsException
	 * @throws LoginException
	 */
	public static void main(String[] args) throws ProfessorAlreadyExistException, CourseNotFoundException, CourseAlreadyExistsException, LoginException {
		
		try {
			Scanner in = new Scanner(System.in);		
			
			while (true) {
				CRSApplicationMenu.topMenu();
				System.out.print("Enter your choice: ");
				int actionChoice = in.nextInt();
				
				System.out.println();
				
				if (actionChoice == 1) {

					CRSApplicationMenu.userMenu();
					System.out.print("Enter your choice: ");
					int userChoice = in.nextInt();			
					
					System.out.println();
					// to exit the user menu area
					if (userChoice == 4)
						break;

					switch (userChoice) {
						case 1:
							if(login(userChoice)==true) {
								try {
									StudentOperation stOp = StudentOperation.getInstance();
									Student st = stOp.getStudent(CRSApplicationMenu.loggedInUser);
									CRSStudentMenu.studentFunctionalities(st);
								} catch (ReportCardGenerationFailedException e) {
									System.out.println("Report card generation failed!!!");
								} catch (PaymentFailedException e) {
									System.out.println("Payment could not be done,try again!!!");
								} catch (CourseAlreadyRegisteredException e) {
									System.out.println("Course is already registered!!!");
								} catch (CourseAlreadyFullException e) {
									System.out.println("Course is already full!!!");
								}
							}
							else {
								System.out.println("NOT ALLOWED!!\n");
							}
							break;
						case 2:
							if(login(userChoice)==true) {							
								CRSProfessorMenu.professorFunctionalities(new Professor(CRSApplicationMenu.loggedInUser));
							}
							else {
								System.out.println("INVALID LOGIN CREDENTIALS!!\n");
							}
							break;
						case 3:
							if(login(userChoice)==true) {
								CRSAdminMenu.adminFunctionalities();
							}
							else {
								System.out.println("INVALID LOGIN CREDENTIALS!!\n");
							}
							break;
						case 4:
							break;
						default:
							System.out.println("INVALID CHOICE!!\n");
					}

				} else if(actionChoice==2){
					userUpdatePassword();
				} else if(actionChoice==3){
					
					in = new Scanner(System.in);
					System.out.print("StudentId: ");
					int userId = in.nextInt();
					System.out.print("Name: ");
					String name = in.next();
					System.out.print("Address: ");
					String address = in.next();
					System.out.print("Password: ");
					String password = in.next();
					System.out.print("Branch: ");
					String branch = in.next();

					System.out.println("\n*************************************\n");
					
					Student student = new Student(userId, name, address, password, branch);
					StudentOperation studentOperation = StudentOperation.getInstance();
					try {
						if(studentOperation.register(student)){
							System.out.println("\n********* STUDENT REGISTRATION SUCCESSFUL!!*********\n\n");
						}
					} catch(Exception e) {
						e.getMessage();
					}
				} else {
					System.out.println("Exiting\n");
					break;
				}
			}
			in.close();
		}
		catch(Exception e) {
			System.out.println("INVALID OPERATION,LOGIN AGAIN!!");
		}
		
	}

	/**
	 * login function working based on id, role
	 * @param userChoice
	 * @return
	 */
	public static boolean login(int userChoice) throws Exception{		
		User user = CRSApplicationMenu.getUsernamePassword();
		UserOperation userOperation = UserOperation.getInstance();
		try {
			userOperation.login(user.getUserId(), user.getPassword());
			userOperation.getRole(user.getUserId(),userChoice);
			
			System.out.println("\n**************LOGIN SUCCESSFUL**************\n");
			CRSApplicationMenu.loggedInUser =  user.getUserId();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * update password after verifying the old credentials
	 * @throws LoginException
	 */
	public static void userUpdatePassword() throws Exception {		
		User user = CRSApplicationMenu.getUsernamePassword();
		UserOperation userOperation = UserOperation.getInstance();
		userOperation.login(user.getUserId(), user.getPassword());
		Scanner in=new Scanner(System.in);

		System.out.print("New Password: ");
		String newPassword = in.next();
		
		System.out.println();
		
		try {
			userOperation.updatePassword(user.getUserId(), newPassword);
			System.out.println("PASSWORD UPDATED!\n");
		} catch (Exception e) {
			System.out.println("ERROR OCCURED, TRY AGAIN!!\n");
		}

	}

}
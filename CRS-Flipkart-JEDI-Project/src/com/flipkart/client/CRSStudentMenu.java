package com.flipkart.client;

import java.util.ArrayList;
import java.util.Scanner;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.exception.CourseAlreadyFullException;
import com.flipkart.exception.CourseAlreadyRegisteredException;
import com.flipkart.exception.PaymentFailedException;
import com.flipkart.exception.ReportCardGenerationFailedException;
import com.flipkart.service.*;

/**
 * Student client functionalities are provided by this class
 * @author JEDI-Group1
 *
 */
public class CRSStudentMenu {
	
	/**
	 * Get an integer input from client
	 * @return integer
	 */
	public static int get_choice() {
		Scanner in = new Scanner(System.in);
		return in.nextInt();
	}

	/**
	 * displays the student choices
	 */
	public static void studentMenu() {
		System.out.println("What do you want: ");
		System.out.println("(1).View Course Catalog");
		System.out.println("(2).Semester Registration");
		System.out.println("(3).Add Course");
		System.out.println("(4).Drop Course");
		System.out.println("(5).Pay Fees");
		System.out.println("(6).View registered Course");
		System.out.println("(7).View report card.");
		System.out.println("(8).Logout");
	}

	/**
	 * Takes the user input and based on the choice implement the functionalities
	 * @param student
	 * @throws ReportCardGenerationFailedException
	 * @throws PaymentFailedException
	 * @throws CourseAlreadyRegisteredException
	 * @throws CourseAlreadyFullException
	 */
	public static void studentFunctionalities(Student student) throws ReportCardGenerationFailedException, PaymentFailedException, CourseAlreadyRegisteredException, CourseAlreadyFullException {
		ArrayList<Integer> courseIdPrimary = new ArrayList<Integer>(), courseIdAlternate = new ArrayList<Integer>();
		Scanner in = new Scanner(System.in);
		while(true) {
			studentMenu();
			System.out.print("Enter your choice: ");
			int choice  = CRSStudentMenu.get_choice();
			System.out.println();
			
			StudentOperation f = StudentOperation.getInstance();
			ReportCardInterface reportCard = ReportCardOperation.getInstance();
			switch (choice) {

				case 1:
					UserInterface user = UserOperation.getInstance();
					ArrayList<Course> courseCatalog = user.getCourseCatalog(student.getSemester());
					System.out.println("************COURSE CATALOG******************");
					for(Course course:courseCatalog) {
						String courseCode="Course Code: "+course.getCourseCode();
						String courseName= "Course Name: "+course.getCourseName();
						String department="Department: "+course.getDepartment();
						System.out.printf("%-25s. %-20s\n",  courseCode, courseName);
						      
					}
					System.out.println("*******************************************\n");
					break;
				case 2:
					courseIdPrimary.clear();
					courseIdAlternate.clear();
					in = new Scanner(System.in);
					System.out.println("Enter the primary course ids you want to register: ");
					for(int i=0;i<4;i++) {
						courseIdPrimary.add(in.nextInt());
					}
					System.out.println("Enter the alternate course ids you want to register: ");
					for(int i=0;i<2;i++) {
						courseIdAlternate.add(in.nextInt());
					}
					System.out.print("\nYour chosen courses are: ");
					System.out.print(courseIdPrimary+" ");
					System.out.println(courseIdAlternate);
					System.out.println("Proceed to pay fees to complete Registration,press 5\n");
					break;

				case 3:

					System.out.print("(1).Add primary course  (2)Add alternate course ----- ");
					int courseChoice = in.nextInt();
					switch(courseChoice) {

						case 1:

							if(courseIdPrimary.size() >= 4) {
								System.out.println("Primary course list already full\n");
								break;
							}
							System.out.println("Enter the courseId: ");
							int courseId = in.nextInt();
							int alreadyExist = 0;
							for(int coursePrimary : courseIdPrimary) {
								if(coursePrimary == courseId) {
									alreadyExist = 1;
									break;
								}
							}
							if(alreadyExist == 1) {
								System.out.println("Course already added.\n");
								break;
							}
							
							System.out.println("Course added\n");
							courseIdPrimary.add(courseId);
							break;

						case 2:

							if(courseIdAlternate.size() >= 4) {
								System.out.println("Alternate course list already full\n");
								break;
							}
							System.out.println("Enter the courseId: ");
							courseId = in.nextInt();
							alreadyExist = 0;
							for(int courseAlternate : courseIdAlternate) {
								if(courseAlternate == courseId) {
									alreadyExist = 1;
									break;
								}
							}
							if(alreadyExist == 1) {
								System.out.println("Course already added.");
								break;
							}
							courseIdAlternate.add(courseId);
							System.out.println("Course added\n");
							break;
					}
					break;

				case 4:

					System.out.print("(1).Drop primary course  (2)Drop alternate course ----- ");
					courseChoice = in.nextInt();
					switch(courseChoice) {

						case 1:

							System.out.print("Enter the courseId: ");
							int courseId = in.nextInt();
							int dropped = 0;
							int count=0;
							for(int primaryCourse: courseIdPrimary) {
								if(primaryCourse == courseId) {
									courseIdPrimary.remove(count);
									dropped = 1;
									break;
								}
								count++;
							}
							System.out.println(courseIdPrimary);
							System.out.println(courseIdAlternate);
							if(dropped == 1) {
								System.out.println("Course dropped\n");
							}
							else {
								System.out.println("Course not found\n");
							}
							break;

						case 2:
							System.out.print("Enter the courseId: ");
							courseId = in.nextInt();
							dropped = 0;
							count=0;
							for(int alternateCourse: courseIdAlternate) {
								if(alternateCourse == courseId) {
									courseIdAlternate.remove(count);
									dropped = 1;
									break;
								}
								count++;
							}
							if(dropped == 1) {
								System.out.println("Course dropped\n");
							}
							else {
								System.out.println("Course not found\n");
							}
							break;
					}
					break;

				case 5:
					if(courseIdPrimary.size()<4 || courseIdAlternate.size()<2 ) {
						System.out.println("You have not selected the required number of courses\n");
						break;
					}
					System.out.print("Enter the amount: ");
					int amount = in.nextInt();
					System.out.print("Choose mode of payment: 1) Card 2)Net Banking  ----- ");
					int modeOfPaymentChoice = in.nextInt();
					String modeOfPayment = modeOfPaymentChoice == 1 ? "Card" : "Net Banking";
					if(modeOfPaymentChoice==1) {
						System.out.print("Enter the card number: ");
						String cardNo=in.next();
						if(cardNo.length()<16) {
							System.out.println("Invalid card!!!");
							break;
						}
						System.out.println();
						System.out.print("Enter the expiry date: MM/YYYY");
						in.next();
						System.out.println();
						System.out.print("Enter the CVV number: ");
						in.next();
					}
					else {
						System.out.print("Enter the bank name: ");
						in.next();
						System.out.println();
						System.out.print("Enter the userId: ");
						in.next();
						System.out.println();
						System.out.print("Enter the password: ");
						in.next();
					}
					boolean status = f.payFees(student.getUserId(), amount, modeOfPayment);
					if(status) {
						
						SemesterRegistrationOperation sro = SemesterRegistrationOperation.getInstance();
						System.out.println("Payment successfull!!\n");
						for(Integer x: courseIdPrimary) {
							sro.addCourse(student.getUserId(), x);
						}
					}
					break;

				case 6:
					ArrayList<Course> registeredCourse = f.viewRegisteredCourses(student.getUserId());
					System.out.println("************REGISTERED COURSES*****************");
					for(Course course:registeredCourse) {
						String courseCode="Course Code: "+course.getCourseCode();
						String courseName= "Course Name: "+course.getCourseName();						
						System.out.printf("%-25s. %-20s\n",  courseCode, courseName);						      
					}
					System.out.println("**********************************************\n");
					
					break;

				case 7:
					System.out.print("Enter the semester: ");
					int semester = in.nextInt();
					try {
						reportCard.printReportCard(student.getUserId(), semester);
					}
					catch(Exception e) {
						System.out.println("All courses not graded, report card cannot be generated\n");
						
					}
					break;
				case 8:
					return;
				default:
					System.out.println("Invalid Choice");
			}
		}
	}
}
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

public class MenuStudent {
	public static int get_choice() {
		Scanner in = new Scanner(System.in);
		return in.nextInt();
	}

	public static void studentMenu() {
		System.out.println("What do you want: ");
		System.out.println("(1).View Course Catalog");
		System.out.println("(2).Register");
		System.out.println("(3).Add Course");
		System.out.println("(4).Drop Course");
		System.out.println("(5).Pay Fees");
		System.out.println("(6).View registered Course");
		System.out.println("(7).View report card.");
		System.out.println("(8).Logout");
	}

	public static void studentFunctionalities(Student student) throws ReportCardGenerationFailedException, PaymentFailedException, CourseAlreadyRegisteredException, CourseAlreadyFullException {
		ArrayList<Integer> courseIdPrimary = new ArrayList<Integer>(), courseIdAlternate = new ArrayList<Integer>();
		Scanner in = new Scanner(System.in);
		while(true) {
			studentMenu();
			int choice  = MenuStudent.get_choice();
			StudentOperation f = new StudentOperation();
			ReportCardInterface reportCard = new ReportCardOperation();
			switch (choice) {

				case 1:
					UserInterface user = new UserOperation();
					ArrayList<Course> courseCatalog = user.getCourseCatalog(student.getSemester());
					for(Course course:courseCatalog) {
						System.out.println("Course Code: "+course.getCourseCode()+" Course Name: "+course.getCourseName());
					}
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
					System.out.println(courseIdPrimary);
					System.out.println(courseIdAlternate);
					break;

				case 3:

					System.out.println("(1).Add primary course  (2)Add alternate course");
					int courseChoice = in.nextInt();
					switch(courseChoice) {

						case 1:

							if(courseIdPrimary.size() >= 4) {
								System.out.println("Primary course list already full");
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
								System.out.println("Course already added.");
								break;
							}
							courseIdPrimary.add(courseId);
							break;

						case 2:

							if(courseIdAlternate.size() >= 4) {
								System.out.println("Alternate course list already full");
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

							break;
					}
					break;

				case 4:

					System.out.println("(1).Drop primary course  (2)Drop alternate course");
					courseChoice = in.nextInt();
					switch(courseChoice) {

						case 1:

							System.out.println("Enter the courseId: ");
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
								System.out.println("Course dropped");
							}
							else {
								System.out.println("Course not found");
							}
							break;

						case 2:
							System.out.println("Enter the courseId: ");
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
								System.out.println("Course dropped");
							}
							else {
								System.out.println("Course not found");
							}
							break;
					}
					break;

				case 5:
					if(courseIdPrimary.size()<4 || courseIdAlternate.size()<2 ) {
						System.out.println("You have not selected the required number of courses");
						break;
					}
					System.out.println("Enter the amount: ");
					int amount = in.nextInt();
					System.out.println("Choose mode of payment: 1) Card 2)Net Banking");
					int modeOfPaymentChoice = in.nextInt();
					String modeOfPayment = modeOfPaymentChoice == 1 ? "Card" : "Net Banking";
					boolean status = f.payFees(student.getUserId(), amount, modeOfPayment);
					if(status) {
						SemesterRegistrationOperation sro = new SemesterRegistrationOperation();
						for(Integer x: courseIdPrimary) {
							sro.addCourse(student.getUserId(), x);
						}
					}
					break;

				case 6:
					ArrayList<Course> registeredCourse = f.viewRegisteredCourses(student.getUserId());
					for(Course course:registeredCourse) {
						System.out.println("Course Code: "+course.getCourseCode()+" Course Name: "+course.getCourseName());
					}
					break;

				case 7:
					System.out.println("Enter the semester: ");
					int semester = in.nextInt();
					reportCard.printReportCard(student.getUserId(), semester);
					break;
				case 8:
					return;
				default:
					System.out.println("Invalid Choice");
			}
		}
	}
}
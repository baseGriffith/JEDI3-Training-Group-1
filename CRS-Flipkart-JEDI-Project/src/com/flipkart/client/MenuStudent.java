package com.flipkart.client;

import java.util.Scanner;

import com.flipkart.bean.Student;
import com.flipkart.service.StudentOperation;

public class MenuStudent {
	public static int get_choice() {
		Scanner in = new Scanner(System.in);
		return in.nextInt();
	}
	
	public static void studentMenu() {
		System.out.println("What do you want: ");
		System.out.println("(1).View report card.");
		System.out.println("(2).Pay  Fees");
		System.out.println("(3).View registered Course");
		System.out.println("(4).Register");
		System.out.println("(5).if you want to logout");
	}
	
	public static void studentFunctionalities(Student student) {
		while(true) {
			MenuStudent.studentMenu();
			int choice  = MainMenu.get_choice();
			StudentOperation f = new StudentOperation();
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
}

package com.flipkart.client;

import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.service.AdminInterface;
import com.flipkart.service.AdminOperation;

public class MenuAdmin {
	public static void adminMenu() {
		System.out.println("What do you want:   ");
		System.out.println("(1).Approve student");
		System.out.println("(2).Add professor");
		System.out.println("(3).generate report card");
		System.out.println("(4).if you want to logout");
	}
	
	public static void adminFunctionalities(Student student,Professor professor) {
		while(true) {
			MenuAdmin.adminMenu();
			int choice  = MainMenu.get_choice();
			AdminInterface a = new AdminOperation();
			if(choice == 5) break;
			switch (choice) {
				case 1:
					a.approveStudent(student);
					break;
				case 2:
					a.addProfessor(professor);
					break;
				case 3:
					a.generateReportCard(student.getRollNumber());
					break;
				default:
					System.out.println("Invalid Choice");
			}
		}
	}

}

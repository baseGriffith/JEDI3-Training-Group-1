package com.flipkart.client;
/**
 * @author JEDI-Group-1
 */
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.exception.ProfessorAlreadyExistException;
import com.flipkart.service.AdminInterface;
import com.flipkart.service.AdminOperation;

import java.util.Scanner;

public class MenuAdmin {
	public static int get_choice() {
		Scanner in = new Scanner(System.in);
		return in.nextInt();
	}

	public static void adminMenu() {
		System.out.println("What do you want:   ");
		System.out.println("(1).Approve student");
		System.out.println("(2).Add professor");
		System.out.println("(3).generate report card");
		System.out.println("(4).if you want to logout");
	}
	
	public static void adminFunctionalities() throws ProfessorAlreadyExistException {
		Scanner in = new Scanner(System.in);
		while(true) {
			MenuAdmin.adminMenu();
			int choice  = MenuAdmin.get_choice();
			AdminInterface a = new AdminOperation();
			if(choice == 5) break;
			switch (choice) {
				case 1:
					System.out.println("Approval Functionality  would be available soon.");
					break;
				case 2:
					System.out.println("Enter New Professor ID:");
					int profId = in.nextInt();
					System.out.println("Enter New Temp Password: ");
					String pass = in.next();
					System.out.println("Enter Department:");
					String  department = in.next();
					System.out.println("Enter name:");
					String name = in.next();
					System.out.println("Enter Professor Address: ");
					String add = in.next();
					Professor p = new Professor();
					p.setUserId(profId);
					p.setPassword(pass);
					p.setName(name);
					p.setDepartment(department);
					p.setAddress(add);
					AdminInterface adminOp = new AdminOperation();
					adminOp.addProfessor(p);
					break;
				case 3:
					System.out.println("Generation Functionality  would be available soon.");
					break;
				default:
					System.out.println("Invalid Choice");
			}
		}
	}

}

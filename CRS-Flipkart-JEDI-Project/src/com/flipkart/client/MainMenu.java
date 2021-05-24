package com.flipkart.client;

import java.util.Scanner;

public class MainMenu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		Scanner in=new Scanner(System.in);
		
		System.out.println("Enter the user type: ");
		System.out.println("(1).Enter 0 if you are a student");
		System.out.println("(2).Enter 1 if you aer a professor");
		System.out.println("(3).Enter 2 if you are admin");
		System.out.println("(4).Enter 3 if you want to logout");
		
		int choice=in.nextInt();
		do {			
			switch(choice) {
				case 0:
					MenuStudent student=new MenuStudent();
					break;
				case 1:
					MenuProfessor professor=new MenuProfessor();
					break;
				case 2:
					MenuAdmin admin=new MenuAdmin();
					break;
			}
			choice=in.nextInt();
		}while(choice!=3);
	}

}

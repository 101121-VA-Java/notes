package com.revature.controllers;

import java.util.Scanner;

public class FrontController {
	private Scanner sc; 
	private EmployeeController ec;
	
	public FrontController() {
		sc = new Scanner(System.in);
		ec = new EmployeeController();
	}
	
	public void run() {
		boolean run = true;
		
		while(run) {
			System.out.println("Please select an option:");
			System.out.println("1: register");
			System.out.println("2: login");
			System.out.println("3: exit");
			
			String choice = sc.nextLine();
			
			switch(choice) {
			case "1":
				ec.registerEmployee(sc);
				// TODO: if an employee is not registered, display a different message
				break;
			case "2":
				break;
			case "3":
				run = false;
				break;
			default:
				System.out.println("Invalid input.");
			}
		}
		
		sc.close();
	}
}

package com.revature.driver;

import java.util.Scanner;

import com.revature.services.OopService;

public class Driver {
	
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int i; //declaring a variable
		i = 0; // assigning the value 0
		i = 2; // reassigning the value to be 2
		
		OopService oop = new OopService();
		System.out.println("What would like to do?");
		String choice = sc.nextLine();
		switch(choice) {
			case "encapsulation":
				oop.doEncapsulation();
				break;
			case "inheritance":
				oop.doInheritance();
				break;
			case "polymorphism":
				oop.doPolymorphism();
				break;
			default:
				System.out.println("Option not available.");
		}
		sc.close();
	}

}

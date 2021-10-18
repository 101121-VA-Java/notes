package com.revature.driver;

import com.revature.models.User;

public class Driver {

	public static void main(String[] args) {
		
		// Static method call: [className].[methodName]();
		User.sayClassName();
		
		System.out.println("Number of users: " + User.numberOfUser);
		
		// variable declaration
		User u;
		// variable assignment
		u = new User();
		System.out.println(u.name);
		/*
		 * first resolve the right side of the assignment operator "new User();"
		 * new User() invokes the no args constructor declared in the User class
		 * 		- numberOfUser is going to be incremented
		 * 		- name of the instance created is set to be "default name"
		 * finally once the object has been instantiated in memory, the memory address is assigned to the reference variable u.		
		 */
		u = new User("Kevin");
		/*
		 * first resolve the right side of the assignment operator "new User("Kevin");"
		 * new User() invokes the parameterized constructor declared in the User class that takes a String argument
		 * 		- numberOfUser is going to be incremented
		 * 		- name of the instance created is set to be "Kevin"
		 * finally once the object has been instantiated in memory, the memory address is assigned to the reference variable u.		
		 */
		System.out.println(u.name);
		// Instance method call: [instance].[methodName]();
		u.sayMyName();
		
		u = new User();
		
		User i = new User("Me");
		
		User.sayNumOfUsers();

	}

}

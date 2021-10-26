package com.revature.controllers;

import com.revature.exceptions.UserNotFoundException;
import com.revature.models.Employee;
import com.revature.services.EmployeeService;

public class EmployeeController {

	private EmployeeService us = new EmployeeService();
	
	public void searchForEmployee() {
		// scanner getting user input
		try {
			Employee e = us.getEmployeeById(0);
		} catch (UserNotFoundException e) {
			System.out.println("User doesn't exist.");
			e.printStackTrace();
		} 
	}
}

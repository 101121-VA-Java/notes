package com.revature.services;

import com.revature.exceptions.UserNotFoundException;
import com.revature.models.Employee;
import com.revature.models.Role;
import com.revature.repositories.EmployeeArray;
import com.revature.repositories.EmployeeDao;

public class EmployeeService {

	private EmployeeDao ed; 
	
	
	
	public EmployeeService() {
		super();
		ed = new EmployeeArray();
	}

	public int addEmployee(Employee e) {
		/*
		 * add business logic here to manipulate e before storage
		 * Employee, when registering are going to input 
		 * 		- name
		 * 		- Username
		 * 		- password
		 * 
		 * System should assign, Role, manager
		 * 		- manager is null by default (default value of an object is null)
		 * 		
		 */
		
		e.setRole(Role.BASIC_USER);
		
		return ed.addEmployee(e);
	}
	
	public Employee getEmployeeById(int id) throws UserNotFoundException  {

		if(id > 0) { // just for example's sake
		throw new UserNotFoundException();
		} 

		return null;
	}
}

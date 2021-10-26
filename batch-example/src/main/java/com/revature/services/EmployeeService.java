package com.revature.services;

import com.revature.exceptions.UserNotFoundException;
import com.revature.models.Employee;
import com.revature.repositories.EmployeeDao;

public class EmployeeService {

	private EmployeeDao ed; 
	
	public int addEmployee(Employee e) {
		/*
		 * add business logic here to manipulate e before storage
		 */
		return ed.addEmployee(e);
	}
	
	public Employee getEmployeeById(int id) throws UserNotFoundException  {

		if(id > 0) { // just for example's sake
		throw new UserNotFoundException();
		} 

		return null;
	}
}

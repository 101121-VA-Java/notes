package com.revature.services;

import com.revature.daos.DaoFactory;
import com.revature.daos.EmployeeDao;
import com.revature.models.Employee;

public class AuthService {

	private EmployeeDao ed;

	// Retrieving an instance of EmployeeDao
	public AuthService() {
		ed = DaoFactory.getDAOFactory().getEmployeeDao();
	}

	// mimicking token behavior
	public String login(String username, String password) {
		
		String token = null;

		Employee principal = ed.getEmployeeByUsername(username);

		if (principal != null && principal.getPassword().equals(password)) {

			token = principal.getId() + ":" + principal.getRole();
		}

		return token;
	}
}

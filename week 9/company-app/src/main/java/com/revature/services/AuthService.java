package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dtos.Principal;
import com.revature.exceptions.LoginException;
import com.revature.models.Employee;
import com.revature.repositories.EmployeeRepository;

@Service
public class AuthService {

	private EmployeeRepository er;
	
	@Autowired
	public AuthService(EmployeeRepository er) {
		this.er = er;
	}
	
	public Principal login(String username, String password) {
		Employee e = er.findEmployeeByUsername(username);
		if(e == null || !e.getPassword().equals(password)) {
			throw new LoginException();
		}
		return new Principal(e);
	}
	
	public String generateToken(Principal principal) {
		/*
		 * Insert logic to generate a Token here
		 */
		String token = principal.getId() + ":" + principal.getRole();
		
		return token;
	}
}

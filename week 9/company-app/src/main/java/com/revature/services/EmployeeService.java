package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.repositories.EmployeeRepository;

@Service
public class EmployeeService {

	private EmployeeRepository er;
	
	@Autowired
	public EmployeeService(EmployeeRepository er) {
		this.er = er;
	}
	
}

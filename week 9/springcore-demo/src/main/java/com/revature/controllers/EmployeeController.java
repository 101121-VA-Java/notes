package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.revature.services.EmployeeService;

//@Controller
public class EmployeeController {

	private EmployeeService es;

//	@Autowired
	public EmployeeController(EmployeeService es) {
		super();
		this.es = es;
	}
	
	
}

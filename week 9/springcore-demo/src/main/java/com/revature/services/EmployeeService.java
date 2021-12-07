package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.daos.EmployeeDao;

//@Service
public class EmployeeService {

//	@Autowired
	private EmployeeDao ed;

	//Constructor injection, no need to instantiate an employee dao
//	@Autowired
	public EmployeeService(EmployeeDao ed) {
		super();
		this.ed = ed;
	}
	
	
}

package com.revature.services;

import com.revature.daos.DaoFactory;
import com.revature.daos.EmployeeDao;

public class EmployeeService {

	// private EmployeeDao ed = new EmployeePostgres();
	private EmployeeDao ed = DaoFactory.getDaoFactory().getEmployeeDao();
}

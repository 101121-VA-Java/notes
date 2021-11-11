package com.revature.services;

import com.revature.daos.DaoFactory;
import com.revature.daos.EmployeeDao;
import com.revature.models.Employee;

public class EmployeeService {

	// private EmployeeDao ed = new EmployeePostgres();
	private EmployeeDao ed = DaoFactory.getDaoFactory().getEmployeeDao();

	public Employee addEmployee(Employee e) {
		int newId = ed.addEmployee(e);
		if ( newId == -1) {
			return null;
		}
		e.setId(newId);
		return e;
	}
}

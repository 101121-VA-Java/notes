package com.revature.daos;

import java.util.List;

import com.revature.models.Employee;

public interface EmployeeDao {
	
	Employee add(Employee e);
	Employee getById(int id);
	Employee getByName(String name);
	List<Employee> getEmployees();
	List<Employee> getEmployeesByDepartmentId(int deptId);
	void update(Employee d);
	void delete(Employee d);
	
}

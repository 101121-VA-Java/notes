package com.revature.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Employee;
import com.revature.util.HibernateUtil;

public class EmployeeHibernate implements EmployeeDao{

	/**
	 * Adds an employee to the database
	 * @return the employee with the new id or null if no record is created
	 */
	@Override
	public Employee add(Employee e) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Retrieves an employee by its id from the database
	 * @return the employee if found or null otherwise
	 */
	@Override
	public Employee getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Retrieves an employee by its name from the database
	 * @return the employee if found or null otherwise
	 */
	@Override
	public Employee getByName(String name) {
		// TODO Auto-generated method stub
		/*
		 * Use HQL
		 */
		return null;
	}

	/**
	 * Retrieves all employees from the database
	 * @return a List of Employee objects
	 */
	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Retrieves employees by department id from the database
	 * @return a List of Employee objects
	 */
	@Override
	public List<Employee> getEmployeesByDepartmentId(int deptId) {
		// TODO Auto-generated method stub
		/*
		 * Use a Criteria
		 */
		return null;
	}

	/**
	 * Updates an employee
	 */
	@Override
	public void update(Employee d) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Deletes an employee
	 */
	@Override
	public void delete(Employee d) {
		// TODO Auto-generated method stub
		
	}
}

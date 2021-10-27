package com.revature;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.revature.models.Employee;
import com.revature.models.Role;
import com.revature.repositories.EmployeeArray;
import com.revature.repositories.EmployeeDao;

public class EmployeeDaoTest {

	private EmployeeDao ed;
	
	@BeforeEach
	public void setup() {
		ed = new EmployeeArray();
		ed.addEmployee(new Employee("Kevin", "Kev", "KevPass", Role.BASIC_USER, null));
	}
	
	@Test
	public void getAllEmployees(){
		Employee[] expected = {	new Employee(0, "EnrollmentAdmin", "EAdmin", "EAPass", Role.ADMIN, null), 
								new Employee(1, "Kevin", "Kev", "KevPass",Role.BASIC_USER, null)};
		Employee[] actual = ed.getAllEmployees();
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void addEmployeeValid() {
		Employee[] expected = {new Employee(0, "Kevin", "Kev", "KevPass",Role.BASIC_USER, null), 
								new Employee(1, "Kev", "K", "Pass",Role.BASIC_USER, null) };
		
		// Adding an employee
		ed.addEmployee(new Employee(1, "Kev", "K", "Pass",Role.BASIC_USER, null));
		
		assertArrayEquals(expected, ed.getAllEmployees());
	}
}

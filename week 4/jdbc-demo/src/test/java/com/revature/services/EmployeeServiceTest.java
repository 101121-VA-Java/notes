package com.revature.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.revature.daos.EmployeeDao;
import com.revature.models.Employee;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

	// Mocked object, whenever a specific method is called on that mocked object, we can specify a return instead of calling the actual implementation
	@Mock
	private EmployeeDao ed;
	
	@InjectMocks
	private EmployeeService es;
	
	@Test
	public void addEmployeeTestValid() {
		/*
		 *  Whenever addEmployee method from employee dao interface is called with parameters of new Employee("test","test","test","test",new Employee(1), 
		 *  the returned id will always be 2
		 */
		Mockito.when(ed.addEmployee(new Employee("test","test","test","test",new Employee(1)))).thenReturn(2);
		
		Employee expected = new Employee(2,"test","test","test","test",new Employee(1));
		Employee actual = es.addEmployee(new Employee("test","test","test","test",new Employee(1)));
		assertEquals(expected, actual);
	}
	
}

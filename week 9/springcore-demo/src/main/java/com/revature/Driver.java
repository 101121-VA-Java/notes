package com.revature;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.models.Department;
import com.revature.models.Employee;

public class Driver {

	// Indicates that this object will be managed by AC
	@Bean
	public Scanner getScanner() {
		return new Scanner(System.in);
	}
	
	public static void main(String[] args) {
		// Traditional way to instantiate objects
		Department d = new Department();

		
		// Using Spring
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		Department d1 = (Department) ac.getBean("department");
		// d1 is injected into e
		d1.setName("Hello");
		
		Employee e = (Employee) ac.getBean("employee");
		
		System.out.println(d1);
		System.out.println(e);
	}

}

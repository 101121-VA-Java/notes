package com.revature;

import java.util.List;

import com.revature.models.Employee;
import com.revature.services.EmployeeService;

import io.javalin.Javalin;
import io.javalin.http.HttpCode;

public class Driver {
	
	private static EmployeeService es = new EmployeeService();
	
	public static void main(String[] args) {
		
		// Creating an instance of javalin and starting on port 8080
		Javalin app = Javalin.create().start();
		
		app.get("employees", (ctx) ->{
			List<Employee> employees = es.getEmployees();
			
			ctx.json(employees);
			// implicit
			ctx.status(HttpCode.OK);
		});
	}

}

package com.revature.controllers;

import java.util.List;

import com.revature.models.Employee;
import com.revature.services.EmployeeService;

import io.javalin.http.Context;
import io.javalin.http.HttpCode;

public class EmployeeController {

	private static EmployeeService es = new EmployeeService();

	public static void getEmployees(Context ctx) {
		List<Employee> employees = es.getEmployees();

		ctx.json(employees);
		// implicitely Javalin sets the status code to 200
		ctx.status(HttpCode.OK);
	}

	public static void registerEmployee(Context ctx) {
		/*
		 * add employee requires an Employee Object with a name, username, password
		 * 
		 * HTTP request - version - headers - body - need to have name, username,
		 * password - url - localhost:8080/employees - http verb/method... - POST
		 */

		/*
		 * Object mapper converts JSON object to Java Object mapped to the Employee
		 * class - fields the the JSON object that match fields in the Employee java
		 * class will be mapped accordingly
		 */
		Employee newEmp = es.addEmployee(ctx.bodyAsClass(Employee.class)); // should return new employee with id if
																			// successful, or null otherwise

		if (newEmp == null) {
			ctx.status(HttpCode.BAD_REQUEST);
		} else {
			ctx.status(HttpCode.CREATED);
		}

	}

	public static void getEmployeeById(Context ctx) {
		// pathParam("nameOfPathParam");
		int id = Integer.parseInt(ctx.pathParam("id"));

		Employee e = es.getEmployeeById(id);

		if (e != null) {
			ctx.json(e);
			ctx.status(HttpCode.OK);
		} else {
//			ctx.status(404);
			ctx.status(HttpCode.NOT_FOUND);
		}
	}

	public static void getTest(Context ctx) {
		ctx.result("Test!");
	}
}

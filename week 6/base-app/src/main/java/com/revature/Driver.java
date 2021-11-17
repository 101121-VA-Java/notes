package com.revature;

import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.post;

import com.revature.controllers.EmployeeController;

import io.javalin.Javalin;

public class Driver {
	
	
	public static void main(String[] args) {
		
		// Creating an instance of javalin and starting on port 8080
		Javalin app = Javalin.create( (config) -> {
				config.enableCorsForAllOrigins();
				/*
				 * Enables CORS: Cross Origin Resource Sharing
				 * 	- protective mechanism built into most browsers 
				 * 	- restricts resources to be only be allowed by webpages on the same domain
				 */
			}).start();
		
		app.routes(() -> {
			path("employees", ()->{
				get(EmployeeController::getEmployees);
				post(EmployeeController::registerEmployee);
			});
		});
	}

}

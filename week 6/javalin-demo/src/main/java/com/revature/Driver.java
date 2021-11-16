package com.revature;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Human;

import io.javalin.Javalin;

public class Driver {

	public static void main(String[] args) {
		// Creating a simple javalin object, additional configuration can be passed in
		Javalin app = Javalin.create( (config) -> {
			// configuration goes here
			
//			config.addStaticFiles();
			// to link to a folder in the project containing static html/css/js file to  be served to the client
		});
		
		// By default, starts on port 8080
		app.start();
		
		// a lambda of type Handler is passed it. it takes in a ctx param (Context) which is part of the javalin library
		app.get("hello", (ctx) -> {
			ctx.result("Hello world");
		});

		Human h = new Human();
		h.setName("Kevin");
		
		app.get("human", (ctx) ->{
//			ctx.result(h.toString());
//			ctx.result(
//					"{ name:" +h.getName()+" }"
//					);
//			ctx.contentType("application/json; charset=utf-8");
			ctx.json(h);
		});
		
		app.post("human", (ctx) ->{
			// converting JSON body to a java class, mapping it as a human
			Human newH = ctx.bodyAsClass(Human.class);
			System.out.println(newH);
			// logic to add a new human based on information sent
		});
	}

}

package com.revature.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

	/*
	 * path /hello
	 * method GET
	 * 
	 * return: View/html page
	 */
	@RequestMapping(method = RequestMethod.GET, value="/hello")
	public String hello() {
		// path to a static file located in a static folder in the src/main/resources folder
		return "hello.html";
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/goodbye")
	@ResponseBody
	public String helloMessage() {
		return "goodbye";
	}
}

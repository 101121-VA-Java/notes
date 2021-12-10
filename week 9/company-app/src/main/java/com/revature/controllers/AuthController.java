package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dtos.Principal;
import com.revature.services.AuthService;

@RestController
@RequestMapping("/auth")
@CrossOrigin(exposedHeaders="Authorization")
public class AuthController {

	private AuthService as;
	
	@Autowired
	public AuthController(AuthService as) {
		this.as = as;
	}
	
	@PostMapping
	public ResponseEntity<Principal> login(@RequestParam(name="username")String username, @RequestParam(name="password")String password){
		Principal principal = as.login(username, password);
		
		String token = as.generateToken(principal);
		
		HttpHeaders hh = new HttpHeaders();
		
		hh.set("Authorization", token);
		
		return new ResponseEntity<>(principal, hh, HttpStatus.OK);
	}
}

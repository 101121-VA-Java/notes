package com.revature.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Role;
import com.revature.models.User;
import com.revature.services.UserService;

@RestController
//@Controller
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {

	private UserService us;
	
	// constructor injection, Spring will use this constructor to handle the dependency with UserService
	@Autowired
	public UserController(UserService us) {
		this.us = us;
	}
	
	/*
	 *	/users/{x}
	 *	/users/{y}
	 *	
	 *	actual value: /users/25
			- ???
	 * 
	 * getAllUsers
	 * 		- method: get
	 * 		- url: /users
	 * getUsersByRole
	 * 		- method: get
	 * 		- url: /users?role=[value]
	 * getUserById
	 * 		- method: get
	 * 		- url: /users/{id}
	 * addUser
	 * 		- method: post
	 * 		- url: /users
	 */
	
	@RequestMapping(method=RequestMethod.GET)
//	@ResponseBody
	public List<User> getAllUsers(@RequestParam(name="role", required = false)Role role){
		// if a query param of name "role" is passed in, returns users of this role
		if(role != null) {
			return us.getUserByRole(role);
		}
		return us.getAllUsers();
	}
	
//	@GetMapping("/{id}")
//	@ResponseBody
//	public User getUserById(@PathVariable("id")int id) {
//		return us.getUserById(id);
//	}
	
	@GetMapping("/{id}")
//	@ResponseBody
	public ResponseEntity<User> getUserById(@PathVariable("id")int id) {
		return new ResponseEntity<>(us.getUserById(id), HttpStatus.OK);
	}
	
	@PostMapping // @RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<String> createUser(@Valid @RequestBody User user){
		us.createUser(user);
		return new ResponseEntity<>(user.getName() + " was created.", HttpStatus.CREATED);
	}
}

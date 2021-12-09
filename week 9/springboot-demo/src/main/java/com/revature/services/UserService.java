package com.revature.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.daos.UserRepository;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.Role;
import com.revature.models.User;

@Service
public class UserService {
	
	private UserRepository ur;
	
	@Autowired
	public UserService(UserRepository ur) {
		this.ur = ur;
	}
	
	public List<User> getAllUsers(){
		return ur.findAll();
	}
	
	public User getUserById(int id) {
		return ur.findById(id).orElseThrow(UserNotFoundException::new);
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void createUser(User u) {
		// bunch of logic
		ur.save(u);
	}
	
	public List<User> getUserByRole(Role role){
		return ur.findUsersByRole(role);
	}
}

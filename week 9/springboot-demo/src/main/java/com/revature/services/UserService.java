package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.exceptions.UserNotFoundException;
import com.revature.models.Role;
import com.revature.models.User;

@Service
public class UserService {
	// bad practice, for example's sake. Use real dao layer
	private List<User> users = new ArrayList<>();
	
	public UserService() {
		// Creating 2 users in our arrayList
		User a = new User();
		a.setId(0);
		a.setName("Kevin");
		a.setRole(Role.ADMIN);
		
		User b = new User();
		b.setId(1);
		b.setName("AlsoKevin");
		b.setRole(Role.USER);
		
		users.add(a);
		users.add(b);
	}
	
	public List<User> getAllUsers(){
		return users;
	}
	
	public User getUserById(int id) {
		for(User u : users) {
			if(u.getId() == id) {
				return u;
			}
		}
		// throw a custom exception
		throw new UserNotFoundException();
	}
	
	public void createUser(User u) {
		users.add(u);
	}
	
	public List<User> getUserByRole(Role role){
		List<User> temp = new ArrayList<>();
		for(User u:users) {
			if(u.getRole().equals(role)) {
				temp.add(u);
			}
		}
		
		return temp;
	}
}

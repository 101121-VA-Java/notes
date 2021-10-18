package com.revature.models;

public class User {

	public String name;
	
	public static String className = "User class";
	public static int numberOfUser;
	
	public User() {
		numberOfUser++;
		name = "default name";
	 }

	public User(String name) {
		super();
		this.name = name;
		numberOfUser++;
	}

	public void sayMyName() {
		System.out.println(name);
	}
	
	public static void sayClassName() {
		System.out.println(className);
	}
	
	public static void sayNumOfUsers() {
		System.out.println(numberOfUser);
	}
}

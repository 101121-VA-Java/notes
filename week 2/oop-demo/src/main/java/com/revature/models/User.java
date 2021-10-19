package com.revature.models;

public class User {

	// instance variable
	private String username;
	private String password;
	private int age;

	// static variable
	public static int numberOfUsers;

	public User() {
		super();
	}

	public User(int age) {
		super();
		this.age = age;
	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	// method that return the age of that instance
	public int getAge() {
		return age;
	}

	// method that changes the age of that instance
	public void setAge(int age) {
		if (age < 0) {
			this.age = 0;
		} else {
			this.age = age;
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static int getNumberOfUsers() {
		return numberOfUsers;
	}

	public static void setNumberOfUsers(int numberOfUsers) {
		User.numberOfUsers = numberOfUsers;
	}

	public static int getNumOfUsers() {
		return numberOfUsers;
	}

	public void instanceMethod() {
		System.out.println("I'm an instance method!");
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", age=" + age + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (age != other.age)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

}

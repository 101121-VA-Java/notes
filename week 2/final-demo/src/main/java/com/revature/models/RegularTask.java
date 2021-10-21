package com.revature.models;

public final class RegularTask extends Task{

	public final int specificInt = 0;
	public final User assignedUser = new User("Kevin");
	
//	Cannot override a final method
//	public final void doSomething() {
//		System.out.println("Do something");
//	}
	
	@Override
	public String toString() {
		return "RegularTask [specificInt=" + specificInt + ", assignedUser=" + assignedUser + "]";
	}
}

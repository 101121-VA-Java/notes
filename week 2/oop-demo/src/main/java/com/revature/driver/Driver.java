package com.revature.driver;

import java.time.LocalDate;

import com.revature.models.ImportantTask;
import com.revature.models.Task;
import com.revature.models.User;

public class Driver {
	
	private int i;
	protected String s;
	String something; // default access modifier
	
	
	public static void main(String[] args) {
		
		System.out.println(User.getNumOfUsers());
		User u = new User();
//		u.username = "Kevin";
		User k = new User();
//		k.username = "Kevin";
		
//		k.age = 15;
//		
//		k.age = -25;
		
		u.setAge(-25);
		
		Object o = new Object(); // o is a reference to an object/instance of the Object class
		
		/*
		 *  SYSO - calls u.toString() implicitely
		 *  	- default implementation of toString(), per the Object Class, is the memory address
		 *  	- to return meaning information, we have to override the method to be relevant to the fields of that class
		 *  
		 */
		System.out.println("u age: " + u.getAge());
		System.out.println(k);
		
		System.out.println("Is k.equals(u)? " + k.equals(u));
		
		Task t1 = new Task("Laundry", LocalDate.parse("2021-10-20"));
		
		System.out.println(t1);
		
//		Task[] taskArr = {t1 , null, null};
		
		u.setTask(t1);
		
		System.out.println(u);
		
		ImportantTask it = new ImportantTask("Quiz", LocalDate.now());
		
		it.stress();
		
		System.out.println(it);
	}

}

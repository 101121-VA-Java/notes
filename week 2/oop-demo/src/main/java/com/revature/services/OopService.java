package com.revature.services;

import java.time.LocalDate;

import com.revature.models.BoringTask;
import com.revature.models.ImportantTask;
import com.revature.models.Task;
import com.revature.models.User;

public class OopService {

	// examples of access modifiers
	private int i;
	protected String s;
	String something; // default access modifier

	public void doEncapsulation() {
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
		 * SYSO - calls u.toString() implicitely - default implementation of toString(),
		 * per the Object Class, is the memory address - to return meaning information,
		 * we have to override the method to be relevant to the fields of that class
		 * 
		 */
		System.out.println("u age: " + u.getAge());
		System.out.println(k);

		System.out.println("Is k.equals(u)? " + k.equals(u));
		
	}

	public void doInheritance() {
		User u = new User();
		Task t1 = new Task("Laundry", LocalDate.parse("2021-10-20"));

		System.out.println(t1);

//		Task[] taskArr = {t1 , null, null};

		u.setTask(t1);

		System.out.println(u);

		ImportantTask it = new ImportantTask("Quiz", LocalDate.now());

		it.stress();

		System.out.println(it);
	}

	public void doPolymorphism() {
		// method overriding
		Task t1 = new Task();

		System.out.println("This should print toString() from Task class: " + t1);

		ImportantTask it = new ImportantTask();

		System.out.println("This should print toString() from Task class: " + it);

		BoringTask bt = new BoringTask();

		System.out.println("This should print toString() from BoringTask class: " + bt);

		// method overloading

		bt.setDueDate(LocalDate.now());

		System.out.println("Due date before all: " + bt.getDueDate());

		bt.procrastinate();

		System.out.println("Due date after procrastinate(): " + bt.getDueDate());

		bt.procrastinate(5);

		System.out.println("Due date after procrastinate(5): " + bt.getDueDate());

		bt.procrastinate(5, 2);

		System.out.println("Due date after procrastinate(5, 2): " + bt.getDueDate());

		// Upcasting
		Task t = new BoringTask();
		Task t2 = new ImportantTask();

		Task[] tasks = { t, t2 };

		for (Task task : tasks) {
			System.out.println(task.toString());
		}
		
//		BoringTask boring = (BoringTask) new Task();
		

	}
}

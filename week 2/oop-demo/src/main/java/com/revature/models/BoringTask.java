package com.revature.models;

import java.time.LocalDate;

import com.revature.interfaces.Doable;
import com.revature.interfaces.Issuable;

public class BoringTask extends Task implements Doable{
	
	public BoringTask() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BoringTask(String name, LocalDate dueDate) {
		super(name, dueDate);
		// TODO Auto-generated constructor stub
	}

	public void procrastinate() {
		this.setDueDate(this.getDueDate().plusDays(1));
	}
	
	public void procrastinate(int days) {
		this.setDueDate(this.getDueDate().plusDays(days));
	}
	
	public void procrastinate(int days, int times) {
		this.setDueDate(this.getDueDate().plusDays(days * times));
	}

	@Override
	public String toString() {
		return "Overriden toStringMethod!";
	}

	@Override
	public void doTask() {
		System.out.println("I'm doing " + this.getName() + " boringly");
		
	}

	@Override
	public void doSomething() {
		// TODO Auto-generated method stub
		
	}
	
//	@Override
//	public BoringTask getATask() {
//		return new BoringTask();
//	}
}

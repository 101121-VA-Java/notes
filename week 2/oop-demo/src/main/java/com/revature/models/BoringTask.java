package com.revature.models;

import java.time.LocalDate;

public class BoringTask extends Task{
	
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
	public BoringTask getATask() {
		return new BoringTask();
	}
}

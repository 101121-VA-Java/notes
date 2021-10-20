package com.revature.models;

import java.time.LocalDate;

public class Task {
	
	private String name;
	private LocalDate dueDate;
	
	public Task() {
		super();
/*
 * 		super.toString(); // in this case, super refers to the parent (Object class) 
 * 							therefore super.toString(); calls the Object class' implementation of the toString() 
 * 							method rather than the implementation of the current class 
 */
		// TODO Auto-generated constructor stub
	}

	public Task(String name, LocalDate dueDate) {
		super();
		this.name = name;
		this.dueDate = dueDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dueDate == null) ? 0 : dueDate.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Task other = (Task) obj;
		if (dueDate == null) {
			if (other.dueDate != null)
				return false;
		} else if (!dueDate.equals(other.dueDate))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	@Override
	public String toString() {
		return "Task [name=" + name + ", dueDate=" + dueDate + "]";
	}
	
	public Task getATask() {
		return new Task();
	}
	/*
	 * public class Object{
	 * 	public String toString(){
	 * 		return //memory address; 
	 * }
	 */
}

package com.revature.models;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tasks")
public class Task {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(nullable=false)
	private String name;
	private String description;
	// assigns the current localdatetime when a record is inserted
	@Column(name="assigned_date", updatable=false, columnDefinition="timestamp default CURRENT_TIMESTAMP")
	private LocalDateTime assignedDate;
	private LocalDateTime dueDate;
	@Enumerated(EnumType.STRING)
	@Column(nullable=false)
	private Status status;
	@ManyToOne
	@JoinColumn(nullable=false)
	private Employee assignedEmployee;
	
	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Task(int id, String name, String description, LocalDateTime assignedDate, LocalDateTime dueDate,
			Status status, Employee assignedEmployee) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.assignedDate = assignedDate;
		this.dueDate = dueDate;
		this.status = status;
		this.assignedEmployee = assignedEmployee;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getAssignedDate() {
		return assignedDate;
	}

	public void setAssignedDate(LocalDateTime assignedDate) {
		this.assignedDate = assignedDate;
	}

	public LocalDateTime getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDateTime dueDate) {
		this.dueDate = dueDate;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Employee getAssignedEmployee() {
		return assignedEmployee;
	}

	public void setAssignedEmployee(Employee assignedEmployee) {
		this.assignedEmployee = assignedEmployee;
	}

	@Override
	public int hashCode() {
		return Objects.hash(assignedDate, assignedEmployee, description, dueDate, id, name, status);
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
		return Objects.equals(assignedDate, other.assignedDate)
				&& Objects.equals(assignedEmployee, other.assignedEmployee)
				&& Objects.equals(description, other.description) && Objects.equals(dueDate, other.dueDate)
				&& id == other.id && Objects.equals(name, other.name) && status == other.status;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", name=" + name + ", description=" + description + ", assignedDate=" + assignedDate
				+ ", dueDate=" + dueDate + ", status=" + status + ", assignedEmployee=" + assignedEmployee + "]";
	}
	
}

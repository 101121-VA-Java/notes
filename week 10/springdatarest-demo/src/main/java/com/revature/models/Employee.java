package com.revature.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="employees")
@Data
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
	  name = "employee_task", 
	  joinColumns = @JoinColumn(name = "task_id", referencedColumnName = "id"), 
	  inverseJoinColumns = @JoinColumn(name = "employee_id", referencedColumnName = "id"))
	private List<Task> tasks;
}

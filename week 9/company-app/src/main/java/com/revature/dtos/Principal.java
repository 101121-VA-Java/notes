package com.revature.dtos;

import java.util.Objects;

import com.revature.models.Employee;
import com.revature.models.Role;

public class Principal {

	private int id;
	private String name;
	private Role role;
	
	public Principal() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Principal(Employee e) {
		id = e.getId();
		name = e.getName();
		role = e.getRole();
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
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Principal [id=" + id + ", name=" + name + ", role=" + role + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, role);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Principal other = (Principal) obj;
		return id == other.id && Objects.equals(name, other.name) && role == other.role;
	}
	
}

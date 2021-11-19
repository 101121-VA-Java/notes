package com.revature.daos;

import java.util.List;

import com.revature.models.Department;

public interface DepartmentDao {

	Department add(Department d);
	Department getById(int id);
	Department getByName(String name);
	List<Department> getDepartments();
	void update(Department d);
	void delete(Department d);
}

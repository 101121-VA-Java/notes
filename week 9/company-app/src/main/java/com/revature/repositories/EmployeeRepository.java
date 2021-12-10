package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	Employee findEmployeeByUsername(String username);
}

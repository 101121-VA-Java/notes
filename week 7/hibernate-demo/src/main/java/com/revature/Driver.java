package com.revature;

import java.util.List;

import com.revature.daos.DepartmentDao;
import com.revature.daos.DepartmentHibernate;
import com.revature.daos.EmployeeDao;
import com.revature.daos.EmployeeHibernate;
import com.revature.models.Department;
import com.revature.models.Employee;

public class Driver {

	private static EmployeeDao ed = new EmployeeHibernate();
	private static DepartmentDao dd = new DepartmentHibernate();

	public static void main(String[] args) {
		// Setting up departments
		Department testDept = new Department();
		testDept.setName("FunZone");
		dd.add(testDept);

		System.out.println("EmployeeHibernate methods:");
		System.out.println();

		System.out.println("addEmployee:");
		Employee newEmp = new Employee();
		newEmp.setName("TestName");
		newEmp.setDepartment(testDept);
		System.out.println(ed.add(newEmp));
		System.out.println();

		System.out.println("getEmployeeById:");
		System.out.println(ed.getById(1));
		System.out.println();

		System.out.println("getEmployeeByName:");
		System.out.println(ed.getByName("TestName"));
		System.out.println();

		System.out.println("getEmployees:");
		Employee temp = new Employee();
		temp.setName("TestName1");
		temp.setDepartment(testDept);
		ed.add(temp);
		List<Employee> employees = ed.getEmployees();
		if (employees != null) {
			employees.forEach(e -> System.out.println(e));
		} else {
			System.out.println(employees);
		}
		System.out.println();

		System.out.println("getEmployeesByDepartmentId:");
		List<Employee> employeesByDeptId = ed.getEmployeesByDepartmentId(1);
		if (employeesByDeptId != null) {
			employeesByDeptId.forEach(e -> System.out.println(e));
		} else {
			System.out.println(employeesByDeptId);
		}
		System.out.println();
		
		System.out.println("UpdateEmployee:");
		newEmp.setName("UpdatedName");
		ed.update(newEmp);
		Employee dbEmp = ed.getById(1);
		if (dbEmp != null && dbEmp.getName().equals("UpdatedName")) {
			System.out.println("Employee has been updated");
		} else {
			System.out.println("Employee has not been updated");
		}
		System.out.println();
		
		System.out.println("deleteEmployee:");
		ed.delete(dbEmp);
		Employee dbEmp1 = ed.getById(1);
		if (dbEmp1 == null) {
			System.out.println("Employee of id 1 is not found");
		} else {
			System.out.println("Employee of id 1 is exists");
		}
		System.out.println();
	}

}

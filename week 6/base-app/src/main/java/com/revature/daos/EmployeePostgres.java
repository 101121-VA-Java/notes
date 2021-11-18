package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Employee;
import com.revature.models.Role;
import com.revature.util.ConnectionUtil;

class EmployeePostgres implements EmployeeDao {

	/**
	 * Dao method to retrieve all employees
	 * @return a List of Employees or an empty list if none are found
	 */
	@Override
	public List<Employee> getEmployees() {

		List<Employee> employees = new ArrayList<>();

		try (Connection c = ConnectionUtil.getConnection()) {
			String sql = "select * from employees;";

			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {
				// Retrieving employee info, setting manager's value to another Employee dummy object with only its id
				Employee e = new Employee(
						rs.getInt("e_id"), 
						rs.getString("e_name"), 
						rs.getString("e_username"),
						rs.getString("e_password"), 
						Role.valueOf(rs.getString("e_role")),
						new Employee(rs.getInt("m_id")));

				// Adding employee to employees list to be returned
				employees.add(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return employees;
	}

	/**
	 * Dao method to retrieve employees by a manager id
	 * @param id of the manager employee
	 * @return a List of Employees or an empty list if none are found
	 */
	@Override
	public List<Employee> getEmployeesByManagerId(int id) {
		
		List<Employee> employees = new ArrayList<>();

		try (Connection c = ConnectionUtil.getConnection()) {
			String sql = "select * from employees where m_id = ?;";

			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				// Retrieving employee info, setting manager's value to another Employee dummy object with only its id
				Employee e = new Employee(
						rs.getInt("e_id"), 
						rs.getString("e_name"), 
						rs.getString("e_username"),
						rs.getString("e_password"), 
						Role.valueOf(rs.getString("e_role")),
						new Employee(rs.getInt("m_id")));

				// Adding employee to employees list to be returned
				employees.add(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return employees;
	}
	
	/**
	 * Dao method to retrieve an employee by id
	 * @param id of the employee
	 * @return an employee or null if none is found
	 */
	@Override
	public Employee getEmployeeById(int id) {

		Employee employee = null;

		try (Connection c = ConnectionUtil.getConnection()) {
			String sql = "select * from employees where e_id = ?;";

			PreparedStatement ps = c.prepareStatement(sql);

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				employee = new Employee(
						rs.getInt("e_id"),
						rs.getString("e_name"), 
						rs.getString("e_username"),
						rs.getString("e_password"), 
						Role.valueOf(rs.getString("e_role")),
						new Employee(rs.getInt("m_id")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return employee;
	}

	/**
	 * Service method to retrieve an employee by its username
	 * @param username of the employee
	 * @return an employee or null if none is found
	 */
	@Override
	public Employee getEmployeeByUsername(String username) {
		Employee employee = null;

		try (Connection c = ConnectionUtil.getConnection()) {
			String sql = "select * from employees where e_username = ?;";

			PreparedStatement ps = c.prepareStatement(sql);

			ps.setString(1, username);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				employee = new Employee(
						rs.getInt("e_id"),
						rs.getString("e_name"), 
						rs.getString("e_username"),
						rs.getString("e_password"), 
						Role.valueOf(rs.getString("e_role")),
						new Employee(rs.getInt("m_id")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return employee;
	}

	/**
	 * Dao method to create an employee, assigns an employee id generated by the database before returning
	 * @param employee object with all fields except for id
	 * @return an employee with an id or null if none is created
	 */
	@Override
	public Employee addEmployee(Employee e) {
		Employee newEmployee = null;
			
		
		try (Connection con = ConnectionUtil.getConnection()){
			String sql = "insert into employees (e_name, e_username, e_password, e_role, m_id) values (?,?,?,?,?) returning e_id;";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, e.getName());
			ps.setString(2, e.getUsername());
			ps.setString(3, e.getPassword());
			ps.setString(4, e.getRole().toString());
			ps.setInt(5, e.getManager().getId());

			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				newEmployee = e;
				newEmployee.setId(rs.getInt("e_id"));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		return newEmployee;
	}

	/**
	 * Dao method to update an employee
	 * @param employee object
	 * @return true if an employee was updated successfully, else false
	 */
	@Override
	public boolean updateEmployee(Employee e) {
		String sql = "update employees set e_name = ?, e_username = ?, e_password = ?, e_role = ?, m_id = ? "
				+ "where e_id = ?;";

		int rowsChanged = -1;

		try (Connection con = ConnectionUtil.getConnection()) {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, e.getName());
			ps.setString(2, e.getUsername());
			ps.setString(3, e.getPassword());
			ps.setString(4, e.getRole().toString());
			ps.setInt(5, e.getManager().getId());
			ps.setInt(6, e.getId());

			rowsChanged = ps.executeUpdate();

		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		if (rowsChanged > 0) {
			return true;
		}
		
		return false;
	}


}
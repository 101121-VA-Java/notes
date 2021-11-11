package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Employee;
import com.revature.util.ConnectionUtil;

public class EmployeePostgres implements EmployeeDao {

	@Override
	public Employee getEmployeeById(int id) {
		String sql = "select * from employees where e_id = ? ";
		Employee emp = null;

		try (Connection con = ConnectionUtil.getConnectionFromEnv()) {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, id); // 1 refers to the first '?'

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				int e_id = rs.getInt("e_id");
				String name = rs.getString("e_name");
				String e_username = rs.getString("e_username");
				String e_password = rs.getString("e_password");
				String role = rs.getString("e_role");
				int man_id = rs.getInt("man_e_id");

				emp = new Employee(e_id, name, e_username, e_password, role, new Employee(man_id));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;
	}

//	// User input => "0; drop table employees;"
//	public Employee getEmployeeByUsername(String username) {
//		String sql = "select * from employees where e_username = " + username + ";";
//		return null;
//	}

	@Override
	public List<Employee> getEmployees() {
		String sql = "select * from employees;";
		List<Employee> employees = new ArrayList<>();

		try (Connection con = ConnectionUtil.getConnectionFromEnv()) {
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("e_id");
				String name = rs.getString("e_name");
				String e_username = rs.getString("e_username");
				String e_password = rs.getString("e_password");
				String role = rs.getString("e_role");
				int man_id = rs.getInt("man_e_id");

				Employee newEmp = new Employee(id, name, e_username, e_password, role, new Employee(man_id));
				employees.add(newEmp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}

	@Override
	public int addEmployee(Employee employee) {
		int genId = -1;
		String sql = "insert into employees (e_name, e_username, e_password, e_role, man_e_id) "
				+ "values (?, ?, ?, ?, ?) returning e_id;";

		try (Connection con = ConnectionUtil.getConnectionFromEnv()) {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, employee.getName());
			ps.setString(2, employee.getUsername());
			ps.setString(3, employee.getPassword());
			ps.setString(4, employee.getRole());
			ps.setInt(5, employee.getManager().getId());

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				genId = rs.getInt("e_id");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return genId;
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		String sql = "update employees set e_name = ?, e_username = ?, e_password = ?, e_role = ?, man_e_id = ? "
				+ "where e_id = ?;";

		int rowsChanged = -1;

		try (Connection con = ConnectionUtil.getConnectionFromEnv()) {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, employee.getName());
			ps.setString(2, employee.getUsername());
			ps.setString(3, employee.getPassword());
			ps.setString(4, employee.getRole());
			ps.setInt(5, employee.getManager().getId());
			ps.setInt(6, employee.getId());

			rowsChanged = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (rowsChanged > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int deleteEmployee(int id) {
		String sql = "delete from employees where e_id = ?;";
		int rowsChanged = -1;

		try (Connection con = ConnectionUtil.getConnectionFromEnv();) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);

			// if 1 is returned, indicates that 1 record was successfully deleted from the
			// table
			rowsChanged = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowsChanged;
	}

}

package com.revature.daos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.h2.tools.RunScript;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.revature.models.Employee;
import com.revature.util.ConnectionUtil;

@ExtendWith(MockitoExtension.class)
public class EmployeeDaoTest {
	
	private EmployeeDao ed = new EmployeePostgres();
	private static MockedStatic<ConnectionUtil> mockedConnectionUtil;
	private static Connection con;
	
	@BeforeAll
	public static void init() {
		/*
		 * Mocking the ConnectionUtil class and telling the mocked Connection Util class to return a connection to the H2 instead of the actual database
		 * while the mock is "open"
		 */
		mockedConnectionUtil = Mockito.mockStatic(ConnectionUtil.class);
		mockedConnectionUtil.when(ConnectionUtil::getConnectionFromEnv)
			.then(I -> getH2Connection());
	}
	
	@AfterAll
	public static void end() {
		/*
		 * closing resource, mocked behavior ends
		 */
		mockedConnectionUtil.close();
	}
	
	@BeforeEach
	public void setUp() {
		try(Connection c = ConnectionUtil.getConnectionFromEnv()){
			RunScript.execute(c, new FileReader("setup.sql"));
		} catch (SQLException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterEach
	public void teardown() {
		try(Connection c = ConnectionUtil.getConnectionFromEnv()){
			RunScript.execute(c, new FileReader("teardown.sql"));
		} catch (SQLException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void getByIdDoesNotExists() {
		assertNull(ed.getEmployeeById(25));
	}
	
	@Test
	public void getByIdExists() {
		Employee expected = new Employee(1, "test name", "test username", "test password", "test role", new Employee());
		assertEquals(expected, ed.getEmployeeById(1));
	}
	
	public static Connection getH2Connection() {
		try {
			if (con == null || con.isClosed()) {
				con = DriverManager.getConnection("jdbc:h2:~/test");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
}

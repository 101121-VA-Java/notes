package com.revature.daos;

// return instances of Dao interfaces
public class DaoFactory {
	
	private static DaoFactory df;
	private static EmployeeDao ed;
	// taskdao..
	
	// because of the private access modifier, other classes cannot create instances of DaoFactory
	private DaoFactory() {}
	
	// other classes have to use static method to retrieve a daoFactory instance
	public static synchronized DaoFactory getDaoFactory() {
		if(df == null) {
			df = new DaoFactory();
		}
		return df;
	}
	
	public EmployeeDao getEmployeeDao() {
		// Always return the same instance of EmployeeDao implementation when getEmployeeDao is called
		if(ed == null) {
			// if trying to change implementation to Oracle or mySQL can only change it in one place in my code
			ed = new EmployeePostgres();
		}
		return ed;
	}
	
	// do the same thing with TaskDao, always return the same instance
}

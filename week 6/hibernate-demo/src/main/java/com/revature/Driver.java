package com.revature;

import com.revature.daos.DepartmentDao;
import com.revature.daos.DepartmentHibernate;
import com.revature.models.Department;

public class Driver {

	private static DepartmentDao dd = new DepartmentHibernate();
	
	public static void main(String[] args) {
		
	Department newDep = new Department();
	newDep.setName("FunZone");
	// Department [id=0, name=FunZone]
	System.out.println(newDep);

	dd.add(newDep);
	
	//Department [id=1, name=FunZone]
	System.out.println(newDep);
	
	Department fromDb = dd.getById(1);
	
	System.out.println(fromDb);
	
	dd.delete(fromDb);
	}

}

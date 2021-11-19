package com.revature.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Department;
import com.revature.util.HibernateUtil;

public class DepartmentHibernate implements DepartmentDao {

	public Department add(Department d) {
		// In hibernate, the session represents the connection to the database
		Session s = HibernateUtil.getSessionFactory().openSession();
		// starts the transaction
		Transaction tx = s.beginTransaction();
		/*
		 * saves object to database The id of the object saved has been updated to the
		 * generated value from database
		 */
		// id is generated id
		int id = (int) s.save(d);
		// commits the transaction
		tx.commit();
		// close the session
		s.close();

		return d;
	}

	public Department getById(int id) {
		Department d = null;
		try (Session s = HibernateUtil.getSessionFactory().openSession()) {
			d = s.get(Department.class, id);
		}
		return d;
	}

	public Department getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Department> getDepartments() {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(Department d) {
		try (Session s = HibernateUtil.getSessionFactory().openSession()) {
			Transaction tx = s.beginTransaction();
			s.update(d);
			tx.commit();
		}

	}

	public void delete(Department d) {
		try (Session s = HibernateUtil.getSessionFactory().openSession()) {
			Transaction tx = s.beginTransaction();
			s.delete(d);
			tx.commit();
		}

	}

}

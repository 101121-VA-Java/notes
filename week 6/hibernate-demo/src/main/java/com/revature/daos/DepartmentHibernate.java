package com.revature.daos;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
//import org.hibernate.criterion.CriteriaQuery;

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
		// takes transient department and makes persisted
		int id = (int) s.save(d);
		// commits the transaction
		tx.commit();
		// close the session
		// d is now detached because the session has been closed
		s.close();

		return d;
	}

	public Department getById(int id) {
		Department d = null;
		/*
		// using Hibernate defined methods to retrieve a record
		try (Session s = HibernateUtil.getSessionFactory().openSession()) {
			d = s.get(Department.class, id);
		}
		*/
		
		/*
		// Native query
		try (Session s = HibernateUtil.getSessionFactory().openSession()) {
			String sql = "select * from hbn.departments where d_id = :department_id ;";
			NativeQuery<Department> nq = s.createNativeQuery(sql, Department.class);
			nq.setParameter("department_id", id);
			d = nq.getSingleResult();
		}
		*/
		
		//HQL
		try (Session s = HibernateUtil.getSessionFactory().openSession()) {
			// instead of working with table name/column name, work with class and fields
			String hql = "from Department where id = :department_id";
			TypedQuery<Department> tq = s.createQuery(hql, Department.class);
			tq.setParameter("department_id", id);
			d = tq.getSingleResult();
		}
		return d;
	}

	public Department getByName(String name) {
		Department d = null;
		try (Session s = HibernateUtil.getSessionFactory().openSession()) {
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<Department> cq = cb.createQuery(Department.class);
			// define entity to be searched
			Root<Department> root = cq.from(Department.class);
			
			// defining "where name = ... && condition"
			Predicate predicateForName = cb.equal(root.get("name"), name);
//			Predicate predicateForSomethingElse = cb.equal(root.get("id"), passedInId);
//			Predicate predicateForNameAndSomethingElse = cb.and(predicateForName, predicateForSomethingElse);
			
			// cq.select(root).where(predicateForNameAndSomethingElse);
			cq.select(root).where(predicateForName);
			
			// retrieving the result
			d = (Department) s.createQuery(cq).getSingleResult();
		}
		return d;
	}

	public List<Department> getDepartments() {
		List<Department> departments = null;
		/*
		// using query
		try (Session s = HibernateUtil.getSessionFactory().openSession()) {
			departments = s.createQuery("from Department", Department.class).list();
		}
		*/
		
		try (Session s = HibernateUtil.getSessionFactory().openSession()) {
			departments = s.createNamedQuery("getAllNq", Department.class).getResultList();
		}
		return departments;
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

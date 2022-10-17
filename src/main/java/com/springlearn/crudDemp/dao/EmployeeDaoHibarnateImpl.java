package com.springlearn.crudDemp.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.springlearn.crudDemp.entity.Employee;

@Repository
public class EmployeeDaoHibarnateImpl implements EmployeeDao {

	// define field for entityManager

	private EntityManager entityManager;

	// set up constructor injection

	public EmployeeDaoHibarnateImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public List<Employee> findAll() {

		// get the current Hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// create the query
		Query<Employee> theQuery = currentSession.createQuery(" from Employee", Employee.class);

		// execute the query & get result
		List<Employee> employees = theQuery.getResultList();
		// return the result
		return employees;
	}

	public Employee findById(int id) {

		Session currentSession = entityManager.unwrap(Session.class);
		
		Employee employee = 
				currentSession.get(Employee.class, id);
		
		return employee;
	}

	public void save(Employee thEmployee) {

		Session currentSession = entityManager.unwrap(Session.class);

		// create the query
		currentSession.saveOrUpdate(thEmployee);
		
	}

	public void deleteById(int id) {

		Session currentSession = entityManager.unwrap(Session.class);

		// create the query
		Query<Employee> theQuery = currentSession.createQuery("delete from Employee where id=:id");
		
		theQuery.setParameter("id", id);
		
		theQuery.executeUpdate();
		
	}

}

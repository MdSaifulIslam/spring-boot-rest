package com.springlearn.crudDemp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springlearn.crudDemp.entity.Employee;

@Repository
public class EmployeeDaoJpaImple implements EmployeeDao {

	private EntityManager entityManager;

	@Autowired
	public EmployeeDaoJpaImple(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public List<Employee> findAll() {

		Query theQuery = entityManager.createQuery("from Employee");
		List<Employee> employees = theQuery.getResultList();

		return employees;

	}

	public Employee findById(int id) {
		return entityManager.find(Employee.class, id);
	}

	public void save(Employee thEmployee) {
		
		Employee dbEmployee = entityManager.merge(thEmployee);

		thEmployee.setId(dbEmployee.getId());
	}

	public void deleteById(int id) {

		Query theQuery = 
				entityManager.createQuery("delete from Employee where id=:id");

		theQuery.setParameter("id", id);

		theQuery.executeUpdate();
	}

}

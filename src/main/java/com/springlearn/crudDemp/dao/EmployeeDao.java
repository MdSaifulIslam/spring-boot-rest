package com.springlearn.crudDemp.dao;

import java.util.List;

import com.springlearn.crudDemp.entity.Employee;

public interface EmployeeDao {

	public List<Employee> findAll();
	
	public Employee findById(int id);
	
	public void save(Employee thEmployee);
	
	public void deleteById(int id);
}

package com.springlearn.crudDemp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springlearn.crudDemp.entity.Employee;

@Service
public interface EmployeeService {
	
	public List<Employee> findAll();
	
	public Employee findById(int id);
	
	public void save(Employee thEmployee);
	
	public void deleteById(int id);
}

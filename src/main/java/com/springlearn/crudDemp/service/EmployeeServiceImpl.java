package com.springlearn.crudDemp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springlearn.crudDemp.dao.EmployeeDao;
import com.springlearn.crudDemp.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	EmployeeDao dao;

	@Autowired
	public EmployeeServiceImpl(@Qualifier("employeeDaoJpaImple") EmployeeDao dao) {
		this.dao = dao;
	}

	@Transactional
	public List<Employee> findAll() {
		return dao.findAll();
	}

	@Transactional
	public Employee findById(int id) {
		return dao.findById(id);
	}

	@Transactional
	public void save(Employee thEmployee) {
		dao.save(thEmployee);
		
	}

	@Transactional
	public void deleteById(int id) {
		dao.deleteById(id);
	}

}

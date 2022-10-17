//package com.springlearn.crudDemp.service;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.springlearn.crudDemp.dao.EmployeeRepository;
//import com.springlearn.crudDemp.entity.Employee;
//
//@Service
//public class EmployeeServiceImpl implements EmployeeService{
//	
////	private EmployeeDao dao;
////
////	@Autowired
////	public EmployeeServiceImpl(@Qualifier("employeeDaoJpaImple") EmployeeDao dao) {
////		this.dao = dao;
////	}
//	
//	private EmployeeRepository employeeRepositoryDao;
//	
//	@Autowired
//	public EmployeeServiceImpl(EmployeeRepository employeeRepositoryDao) {
//		this.employeeRepositoryDao = employeeRepositoryDao;
//	}
//
//	public List<Employee> findAll() {
//		return employeeRepositoryDao.findAll();
//	}
//
//	public Employee findById(int id) {
//		Optional<Employee> result = employeeRepositoryDao.findById(id);
//		
//		Employee thEmployee = null;
//		
//		if(result.isPresent()) {
//			thEmployee = result.get();
//		}
//		
//		return thEmployee;
//	}
//
//	public void save(Employee thEmployee) {
//		employeeRepositoryDao.save(thEmployee);
//		
//	}
//
//	public void deleteById(int id) {
//		employeeRepositoryDao.deleteById(id);
//	}
//
//}

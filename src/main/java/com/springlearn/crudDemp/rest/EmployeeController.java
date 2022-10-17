package com.springlearn.crudDemp.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springlearn.crudDemp.entity.Employee;
import com.springlearn.crudDemp.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("/employees")
	public List<Employee> findAll(){
		return employeeService.findAll();
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee getTheEmployee(@PathVariable int employeeId){
		Employee employee = employeeService.findById(employeeId);
		
		if(employee ==null) {
			throw new RuntimeException("Id[" + employeeId+ "] not found");
		}
		
		return employee;
	}
	
	@PostMapping("employees")
	public Employee saveEmployee(@RequestBody Employee thEmployee) {
		
		thEmployee.setId(0);
		
		employeeService.save(thEmployee);
		
		return thEmployee;
	}
	
	@PutMapping("employees")
	public Employee updateEmployee(@RequestBody Employee thEmployee) {
		
		employeeService.save(thEmployee);
		
		return thEmployee;
	}
	
	@DeleteMapping("employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId ) {
		
		Employee employee = employeeService.findById(employeeId);
		
		if(employee == null) {
			throw new RuntimeException("not founsd");
		}
		
		employeeService.deleteById(employeeId);
		
		return "Deletetd";
	}
}

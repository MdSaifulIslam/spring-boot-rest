package com.springlearn.crudDemp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springlearn.crudDemp.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}

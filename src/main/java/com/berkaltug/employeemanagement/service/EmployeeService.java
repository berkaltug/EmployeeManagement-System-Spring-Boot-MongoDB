package com.berkaltug.employeemanagement.service;

import java.util.List;
import java.util.Optional;

import com.berkaltug.employeemanagement.domain.Employee;

public interface EmployeeService {
	
	List<Employee> findAll();
	Employee findOne(Integer id);
	void deleteOne(Integer id);
	Employee updateEmployee(Employee emp);
	Employee insertEmployee(Employee emp);
}

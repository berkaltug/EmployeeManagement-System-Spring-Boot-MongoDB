package com.berkaltug.employeemanagement;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import  org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import com.berkaltug.employeemanagement.domain.Employee;
import com.berkaltug.employeemanagement.repository.EmployeeRepository;
import com.berkaltug.employeemanagement.service.EmployeeService;

@SpringBootTest
class EmployeeManagementApplicationTests {
	
	@Autowired
	EmployeeService employeeService;
	
	
	@Test
	public void shouldInsertEmployee() {
		Employee emp = new Employee (3,"berk","altuğ","506-3556964","berkaltug96@gmail.com");
		Employee e=employeeService.insertEmployee(emp);
		assertNotNull(e);
	}
	
	@Test
	public void canFind() {
		Employee emp=employeeService.findOne(3);
		assertNotNull(emp);
		System.out.println(emp);
	}
	
	@Test
	public void canDelete() {
		employeeService.deleteOne(1);
		Employee emp=employeeService.findOne(1);
		Assert.isNull(emp);
	}
}

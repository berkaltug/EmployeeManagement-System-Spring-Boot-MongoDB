package com.berkaltug.employeemanagement;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import  org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import com.berkaltug.employeemanagement.domain.Employee;
import com.berkaltug.employeemanagement.repository.EmployeeRepository;
import com.berkaltug.employeemanagement.service.EmployeeService;
@RunWith(SpringRunner.class)
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
		Employee emp=employeeService.findOne(30);
		assertNotNull(emp);
		System.out.println(emp);
	}
	@Test
	public void canFindAll() {
		List<Employee> emplist=employeeService.findAll();
		assertNotNull(emplist);
	}
	@Test
	public void canDelete() {
		employeeService.deleteOne(3);
		Employee emp=employeeService.findOne(3);
		Assert.isNull(emp);
	}
	

	
	



	

}

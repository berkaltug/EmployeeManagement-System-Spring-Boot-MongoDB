package com.berkaltug.employeemanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.berkaltug.employeemanagement.domain.Employee;
import com.berkaltug.employeemanagement.repository.EmployeeRepository;
import com.berkaltug.employeemanagement.service.EmployeeService;

@SpringBootApplication
public class EmployeeManagementApplication {
	
	@Autowired
	EmployeeService es;
	@Autowired
	EmployeeRepository er;
	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementApplication.class, args);
	}

	

}

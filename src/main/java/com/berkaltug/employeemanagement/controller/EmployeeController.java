package com.berkaltug.employeemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.berkaltug.employeemanagement.domain.Employee;
import com.berkaltug.employeemanagement.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService es;
	
	@CrossOrigin
	@GetMapping("/all")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public List<Employee> getAll(){
		return es.findAll();
	}
	
	@CrossOrigin
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Employee findEmployee(@PathVariable("id") Integer id) {
		return es.findOne(id);
	}
	
	@CrossOrigin
	@PostMapping("/add")
	public void addEmployee(@RequestBody Employee employee) {
		es.insertEmployee(employee);
	}
	
	@CrossOrigin
	@DeleteMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void deleteEmployee(@PathVariable("id")Integer id) {
		es.deleteOne(id);
	}
	
	
}

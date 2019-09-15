package com.berkaltug.employeemanagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	EmployeeService employeeService;
	
	@CrossOrigin
	@GetMapping("/all")
	public List<Employee> getAll(){
		return employeeService.findAll();
	}
	
	@CrossOrigin
	@GetMapping("/{id}")
	public Employee findEmployee(@PathVariable("id") Integer id) {
		return employeeService.findOne(id);
	}
	
	@CrossOrigin
	@PostMapping("/add")
	public void addEmployee(@Valid @RequestBody Employee employee) {
		employeeService.insertEmployee(employee);
	}
	
	@CrossOrigin
	@DeleteMapping("/delete/{id}")
	public void deleteEmployee(@PathVariable("id")Integer id) {
		employeeService.deleteOne(id);
	}
	
	@CrossOrigin
	@PutMapping("/update")
	public void updateEmployee(@Valid @RequestBody Employee emp) {
		employeeService.updateEmployee(emp);
	}
	
	
}

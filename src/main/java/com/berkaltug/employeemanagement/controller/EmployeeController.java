package com.berkaltug.employeemanagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import com.berkaltug.employeemanagement.EmployeeDTO;
import com.berkaltug.employeemanagement.domain.Employee;
import com.berkaltug.employeemanagement.service.CaptchaValidator;
import com.berkaltug.employeemanagement.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	@Autowired
	CaptchaValidator captchaService;
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
	public void addEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
		Employee employee=employeeDTO.getEmployee();
		Boolean isValidCaptcha=captchaService.validateCaptcha(employeeDTO.getCaptchaResponse());
		
		if(isValidCaptcha) {
			try {
				employeeService.insertEmployee(employee);
			}catch(Exception e) {
				System.err.println(e);
			}
		}	
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

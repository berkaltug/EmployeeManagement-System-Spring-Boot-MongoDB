package com.berkaltug.employeemanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.berkaltug.employeemanagement.domain.Employee;
import com.berkaltug.employeemanagement.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepo;
	
	@Autowired
	SequenceGeneratorService sequenceGeneratorService;
	
	@Autowired 
	MongoOperations mongoOperation;
	
	@Override
	public List<Employee> findAll() {
		return employeeRepo.findAll();
	}

	@Override
	public Employee findOne(Integer id) {
		Employee emp = null;
		
		try {
			emp=employeeRepo.findById(id).get();
		}catch(Exception e) {
				System.err.println(e);
		}
		
		return emp;
	}

	@Override
	public Employee findOne(String name, String surname) {
		
		return employeeRepo.findByNameAndSurname(name, surname);
	}

	@Override
	public void deleteOne(Integer id) {
		try {
			Employee emp=employeeRepo.findById(id).get();
			employeeRepo.delete(emp);
		}catch(Exception e) {
			System.err.println(e);
		}
		
	}

	@Override
	public Employee updateEmployee(Employee emp) {
		Employee em=null;
		try {

			em=employeeRepo.save(emp);
			
		}catch(Exception e) {
			System.err.println(e);
		}
		return em;
	}

	@Override
	public Employee insertEmployee(Employee emp) {
		Employee em=null;
		emp.setEmployeeId(sequenceGeneratorService.generateSequence(Employee.SEQUENCE_NAME));
		try {
			em=employeeRepo.save(emp);
		}catch(Exception e){
			System.err.println(e);
		}
		
		return em;
	}

}

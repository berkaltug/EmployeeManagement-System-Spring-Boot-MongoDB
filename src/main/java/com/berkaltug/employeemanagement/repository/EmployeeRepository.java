package com.berkaltug.employeemanagement.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.berkaltug.employeemanagement.domain.Employee;
@Repository
public interface EmployeeRepository extends MongoRepository<Employee,Integer>{
	//Auto generated query kullandık
	Employee findByNameAndSurname(String name,String surname);
}

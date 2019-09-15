package com.berkaltug.employeemanagement;

import javax.validation.Valid;

import com.berkaltug.employeemanagement.domain.CaptchaResponse;
import com.berkaltug.employeemanagement.domain.Employee;

public class EmployeeDTO {
	@Valid
	private Employee employee;
	private String captchaResponse;
	
	public EmployeeDTO(Employee employee, String captchaResponse) {
		this.employee = employee;
		this.captchaResponse = captchaResponse;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getCaptchaResponse() {
		return captchaResponse;
	}

	public void setCaptchaResponse(String captchaResponse) {
		this.captchaResponse = captchaResponse;
	}
	
	
	
}

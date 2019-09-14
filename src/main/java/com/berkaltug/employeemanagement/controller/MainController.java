package com.berkaltug.employeemanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping(value="/")
public class MainController {
	
	@RequestMapping( "/index")
	public String mainScreen() {
		return "index";
				
	}
}

package com.marketing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegistrationController {
	//http://localhost:8080/views
	
	//Handler Methods
	@RequestMapping("/views")
	public String viewRegistrationPage() {
		return "create_lead";
	}
}

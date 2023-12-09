package com.marketing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.marketing.Registration;
import com.marketing.service.RegistrationService;

@Controller
public class RegistrationController {
	
	@Autowired
	private RegistrationService registrationService; 
	
	//http://localhost:8080/views
	
	//Handler Methods
	@RequestMapping("/views")
	public String viewRegistrationPage() {
		return "create_lead";
	}
	
	@RequestMapping("/newReg")
	public String saveRegistration(Registration registration ) {
//		System.out.println(registration.getId());
//		System.out.println(registration.getName());
//		System.out.println(registration.getEmail());
//		System.out.println(registration.getPhone());
//		System.out.println(registration.getCity());
		
		
		registrationService.saveRegistration(registration);
		return "create_lead";
	}
}

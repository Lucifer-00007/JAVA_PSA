package com.marketing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.marketing.dto.RegistrationDto;
import com.marketing.entity.Registration;
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
	
	//@RequestMapping("/newReg")
	//public String saveRegistration(Registration registration ) {
		//System.out.println(registration.getId());
		//System.out.println(registration.getName());
		//System.out.println(registration.getEmail());
		//System.out.println(registration.getPhone());
		//System.out.println(registration.getCity());
		
		//registrationService.saveRegistration(registration);
		//return "create_lead";
	//}
	
	
	@RequestMapping("/newReg")
	public String saveRegistration(RegistrationDto dto, Model model) {
		Registration reg = new Registration();
		reg.setName(dto.getName());
		reg.setEmail(dto.getEmail());
		reg.setPhone(dto.getPhone());
		reg.setCity(dto.getCity());
		
		model.addAttribute("msg", "<div class='alert alert-success alert-dismissible fade show text-center' role='alert'> Record is saved!! <button type='button' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span> </button> </div>");
			
		registrationService.saveRegistration(reg);
		return "create_lead";
	}
	
	@RequestMapping("/getAllReg")
	public String getAllRegistration(){
		List<Registration> allRegistration = registrationService.getAllRegistration();
		System.out.println(allRegistration);
		return "";
	}

}
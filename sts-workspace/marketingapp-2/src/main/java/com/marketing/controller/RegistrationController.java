package com.marketing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketing.dto.RegistrationDto;
import com.marketing.entity.Registration;
import com.marketing.service.RegistrationService;
import com.marketing.util.EmailService;

@Controller
public class RegistrationController {
	
	@Autowired
	private RegistrationService registrationService; 
	
	@Autowired
	private EmailService emailService; 
	
	// http://localhost:8080/views
	
	//Handler Methods
	@RequestMapping("/views")
	public String viewRegistrationPage() {
		System.out.println("testing");
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
			
		emailService.sendEmail(dto.getEmail(), "Welcome", "Test");
		registrationService.saveRegistration(reg);
		return "create_lead";
	}
	
	@RequestMapping("/getAllReg")
	public String getAllRegistration(Model model){
		List<Registration> allRegistration = registrationService.getAllRegistration();
		System.out.println(allRegistration);
		
		model.addAttribute("allRegistration", allRegistration);
		return "list_registrations";
	}
	
	
	@RequestMapping("/delete")
	public String deleteLead(@RequestParam long id, Model model) {
		registrationService.deleteLead(id);
		
		List<Registration> allRegistration = registrationService.getAllRegistration();		
		model.addAttribute("allRegistration", allRegistration);
		return "list_registrations";	
	}
	
	@RequestMapping("/update")
	public String viewUpdatePage(@RequestParam long id, ModelMap model) {
		
		Registration registration = registrationService.getRegistrationById(id);		
		model.addAttribute("registration", registration);
		return "update_lead";
	}

	@RequestMapping("/updateReg")
	public String updateRegistration(RegistrationDto dto, Model model) {
		Registration reg = new Registration();
		reg.setId(dto.getId());
		reg.setName(dto.getName());
		reg.setEmail(dto.getEmail());
		reg.setPhone(dto.getPhone());
		reg.setCity(dto.getCity());
		
		registrationService.saveUpdatedRegistration(reg);
		
		List<Registration> allRegistration = registrationService.getAllRegistration();		
		model.addAttribute("allRegistration", allRegistration);
		return "list_registrations";
	}

}

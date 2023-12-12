package com.marketing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketing.entity.Registration;
import com.marketing.repository.RegistrationRepository;

@Service
public class RegistrationService {
	@Autowired
	private RegistrationRepository registrationRepo;
	
	public void saveRegistration(Registration registration) {
		registrationRepo.save(registration);
	}

	public List<Registration> getAllRegistration() {
		List<Registration> registrations = registrationRepo.findAll();
		return registrations;	
	}
}

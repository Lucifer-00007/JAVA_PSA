package com.marketing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marketing.entity.Registration;

public interface RegistrationRepository extends JpaRepository<Registration, Long>{

}

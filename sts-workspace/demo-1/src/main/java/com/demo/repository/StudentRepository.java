package com.demo.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.demo.entity.Student;

//CRUD Operations - 
//Not Using SQL Queries but using Builtin Methods of Spring 
public interface StudentRepository extends CrudRepository<Student, Long>{
	
	Optional<Student> findByEmail(String email);
}

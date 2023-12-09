package com.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.CrudRepository;

import com.demo.entity.Student;

//CRUD Operations - 
//Not Using SQL Queries but using Builtin Methods of Spring ie. 'CrudRepository' 
//public interface StudentRepository extends CrudRepository<Student, Long>{


//Using advance version of 'CrudRepository' ie. 'JpaRepository' 
public interface StudentRepository extends JpaRepository<Student, Long>{
	Optional<Student> findByEmail(String email);
}

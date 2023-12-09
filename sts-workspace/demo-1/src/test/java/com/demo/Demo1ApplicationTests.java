package com.demo;


import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.demo.entity.Student;
import com.demo.repository.StudentRepository;

@SpringBootTest
class Demo1ApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	private StudentRepository studentRepo;

	
//-----------------------------------(using CrudRepository)---------------------------------------------//	
//	@Test
//	public void saveStudent() {
//		Student s = new Student();
//		s.setId(2);
//		s.setName("mike");
//		s.setEmail("mike@gmail.com");
//		s.setFee(1000);
//		
//		studentRepo.save(s);
//		System.out.println(s.getEmail());
//	}

	
//	@Test
//	public void deleteStudent() {		
//		studentRepo.deleteById(1L); //Inside deleteById() pass the rowId-&-DataType 
//	}

	
//	@Test
//	public void updateStudent() {
//		Student s = new Student();
//		s.setId(2);
//		s.setName("mike1");
//		s.setEmail("mike1@gmail.com");
//		s.setFee(1000);
//		
//		studentRepo.save(s);
//	}


//	@Test
//	void studentExistById() {
//		boolean existsById = studentRepo.existsById(10L);
//		System.out.println(existsById);
//	}
	
	
//	@Test
//	void getStudentById() {
//		//Optional class is a JAVA 8 feature.
//		//It helps us to handle null pointer exception.
//		Optional<Student> findById = studentRepo.findById(2L);
//		System.out.println(findById.isPresent());
//	
//		if(findById.isPresent()) {
//			Student s1 = findById.get();
//			System.out.println(s1.getId());
//			System.out.println(s1.getName());
//			System.out.println(s1.getEmail());
//			System.out.println(s1.getFee());
//		}else {
//			System.out.println("No record Found!");
//		}
//	}

	
//	@Test
//	void getAllStudents() {
//		Iterable<Student> findAll = studentRepo.findAll();
//		System.out.println(findAll);
//		
//		for (Student student : findAll) {
//			System.out.println(student.getId());
//			System.out.println(student.getName());
//			System.out.println(student.getEmail());
//			System.out.println(student.getFee());
//		}		
//	}

	
//	@Test
//	public void getStudentByEmail() {
//		Optional<Student> findByEmail = studentRepo.findByEmail("ram@gmail.com");
//		
//		Student student = findByEmail.get();
//		System.out.println(student.getId());
//		System.out.println(student.getName());
//		System.out.println(student.getEmail());
//		System.out.println(student.getFee());
//	}
	
//----------------------------------------------------------------------------------------------//

	
//-----------------------------------(using JpaRepository)---------------------------------------------//	
	@Test
	public void getAllStudent() {
	    // Setting up pagination for fetching the first page with 3 elements.
		// Also sorting the data in Ascending with 'name' field. 
	    Pageable pageable = PageRequest.of(0, 3, Sort.by("name"));

	    //List<Student> findAll = studentRepo.findAll();
	    
	    // Fetching a page of students from the repository using pagination
	    Page<Student> findAll = studentRepo.findAll(pageable);

	    // Extracting the list of students from the page
	    List<Student> students = findAll.getContent();

	    // Iterating through the list of students and printing their details
	    for (Student student : students) {
	        // Printing student ID
	        System.out.println("Student ID: " + student.getId());

	        // Printing student name
	        System.out.println("Student Name: " + student.getName());

	        // Printing student email
	        System.out.println("Student Email: " + student.getEmail());

	        // Printing student fee
	        System.out.println("Student Fee: " + student.getFee());
	    }
	    
	    
	    // Printing additional information about the fetched page
	    System.out.println("Total Pages: " + findAll.getTotalPages()); // Total pages available
	    System.out.println("Is Last Page: " + findAll.isLast()); // Check if it's the last page
	    System.out.println("Page Size: " + findAll.getSize()); // Number of elements on the current page
	    System.out.println("Is First Page: " + findAll.isFirst()); // Check if it's the first page
	    System.out.println("Total Elements: " + findAll.getTotalElements()); // Total number of elements across all pages
	}

	
	
	
	
	
	
//----------------------------------------------------------------------------------------------//
	
}

package com.demo;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.entity.Student;
import com.demo.repository.StudentRepository;

@SpringBootTest
class Demo1ApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	private StudentRepository studentRepo;

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
	
	@Test
	public void getStudentByEmail() {
		Optional<Student> findByEmail = studentRepo.findByEmail("ram@gmail.com");
		
		Student student = findByEmail.get();
		System.out.println(student.getId());
		System.out.println(student.getName());
		System.out.println(student.getEmail());
		System.out.println(student.getFee());
	}
	

}

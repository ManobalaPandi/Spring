package com.switchcode.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.switchcode.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> Students;
	
	@PostConstruct
	public void loadData() {
		
	Students = new ArrayList<>();
		
		Students.add(new Student("mano","bala"));
		Students.add(new Student("moni","kutty"));
		Students.add(new Student("deva","sena"));
	}
	
	@GetMapping("/Students")
	public List<Student> getStudents () {
				
		return Students;
	}
	
	@GetMapping("/Students/{studentId}")
	public Student getStudent (@PathVariable int studentId) {
				
		if (studentId >=Students.size() || studentId<0) {
			throw new StudentNotFoundException("Student not found");
		}
		return Students.get(studentId);
	}
	

}
